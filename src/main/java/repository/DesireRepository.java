package repository;

import org.springframework.stereotype.Repository;

import model.Desire;

@Repository
public interface DesireRepository {

	Desire getById(long id);

	void addOrUpdate(Desire desire);

	void delete(Desire desire);

}
