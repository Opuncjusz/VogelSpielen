package common;

import model.Desire;
import model.Stakeholder;

public class DesireTO {

    public static DesireTO createFromDesire(Desire desire) {
        DesireTO desireTO = new DesireTO();

        desireTO.setId(desire.getId());
        desireTO.setStakeholder(desire.getStakeholder());
        desireTO.setFrom(desire.getFrom());
        desireTO.setPlace(desire.getPlace());
        desireTO.setRequired(desire.getRequired());
        desireTO.setTo(desire.getTo());
        desireTO.setTotal(desire.getTotal());

        return desireTO;
    }

    Long id;

    String place;
    String total;
    String from;
    String to;
    String required;
    Stakeholder stakeholder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((from == null) ? 0 : from.hashCode());
        result = prime * result + ((place == null) ? 0 : place.hashCode());
        result = prime * result + ((required == null) ? 0 : required.hashCode());
        result = prime * result + ((to == null) ? 0 : to.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
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
        DesireTO other = (DesireTO) obj;
        if (from == null) {
            if (other.from != null) {
                return false;
            }
        }
        else if (!from.equals(other.from)) {
            return false;
        }
        if (place == null) {
            if (other.place != null) {
                return false;
            }
        }
        else if (!place.equals(other.place)) {
            return false;
        }
        if (required == null) {
            if (other.required != null) {
                return false;
            }
        }
        else if (!required.equals(other.required)) {
            return false;
        }
        if (to == null) {
            if (other.to != null) {
                return false;
            }
        }
        else if (!to.equals(other.to)) {
            return false;
        }
        if (total == null) {
            if (other.total != null) {
                return false;
            }
        }
        else if (!total.equals(other.total)) {
            return false;
        }
        return true;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public Stakeholder getStakeholder() {
        return stakeholder;
    }

    public void setStakeholder(Stakeholder stakeholder) {
        this.stakeholder = stakeholder;
    }

}
