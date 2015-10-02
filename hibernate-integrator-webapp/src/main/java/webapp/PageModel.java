package webapp;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Person;
import model.PersonRepository;

@Named
@RequestScoped
public class PageModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PersonRepository personRepository;
	
	private String firstname;
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Person> getAllPersons() {
		return personRepository.allPersons();
	}
	
	public String submit() {
		Person person = new Person(firstname, lastname);
		personRepository.savePerson(person);
		
		firstname = "";
		lastname = "";
		
		return null;
	}
}
