package jsfproject.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ClientBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public ClientBean() {
		// TODO Auto-generated constructor stub
	}
	public ClientBean(String firstName) {
		super();
		this.firstName = firstName;
	}
	
	public String DoRegister(){
		
		
		return  null;
	}
	
	
	

}
