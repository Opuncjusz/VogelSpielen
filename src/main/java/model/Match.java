package model;

import java.util.Date;
import java.util.List;

public class Match {

	private long id;
	private List<Desire> desires;
	private Date from;
	private Date to;
	private String place;
	private boolean hasBeenSentNotification;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desires == null) ? 0 : desires.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + (hasBeenSentNotification ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		if (desires == null) {
			if (other.desires != null)
				return false;
		} else if (!desires.equals(other.desires))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (hasBeenSentNotification != other.hasBeenSentNotification)
			return false;
		if (id != other.id)
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	public List<Desire> getDesires() {
		return desires;
	}

	public void setDesires(List<Desire> desires) {
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

	public boolean isHasBeenSentNotification() {
		return hasBeenSentNotification;
	}

	public void setHasBeenSentNotification(boolean hasBeenSentNotification) {
		this.hasBeenSentNotification = hasBeenSentNotification;
	}

}
