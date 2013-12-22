package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Entity implementation class for Entity: User
 *
 */

@Entity
@XmlRootElement
public class User implements Serializable {

	private int idUser;
	private String login ;
	private String pwd ;
	private String firstName;
	private String lastName;
	private String email;
	private Boolean status;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
     @Column(unique=true)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	
	
	
	






	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}











	private static final long serialVersionUID = 1L;

	
   
}
