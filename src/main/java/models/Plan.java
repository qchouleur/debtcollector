package models;

import java.util.List;
import java.util.UUID;


public class Plan {
	
	private Id id;
	private String title;
	private List<User> users;
	private String date;
	private double amount;

	public Plan(){}
	
	public Plan(String title, List<User> users, String date, double amount)
	{
		this.id = Id.generate();
		
		this.title = title;
		this.users = users;
		this.date = date;
		this.amount = amount;;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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
