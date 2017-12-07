package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import common.MatchTO;
import model.Stakeholder;
import service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	@Override
	public List<MatchTO> getAllMatchesByStakeholder(Stakeholder stakeholder) {
		return new ArrayList<MatchTO>();
		// return
		// mapEntitiesToTOs(desireRepository.getAllDesiresByStakeholder(stakeholder));
	}

}
