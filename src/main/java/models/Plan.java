package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class Plan {
	
	private Identifier id;
	@NotEmpty
	private String title;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;
	private double amount;
	private List<Participation> participations = new ArrayList<Participation>();

	public Plan(){}
	
	public Plan(String title, Date date, double amount)
	{
		this.id = Identifier.generate();
		
		this.title = title;
		this.date = date;
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Identifier getId() {
		return id;
	}

	public void setId(Identifier id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public List<Person> getParticipationPersons()
	{
		List<Person> persons = new ArrayList<Person>();
		
		for(Participation participation : this.participations)
		{
			persons.add(participation.getPerson());
		}
		
		return persons;
	}
	
	public void addParticipation(Participation participation)
	{
		this.participations.add(participation);
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}
}
