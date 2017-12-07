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
	long sequence = 1;

	@Override
	public Desire getById(long id) {
		return dataBase.get(id);
	}

	@Override
	public void addOrUpdate(Desire desire) {
		if (desire.getId() == 0) {
			desire.setId(sequence);
			sequence++;
		}
		dataBase.put(desire.getId(), desire);
	}

	@Override
	public void delete(Desire desire) {
		dataBase.remove(desire.getId());
	}

	@Override
	public List<Desire> getAllDesires() {
		List<Desire> allDesires = new ArrayList<Desire>();
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
