package service;

import java.util.List;

import common.DesireTO;

public interface DesireService {

	void handleIncomingDesire(DesireTO desireTO);

	void canelDesire(DesireTO desireTO);

	List<DesireTO> getAllDesires();

}
