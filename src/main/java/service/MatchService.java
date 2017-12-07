package service;

import java.util.List;

import common.MatchTO;
import model.Stakeholder;

public interface MatchService {

	List<MatchTO> getAllMatchesByStakeholder(Stakeholder stakeholder);

}
