package service;

import java.util.List;

import models.Person;

public interface PersonService {

	public void addPerson(Person person);
    public List<Person> listPerson();
    public void removePerson(Integer id);
    
}
