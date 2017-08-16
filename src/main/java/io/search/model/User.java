package io.search.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * Hibernate Search.
 *
 * @author Omar Eisa
 */
@Entity
@Indexed
@Table(name = "user")
public class User {

	// Hibernate Search needs to store the entity identifier in the index for
	// each entity. By default, it will use for this purpose the field marked
	// with Id.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	// You have to mark the fields you want to make searchable annotating them
	// with Field.
	// The parameter Store.NO ensures that the actual data will not be stored in
	// the index (mantaining the ability to search for it): Hibernate Search
	// will execute a Lucene query in order to find the database identifiers of
	// the entities matching the query and use these identifiers to retrieve
	// managed objects from the database.
	@Field(store = Store.NO)
	@Column(name = "first_name")
	private String firstName;

	// store=Store.NO is the default values and could be omitted.
	@Field
	@Column(name = "last_name")
	private String lastName;

	@Field
	@Column(name = "email")
	private String email;

	@Field
	@Column(name = "gender")
	private String gender;

	@Field
	@Column(name = "ip_address")
	private String ipAdress;

	public User() {
		
	}
	

	public User(long id, String firstName, String lastName, String email, String gender, String ipAdress) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.ipAdress = ipAdress;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the ipAdress
	 */
	public String getIpAdress() {
		return ipAdress;
	}

	/**
	 * @param ipAdress the ipAdress to set
	 */
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", ipAdress=" + ipAdress + "]";
	}

	
	
} 
