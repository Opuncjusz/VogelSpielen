package service;

import java.util.List;

import common.DesireTO;
import model.Stakeholder;

public interface DesireService {

    void handleIncomingDesire(Stakeholder stakeholder, DesireTO desireTO);

	void canelDesire(DesireTO desireTO);

	List<DesireTO> getAllDesires();

    List<DesireTO> getAllDesiresByStakeholder(Stakeholder stakeholder);
}
