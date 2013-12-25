package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.user;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.User;

@Local
@Path("/user")
public interface UserServicesLocal {
	@GET
	@Path("/auth")
	@Produces("application/xml")
	public User authentification(String login , String password);
	public User authentificationCondition(String login , String password );
	public User loginJSF (String login,String password);
	public User loginFreeLance(String login ,  String password);
	public List<User> findAllAgent();

}
