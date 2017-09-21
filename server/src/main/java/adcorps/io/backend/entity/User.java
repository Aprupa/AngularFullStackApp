package adcorps.io.backend.entity;

/* This entity class allows registration of user and query on users */

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


//Allows us to map it to Entity, Table and create Named Queries.

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "Select u from User u"),
	@NamedQuery(name = "User.findById", query = "Select u from User u where u.userID = :id "),
	@NamedQuery(name = "User.findByEmail",query = "Select u from User u where u.email = :email")
})
public class User {
		
	//Private User Information Variables
	
	@Id
	private String userID; //Helps Us defining Primary key of Table Users
	
	private String firstName;
	private String lastName;
	
	@Column(unique = true)
	private String email; //Helps us identifying user email id's. Allows every entry to unique.
	
	private String password;
	
	//Generate Unique userID
	public User(){
		userID = UUID.randomUUID().toString();
	}
	
	//User Getter and Setter Functions
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
