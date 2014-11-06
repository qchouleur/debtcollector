package repositories;

import java.util.ArrayList;
import java.util.List;

import service.PlanRepository;
import service.PlanSpecification;
import models.Identifier;
import models.Person;
import models.Plan;

public class InMemoryPlanRepository implements PlanRepository{
	
	private List<Plan> datasource;
	private List<Person> datapersons;

	public InMemoryPlanRepository() {
		this.datasource = new ArrayList<Plan>();
		this.setDatapersons(new ArrayList<Person>());
	}
	
	public InMemoryPlanRepository(List<Plan> datasource, List<Person> datapersons) {
		if(datasource == null) {
			throw new IllegalArgumentException("The datasource cannot be null.");
		}
		if(datapersons == null) {
			throw new IllegalArgumentException("The dataperson cannot be null.");
		}
			
		this.datasource = datasource;
		this.setDatapersons(datapersons);
	}

	@Override
	public void save(Plan plan) {
		
		Plan planToDelete = null;
		
		if(!datasource.contains(plan.getId())) {
			datasource.add(plan);
		} else {
			for(Plan tmpPlan : this.datasource)
			{
				if(tmpPlan.getId().equals(plan.getId()))
				{
					planToDelete = tmpPlan;
				}
			}
			if(planToDelete != null)
			{
				datasource.remove(planToDelete);
				datasource.add(plan);
			}
		}		
	}

	@Override
	public void remove(Identifier id) {
		
		Plan planToDelete = null;
		
		for(Plan tmpPlan : this.datasource)
		{
			if(tmpPlan.getId().equals(id))
			{
				planToDelete = tmpPlan;
			}
		}
		
		if(planToDelete != null)
			datasource.remove(planToDelete);
	}

	@Override
	public Plan get(Identifier id) {
		
		for(Plan tmpPlan : this.datasource)
		{
			if(tmpPlan.getId().equals(id))
			{
				return tmpPlan;
			}
		}
		
		return null;
	}

	@Override
	public List<Plan> find(PlanSpecification specification) {
		
		List<Plan> results = new ArrayList<Plan>();
		
		for(Plan plan : this.datasource) {
			if(specification.isSatisfiedBy(plan)) {
				results.add(plan);
			}
		}

		return results;
	}

	@Override
	public List<Plan> all() {
		return datasource;
	}

	public List<Person> getDatapersons() {
		return datapersons;
	}

	public void setDatapersons(List<Person> datapersons) {
		this.datapersons = datapersons;
	}

	@Override
	public List<Person> allPersons() {
		
		return datapersons;
	}

	@Override
	public void save(Person person) {
		this.datapersons.add(person);
	}

	@Override
	public void remove(Person person) {
		this.datapersons.remove(person);
		
	}

	
}
