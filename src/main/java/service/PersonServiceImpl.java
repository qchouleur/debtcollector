package service;

	
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PersonDAO;
import models.Person;
 
@Service
public class PersonServiceImpl implements PersonService {
 
    @Autowired
    private PersonDAO personDAO;
     
    @Transactional
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }
 
    @Transactional
    public List<Person> listPerson() {
 
        return personDAO.listPerson();
    }
 
    @Transactional
    public void removePerson(Integer id) {
        personDAO.removePerson(id);
    }
}
