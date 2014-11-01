package dao;

import java.util.List;

import models.Person;

public interface PersonDAO {
	
	public void save(Person p);
	public void addPerson(Person person);
    public List<Person> listPerson();
    public void removePerson(Integer id);
    public List<Person> list();

}
