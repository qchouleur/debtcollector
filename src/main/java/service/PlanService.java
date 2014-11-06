package service;

import java.util.List;

import models.Identifier;
import models.Person;
import models.Plan;

public class PlanService {

	private PlanRepository repository;
	
	public PlanService(PlanRepository repository) {
		this.repository = repository;
	}
	
	public void create(Plan plan) {
		repository.save(plan);
	}
	
	public void update(Plan plan) {
		repository.save(plan);
	}
	
	public void remove(Identifier id) {
		repository.remove(id);
	}
	
	public boolean exists(Identifier id) {
		return repository.get(id) != null;
		
	}
	
	public Plan getById(Identifier id) {
		return repository.get(id);
	}
	
	public List<Plan> find(PlanSpecification specification) {
		return repository.find(specification);
	}

	public List<Plan> all() {
		return repository.all();
	}
	
	public List<Person> allPersons() {
		return repository.allPersons();
	}
	
	public void update(Person person) {
		repository.save(person);
	}
	
	public void remove(Person person) {
		repository.remove(person);
	}
}
