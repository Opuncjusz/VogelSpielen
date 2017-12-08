package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import common.AlgorithmResultDS;
import common.DesireTO;
import common.MatchTO;
import service.AlgorithmService;
import service.DesireService;

@Service
public class AlgorithmServiceImpl implements AlgorithmService {

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
					&& checkTotalEqual(currentDesire, incomingDesire)) {

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
		return true;
	}

	private boolean checkTotalEqual(DesireTO desire1, DesireTO desire2) {
		String total1 = desire1.getTotal();
		String total2 = desire2.getTotal();

		if (StringUtils.isEmpty(total1)) {
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
}
