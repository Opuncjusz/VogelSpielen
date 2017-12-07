package repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import model.Desire;
import model.Match;
import model.Stakeholder;
import repository.MatchRepository;

@Repository
public class MatchRepositoryImpl implements MatchRepository {

	private Map<Long, Match> dataBase = new HashMap<Long, Match>();
	long sequence = 1;

	@Override
	public Match getById(long id) {
		return dataBase.get(id);
	}

	@Override
	public void addOrUpdate(Match match) {
		if (match.getId() == 0) {
			match.setId(sequence);
			sequence++;
		}
		dataBase.put(match.getId(), match);
	}

	@Override
	public void delete(Match match) {
		if (match != null) {
			dataBase.remove(match.getId());
		}
	}

	@Override
	public List<Match> getAllMatches() {
		List<Match> allMatches = new ArrayList<>();
		allMatches.addAll(dataBase.values());
		return allMatches;
	}

	@Override
	public List<Match> getAllMatchesByStakeholder(Stakeholder stakeholder) {
		List<Match> matches = new ArrayList<Match>();
		for (Match match : dataBase.values()) {
			for (Desire desire : match.getDesires()) {
				if (desire.getStakeholder().equals(stakeholder)) {
					matches.add(match);
				}
			}

		}
		return matches;
	}

	@Override
	public List<Match> getAllNewMatches() {
		List<Match> matches = new ArrayList<Match>();

		for (Match match : dataBase.values()) {
			if (!match.isHasBeenSentNotification()) {
				matches.add(match);
			}
		}
		return matches;
	}

}
