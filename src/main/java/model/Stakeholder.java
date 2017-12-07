package model;

public class Stakeholder {

	private String clientMobileToken;

	public Stakeholder(String clientMobileToken) {
		this.clientMobileToken = clientMobileToken;
	}

	public String getClientMobileToken() {
		return clientMobileToken;
	}

	public void setClientMobileToken(String clientMobileToken) {
		this.clientMobileToken = clientMobileToken;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientMobileToken == null) ? 0 : clientMobileToken.hashCode());
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
		Stakeholder other = (Stakeholder) obj;
		if (clientMobileToken == null) {
			if (other.clientMobileToken != null)
				return false;
		} else if (!clientMobileToken.equals(other.clientMobileToken))
			return false;
		return true;
	}

}
