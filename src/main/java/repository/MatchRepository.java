package repository;

import java.util.List;

import model.Match;
import model.Stakeholder;

public interface MatchRepository {

	Match getById(long id);

	void addOrUpdate(Match match);

	void delete(Match match);

	List<Match> getAllMatches();

	List<Match> getAllNewMatches();

	List<Match> getAllMatchesByStakeholder(Stakeholder stakeholder);

}
