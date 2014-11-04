package models;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class Plan {
	
	private Id id;
	private String title;
	private List<Person> users;
	private Date date;
	private double amount;

	public Plan(){}
	
	public Plan(String title, List<Person> users, Date date, double amount)
	{
		this.id = Id.generate();
		
		this.title = title;
		this.users = users;
		this.date = date;
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Person> getUsers() {
		return users;
	}

	public void setUsers(List<Person> users) {
		this.users = users;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
