package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonRepository {

	@PersistenceContext
	private EntityManager em;

	public void savePerson(Person person) {
		em.persist(person);
	}
	
	public List<Person> allPersons() {
		return em.createQuery("SELECT p FROM Person p", Person.class)
				.getResultList();
	}
	
}
