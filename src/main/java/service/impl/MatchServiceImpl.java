package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Desire;
import model.Match;
import model.Stakeholder;
import repository.MatchRepository;
import service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchRepository matchRepository;

	@Override
	public List<Match> getAllMatchesByStakeholder(Stakeholder stakeholder) {
		return matchRepository.getAllMatchesByStakeholder(stakeholder);
	}

	@Override
	public List<Match> getAllNewMatches() {
		return matchRepository.getAllNewMatches();
	}

	@Override
	public void createMatch(List<Desire> desires) {
		// TODO Auto-generated method stub

	}

}
