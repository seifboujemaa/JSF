package jsfproject.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Administrator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.ChefEditor;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.SubscribedClient;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.User;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.user.UserServicesLocal;
@ManagedBean
@SessionScoped
public class AuthentificationBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password ;
	private boolean bool;
	private boolean boolAdministrator;
	private boolean boolReporter;
	private boolean boolAgent;
	private boolean boolClient;
	private boolean boolChefEditor;
	private boolean boolJournalist;
	private boolean boolFreeLance;
	@EJB
	private UserServicesLocal userLocal;
	private User user = new User();
	private String userType;
	
	
	
	
	
	public boolean isBoolAdministrator() {
		return boolAdministrator;
	}
	public void setBoolAdministrator(boolean boolAdministrator) {
		this.boolAdministrator = boolAdministrator;
	}
	public boolean isBoolReporter() {
		return boolReporter;
	}
	public void setBoolReporter(boolean boolReporter) {
		this.boolReporter = boolReporter;
	}
	public boolean isBoolAgent() {
		return boolAgent;
	}
	public void setBoolAgent(boolean boolAgent) {
		this.boolAgent = boolAgent;
	}
	public boolean isBoolClient() {
		return boolClient;
	}
	public void setBoolClient(boolean boolClient) {
		this.boolClient = boolClient;
	}
	public boolean isBoolChefEditor() {
		return boolChefEditor;
	}
	public void setBoolChefEditor(boolean boolChefEditor) {
		this.boolChefEditor = boolChefEditor;
	}
	public boolean isBoolJournalist() {
		return boolJournalist;
	}
	public void setBoolJournalist(boolean boolJournalist) {
		this.boolJournalist = boolJournalist;
	}
	public boolean isBoolFreeLance() {
		return boolFreeLance;
	}
	public void setBoolFreeLance(boolean boolFreeLance) {
		this.boolFreeLance = boolFreeLance;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public UserServicesLocal getUserLocal() {
		return userLocal;
	}
	public void setUserLocal(UserServicesLocal userLocal) {
		this.userLocal = userLocal;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isBool() {
		return bool;
	}
	public void setBool(boolean bool) {
		this.bool = bool;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthentificationBean(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public AuthentificationBean() {
		
		boolAdministrator = false;
		boolAgent = false;
		boolChefEditor = false;
		boolJournalist = false;
		boolReporter = false;
		boolFreeLance = false;
		boolClient = false;
		
	}
	public String doLogin() {
//		bool = false;
//		String msg = null;
//		if (login.equals("seif")&&password.equals("seif")){
//			bool = true;
//			msg ="/pages/administrator/createAdmin?faces-redirect=true" ;
//		}
//		else {
//			//FacesMessage message = new FacesMessage("please Verify your entries !");
//			//FacesContext.getCurrentInstance().addMessage("form23:loginSubmit", message);
//			
//		}
//		return msg;
		
		boolAdministrator = false;
		String nav = null;
		user = userLocal.loginJSF(user.getLogin(), user.getPwd());
		if(user != null){
			bool =  true ;
			if (user instanceof Administrator) {
				userType = "Administrator";
				boolAdministrator = true;
				nav = "/pages/administrator/adminPage?faces-redirect=true";
			}
			if (user instanceof Reporter) {
				userType = "Reporter";
				boolReporter = true;
				nav = "/pages/Reporter/reporterHome?faces-redirect=true";
			}
			if (user instanceof ChefEditor) {
				userType = "ChefEditor";
				boolChefEditor = true;
				nav = "/pages/ChefEditor/chefEditorHome?faces-redirect=true";
			}
			if (user instanceof SubscribedClient) {
				userType = "Client";
				boolClient = true;
				nav = "/pages/Client/clientHome?faces-redirect=true";
			}
			if (user instanceof Journalist) {
				userType = "Journalist";
				boolJournalist = true;
				nav = "/pages/Journalist/journalistHome?faces-redirect=true";
			}
			if (user instanceof FreeLance) {
				userType = "FreeLance";
				boolFreeLance = true ;
				nav = "/pages/FreeLance/freeLanceHome?faces-redirect=true";
			}
			if (user instanceof Agent) {
				userType = "Agent";
				boolAgent = true ;
				nav = "/pages/Agent/agentHome?faces-redirect=true";
			}
			
		}
		else
		{
			
		return "register?faces-redirect=true";
		}
		
		return nav ;
			
	}
	
	public String doLogout(){
		bool =  false;
//		login = null ; 
//		password = null ;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "/register?faces-redirect=true";
		
		
	}
	
	

}