package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.DesireTO;
import model.Desire;
import model.Stakeholder;
import repository.DesireRepository;
import service.DesireService;

@Service
public class DesireServiceImpl implements DesireService {

	@Autowired
	DesireRepository desireRepository;

	@Override
	public void handleIncomingDesire(Stakeholder stakeholder, DesireTO desireTO) {
		Desire desire = Desire.createFromDesireTO(stakeholder, desireTO);
		desireRepository.addOrUpdate(desire);
	}

	@Override
	public void canelDesire(DesireTO desireTO) {
		Desire desire = desireRepository.getById(desireTO.getId());
		desireRepository.delete(desire);
	}

	@Override
	public List<DesireTO> getAllDesires() {
		return mapEntitiesToTOs(desireRepository.getAllDesires());
	}

	@Override
	public List<DesireTO> getAllDesiresByStakeholder(Stakeholder stakeholder) {
		return mapEntitiesToTOs(desireRepository.getAllDesiresByStakeholder(stakeholder));
	}

	private List<DesireTO> mapEntitiesToTOs(List<Desire> desireEntities) {
		List<DesireTO> desireTOs = new ArrayList();
		for (Desire desire : desireEntities) {
			desireTOs.add(DesireTO.createFromDesire(desire));
		}
		return desireTOs;
	}
}
