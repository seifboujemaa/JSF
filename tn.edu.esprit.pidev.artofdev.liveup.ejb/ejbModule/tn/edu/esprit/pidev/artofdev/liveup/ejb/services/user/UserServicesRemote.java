package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.user;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.User;

@Remote
@Path("/user")
public interface UserServicesRemote {
	@GET
	@Path("/auth/{login}/{password}")
	@Produces("application/xml")
	public User authentification(@PathParam("login") String login ,@PathParam("password") String password);
	@GET
	@Path("authentification/{login}/{password}")
	@Produces("application/xml")
	public User authentificationCondition(@PathParam("login") String login ,@PathParam("login") String password );
	public List<User> findAllAgent();

}
