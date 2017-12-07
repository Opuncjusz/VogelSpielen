package common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Desire;
import model.Match;

public class MatchTO {

    private List<DesireTO> desires;
    private long id;
    private Date from;
    private Date to;
    private String place;

    public List<DesireTO> getDesires() {
        return desires;
    }

    public void setDesires(List<DesireTO> desires) {
        this.desires = desires;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MatchTO other = (MatchTO) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    public static MatchTO createFromMatch(Match match) {
        MatchTO matchTO = new MatchTO();
        matchTO.setFrom(match.getFrom());
        matchTO.setId(match.getId());
        matchTO.setPlace(match.getPlace());
        matchTO.setTo(match.getTo());

        List<DesireTO> desireTO = new ArrayList<>();
        for (Desire each : match.getDesires()) {
            desireTO.add(DesireTO.createFromDesire(each));
        }

        matchTO.setDesires(desireTO);

        return matchTO;
    }
}
