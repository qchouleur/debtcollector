package data;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import models.Participation;
import models.Plan;
import models.Person;

public class StaticDataStorage {
	
	private List<Participation> participations;
	private Plan plan;
	private Participation participation;
	private List<Person> users = new ArrayList<Person>();
	
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
		plan = new Plan("KDO Lise", this.participations, new Date(), 80);
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
}
