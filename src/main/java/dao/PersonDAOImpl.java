package dao;

import java.util.List;

import models.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class PersonDAOImpl implements PersonDAO {
 
	@Autowired
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     
    public void save(Person p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
    public List<Person> list() {
        Session session = this.sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
    }

	@Override
	public void addPerson(Person person) {
		sessionFactory.getCurrentSession().save(person);
	}

	@Override
	public List<Person> listPerson() {
		 return sessionFactory.getCurrentSession().createQuery("from Person").list();
	}

	@Override
	public void removePerson(Integer id) {
		Person person = (Person) sessionFactory.getCurrentSession().load(Person.class, id);
        if (null != person) {
            sessionFactory.getCurrentSession().delete(person);
        }
	}
 
}