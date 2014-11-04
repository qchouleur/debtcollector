package models;

public class Participation {
	
	private Person person;
	private double mount;
	
	public Participation(){}
	
	public Participation(Person person, double mount)
	{
		this.person = person;
		this.mount = mount;
	}

	@Override
	public String toString() {
		return "Participation [person=" + person + ", mount=" + mount + "]";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public double getMount() {
		return mount;
	}

	public void setMount(double mount) {
		this.mount = mount;
	}
}
