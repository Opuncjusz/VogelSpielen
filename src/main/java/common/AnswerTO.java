package common;

import java.util.List;

public class AnswerTO {

	private long id;

	private String message;
	private List<DesireTO> desires;
	private List<MatchTO> matches;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DesireTO> getDesires() {
		return desires;
	}

	public void setDesires(List<DesireTO> desires) {
		this.desires = desires;
	}

	public List<MatchTO> getMatches() {
		return matches;
	}

	public void setMatches(List<MatchTO> matches) {
		this.matches = matches;
	}

}
