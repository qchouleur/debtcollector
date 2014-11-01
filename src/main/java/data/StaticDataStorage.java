package data;

import java.util.ArrayList;
import java.util.List;

import models.Plan;
import models.Person;

public class StaticDataStorage {
	
	private List<Person> users;
	private Plan plan;
	
	public StaticDataStorage(){
		
		users = new ArrayList<Person>();
	
		Person user = new Person("Paul", "Vaillant", "12/09/89", "pvaillant@hotmail.com", 30);
		users.add(user);
		user = new Person("Nero", "Rajan", "15/06/89", "nrajaratnam@hotmail.com", 50);
		users.add(user);
		user = new Person("Quentin", "Chou", "12/08/90", "qchou@hotmail.com", 10);
		users.add(user);
		user = new Person("Marie", "Flou", "14/02/91", "mflou@hotmail.com", 0);
		users.add(user);
		
		plan = new Plan("KDO Juju", this.users, "01/11/14", 80);
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
