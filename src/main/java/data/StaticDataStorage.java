package data;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import models.Identifier;
import models.Participation;
import models.Plan;
import models.Person;

public class StaticDataStorage {
	
	private List<Participation> participations;
	private Plan plan;
	private Participation participation;
	private List<Person> users = new ArrayList<Person>();
	private List<Plan> plans = new ArrayList<Plan>();
	
	public StaticDataStorage(){
		
		participations = new ArrayList<Participation>();
	
		Person user = new Person("Paul", "Vaillant", "pvaillant@hotmail.com");
		participation = new Participation(user, 10);
		participations.add(participation);
		users.add(user);
		user = new Person("Nero", "Rajan", "nrajan@hotmail.com");
		participation = new Participation(user, 50);
		participations.add(participation);
		users.add(user);
		user = new Person("Quentin", "Chou", "qchou@hotmail.com");
		participation = new Participation(user, 20);
		participations.add(participation);
		users.add(user);
		user = new Person("Marie", "Flou", "mflou@hotmail.com");
		participation = new Participation(user, 10);
		participations.add(participation);
		users.add(user);
		plan = new Plan("KDO Lise", new Date(), 80);
		plan.setParticipations(participations);
		plans.add(plan);
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

	
	public List<Person> getUsers() {
		return users;
	}


	public void setUsers(List<Person> users) {
		this.users = users;
	}


	public void addPerson(Person person) {
		
		if(person != null)
			this.users.add(person);
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
		for(Person person  : this.users)
		{
			if(person.getId().equals(id))
				return person;
		}
		
		return null;
	}
	
	public void deletePersonById(int id)
	{
		Person toDelete = null;
		for(Person person  : this.users)
		{
			if(person.getId().equals(id))
				toDelete = person;
		}
		
		if(toDelete != null)
		{
			this.users.remove(toDelete);
		}
	}

	public boolean exists(int idPers) {
		
		return (this.getUserById(idPers) != null) ? true : false;
	}
	
	public void deleteParticipationOfPerson(Person person)
	{
		Participation participationToDelete = null;
		
		for(Participation parti : this.participations)
		{
			if(parti.getPerson() == person)
				participationToDelete = parti;
		}
		
		if(participationToDelete != null)
			this.participations.remove(participationToDelete);
	}
}
