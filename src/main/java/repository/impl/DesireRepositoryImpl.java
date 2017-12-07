package repository.impl;

import java.util.Map;

import model.Desire;
import repository.DesireRepository;

public class DesireRepositoryImpl implements DesireRepository {

	private Map<Long, Desire> dataBase;

	@Override
	public Desire getById(long id) {
		return dataBase.get(id);
	}

	@Override
	public void addOrUpdate(Desire desire) {
		dataBase.put(desire.getId(), desire);
	}

	@Override
	public void delete(Desire desire) {
		dataBase.remove(desire.getId());
	}

}
