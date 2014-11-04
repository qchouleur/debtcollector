package data;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import models.Plan;
import models.Person;

public class StaticDataStorage {
	
	private List<Person> users;
	private Plan plan;
	
	public StaticDataStorage(){
		
		users = new ArrayList<Person>();
	
		Person user = new Person("Paul", "Vaillant", "pvaillant@hotmail.com");
		users.add(user);
		user = new Person("Nero", "Rajan", "nrajan@hotmail.com");
		users.add(user);
		user = new Person("Quentin", "Chou", "qchou@hotmail.com");
		users.add(user);
		user = new Person("Marie", "Flou", "mflou@hotmail.com");
		users.add(user);
		
		plan = new Plan("KDO Lise", this.users, new Date(), 80);
	}

	public List<Person> getUsers() {
		return users;
	}

	public void setUsers(List<Person> users) {
		this.users = users;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
}
