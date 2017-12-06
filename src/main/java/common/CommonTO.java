package common;

public class CommonTO {

	public static final long STATUS_SEARCH = 0;
	public static final long STATUS_PENDING = 1;
	public static final long STATUS_FOUND = 2;

	private long id;
	private long statusId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

}
