package service;

import java.util.List;

import models.Identifier;
import models.Person;
import models.Plan;

public interface PlanRepository {
	
	void save(Plan plan);
	void remove(Identifier id);
	Plan get(Identifier id);

	List<Plan> find(PlanSpecification specification);
	List<Plan> all();
	List<Person> allPersons();
	void save(Person person);
	void remove(Person person);
	Person getUser(int id);
	void removeById(int id);
	Person getPerson(int idPers);

}
