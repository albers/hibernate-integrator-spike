package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(NameID.class)
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id	private String firstname;
	@Id	private String lastname;

	public Person() {
		this(null, null);
	}

	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
}
