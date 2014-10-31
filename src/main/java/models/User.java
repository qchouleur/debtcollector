package models;

public class User {
	
	private Id id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private double participation;
	
	public User(){}
	
	public User(String firstName, String lastName, String dateOfBirth, String email, double participation)
	{
		this.id = Id.generate();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.participation = participation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getParticipation() {
		return participation;
	}

	public void setParticipation(double participation) {
		this.participation = participation;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}
	
}
