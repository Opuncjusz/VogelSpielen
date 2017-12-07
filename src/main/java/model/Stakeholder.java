package model;

public class Stakeholder {

	private String id;
	private String clientMobileToken;

	public Stakeholder(String userId) {
		this.id = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientMobileToken() {
		return clientMobileToken;
	}

	public void setClientMobileToken(String clientMobileToken) {
		this.clientMobileToken = clientMobileToken;
	}

}
