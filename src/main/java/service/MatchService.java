package service;

import java.util.List;

import model.Desire;
import model.Match;
import model.Stakeholder;

public interface MatchService {

	List<Match> getAllMatchesByStakeholder(Stakeholder stakeholder);

	List<Match> getAllNewMatches();

	void createMatch(List<Desire> desires);
}
