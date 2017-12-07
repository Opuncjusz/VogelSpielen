package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.MatchTO;
import model.Match;
import model.Stakeholder;
import repository.MatchRepository;
import service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public List<MatchTO> getAllMatchesByStakeholder(Stakeholder stakeholder) {
        return mapEntitiesToTOs(matchRepository.getAllMatchesByStakeholder(stakeholder));
    }

    @Override
    public List<MatchTO> getAllNewMatches() {
        return mapEntitiesToTOs(matchRepository.getAllNewMatches());
    }

    @Override
    public void addOrUpdateMatch(MatchTO matchTO) {
        Match match = Match.createFromMatchTO(matchTO);
        matchRepository.addOrUpdate(match);
    }

    private List<MatchTO> mapEntitiesToTOs(List<Match> matchEntities) {
        List<MatchTO> matchTOs = new ArrayList();
        for (Match match : matchEntities) {
            matchTOs.add(MatchTO.createFromMatch(match));
        }
        return matchTOs;
    }

}
