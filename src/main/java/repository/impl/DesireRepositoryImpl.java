package repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import model.Desire;
import model.Stakeholder;
import repository.DesireRepository;

@Repository
public class DesireRepositoryImpl implements DesireRepository {

    private Map<Long, Desire> dataBase = new HashMap();

	@Override
	public Desire getById(long id) {
		return dataBase.get(id);
	}

	@Override
	public void addOrUpdate(Desire desire) {
        if (desire.getId() == 0) {
            desire.setId(generateId());
        }
		dataBase.put(desire.getId(), desire);
	}

    private int generateId() {
        return dataBase.size() + 1;
    }

	@Override
	public void delete(Desire desire) {
		dataBase.remove(desire.getId());
	}

    @Override
    public List<Desire> getAllDesires() {
        List<Desire> allDesires = new ArrayList();
        allDesires.addAll(dataBase.values());
        return allDesires;
    }

    @Override
    public List<Desire> getAllDesiresByStakeholder(Stakeholder stakeholder) {
        List desires = new ArrayList();
        for (Desire desire : dataBase.values()) {
            if (desire.getStakeholder().equals(stakeholder)) {
                desires.add(desire);
            }
        }
        return desires;
    }

}
