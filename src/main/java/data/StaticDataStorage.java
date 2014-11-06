package data;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import repositories.InMemoryPlanRepository;
import service.PersonService;
import service.PlanRepository;
import service.PlanService;
import models.Identifier;
import models.Participation;
import models.Plan;
import models.Person;

public class StaticDataStorage {
	
	private static StaticDataStorage instance;
	private final PlanService service;
	
	private List<Participation> participations;
	private Plan plan;
	private Participation participation;
	private List<Person> persons;
	private List<Plan> plans = new ArrayList<Plan>();
	
	public StaticDataStorage(){
		
		persons = new ArrayList<Person>();
		participations = new ArrayList<Participation>();
	
		Person user = new Person("Paul", "Vaillant", "pvaillant@hotmail.com");
		participation = new Participation(user, 10);
		participations.add(participation);
		persons.add(user);
		user = new Person("Nero", "Rajan", "nrajan@hotmail.com");
		participation = new Participation(user, 50);
		participations.add(participation);
		persons.add(user);
		user = new Person("Quentin", "Chou", "qchou@hotmail.com");
		participation = new Participation(user, 20);
		participations.add(participation);
		persons.add(user);
		user = new Person("Marie", "Flou", "mflou@hotmail.com");
		participation = new Participation(user, 10);
		participations.add(participation);
		persons.add(user);
		plan = new Plan("KDO Lise", new Date(), 80);
		plan.setParticipations(participations);
		plans.add(plan);
	

		PlanRepository repository = new InMemoryPlanRepository(plans, persons);
		this.service = new PlanService(repository);
	}
	
	public static PlanService service() {
		if(instance == null) {
			instance = new StaticDataStorage();
		}
		
		return instance.service;
	}

	public List<Plan> getPlans() {
		return plans;
	}


	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}


	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public Participation getParticipation() {
		return participation;
	}

	public void setParticipation(Participation participation) {
		this.participation = participation;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	
	public List<Person> getPersons() {
		return persons;
	}


	public void setUsers(List<Person> persons) {
		this.persons = persons;
	}


	public void addPerson(Person person) {
		
		if(person != null)
			this.persons.add(person);
	}
	
	public void addPlan(Plan plan)
	{
		this.plans.add(plan);
	}
	
	public Plan getPlanById(Identifier id)
	{
		for(Plan plan : this.plans)
		{
			if(plan.getId().equals(id))
				return plan;
		}
		
		return null;
	}
	
	public Person getUserById(int id)
	{
		for(Person person  : this.persons)
		{
			if(person.getId().equals(id))
				return person;
		}
		
		return null;
	}
	
	public void deletePersonById(int id)
	{
		Person toDelete = null;
		for(Person person  : this.persons)
		{
			if(person.getId().equals(id))
				toDelete = person;
		}
		
		if(toDelete != null)
		{
			this.persons.remove(toDelete);
		}
	}

	public boolean exists(int idPers) {
		
		return (this.getUserById(idPers) != null) ? true : false;
	}
	
	public void deleteParticipationOfPerson(Person person)
	{
		Participation participationToDelete = null;
		
		for(Plan plan : this.plans)
		{
			for(Participation participation : plan.getParticipations())
			{
				if(participation.getPerson().equals(person))
					participationToDelete = participation;
			}
			
			if(participationToDelete != null)
				plan.getParticipations().remove(participationToDelete);
		}
	}

	public boolean exists(Identifier idPlan) {
		return (this.getPlanById(idPlan) != null) ? true : false;
	}

	public void deletePlan(Identifier idPlan) {

		Plan planToDelete = null;
		
		for(Plan plan : this.plans)
		{
			if(plan.getId().equals(idPlan))
				planToDelete = plan;
		}
		
		if(planToDelete != null)
			this.plans.remove(planToDelete);
	}

	public boolean alreadyExist(String email) {

		for(Person person : this.persons)
		{
			if(person.getEmail().equals(email))
			{
				return true;
			}
		}

		return false;
	}
}
