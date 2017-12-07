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
        Desire desire = new Desire();
        desire.setStakeholder(stakeholder);
        desireRepository.addOrUpdate(desire);
	}

	@Override
	public void canelDesire(DesireTO desireTO) {
		// TODO Auto-generated method stub

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
            desireTOs.add(DesireTO.from(desire));
        }
        return desireTOs;
    }
}
