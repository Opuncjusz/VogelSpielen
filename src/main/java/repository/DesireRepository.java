package repository;

import java.util.List;

import model.Desire;
import model.Stakeholder;

public interface DesireRepository {

	Desire getById(long id);

	void addOrUpdate(Desire desire);

	void delete(Desire desire);

    List<Desire> getAllDesires();

    List<Desire> getAllDesiresByStakeholder(Stakeholder stakeholder);

}
