package models;

public class Participation {
	
	private Person person;
	private double amount;
	
	public Participation(){}
	
	public Participation(Person person, double amount)
	{
		this.person = person;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Participation [person=" + person + ", amount=" + amount + "]";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
