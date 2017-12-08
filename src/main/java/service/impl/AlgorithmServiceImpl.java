package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.AlgorithmResultDS;
import common.DesireTO;
import common.MatchTO;
import service.AlgorithmService;
import service.DesireService;

@Service
public class AlgorithmServiceImpl implements AlgorithmService {

    public static DateTimeFormatter DEFAULT_DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");;

    @Autowired
    private DesireService desireService;

    @Override
    public void calculate() {

    }

    @Override
    public AlgorithmResultDS calculateBasedOnIncoming(DesireTO incomingDesire) {

        AlgorithmResultDS algorithmResult = new AlgorithmResultDS();

        List<DesireTO> allDesires = desireService.getAllDesires();

        for (DesireTO currentDesire : allDesires) {
            if (checkStakeholderIsDifferent(currentDesire, incomingDesire)
                    && checkTimeWindowExists(currentDesire, incomingDesire)
                    && checkRequiredPeopleEnoughOrLess(currentDesire, incomingDesire)
                    && checkPlaceMatches(currentDesire, incomingDesire)
                    && checkTotalsEqual(currentDesire, incomingDesire)
                    && checkRequiredPeopleMeetsTotal(currentDesire, incomingDesire)) {

                MatchTO match = new MatchTO();
                match.setDesires(new ArrayList());
                match.getDesires().add(incomingDesire);
                match.getDesires().add(currentDesire);
                match.setPlace(incomingDesire.getPlace());

                algorithmResult.setCreatedMatch(match);
                return algorithmResult;
            }
        }

        return algorithmResult;
    }

    private boolean checkStakeholderIsDifferent(DesireTO desire1, DesireTO desire2) {
        return !desire1.getStakeholder().equals(desire2.getStakeholder());
    }

    private boolean checkTimeWindowExists(DesireTO desire1, DesireTO desire2) {
        Interval firstInterval = new Interval(DateTime.parse(desire1.getFrom(), DEFAULT_DATE_FORMAT), DateTime.parse(desire1.getTo(), DEFAULT_DATE_FORMAT));
        Interval secondInterval = new Interval(DateTime.parse(desire2.getFrom(), DEFAULT_DATE_FORMAT), DateTime.parse(desire2.getTo(), DEFAULT_DATE_FORMAT));
        return firstInterval.overlaps(secondInterval);
    }

    private boolean checkTotalsEqual(DesireTO desire1, DesireTO desire2) {
        String total1 = desire1.getTotal();
        String total2 = desire2.getTotal();

        if (total1 == null) {
            total1 = "";
        }

        return total1.equals(total2);
    }

    private boolean checkRequiredPeopleEnoughOrLess(DesireTO desire1, DesireTO desire2) {
        return true;
    }

    private boolean checkPlaceMatches(DesireTO desire1, DesireTO desire2) {
        return desire1.getPlace().equals(desire2.getPlace());
    }

    private boolean checkRequiredPeopleMeetsTotal(DesireTO desire1, DesireTO desire2) {
        int total = Integer.parseInt(desire1.getTotal());
        int firstRequired = Integer.parseInt(desire1.getRequired());
        int secondRequired = Integer.parseInt(desire2.getRequired());
        return (firstRequired + secondRequired) == total;
    }
}
