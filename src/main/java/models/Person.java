package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="PERSON")
public class Person {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotEmpty
	private Integer id;
	@Column(name="firstName")
	@NotEmpty
	private String firstName;
	@Column(name="lastName")
	@NotEmpty
	private String lastName;
	@Column(name="email")
	@NotEmpty
	private String email;
	
	public Person(){}
	
	public Person(String firstName, String lastName, String email)
	{
		//this.id = Id.generate();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email="
				+ email + "]";
	}
	
}
