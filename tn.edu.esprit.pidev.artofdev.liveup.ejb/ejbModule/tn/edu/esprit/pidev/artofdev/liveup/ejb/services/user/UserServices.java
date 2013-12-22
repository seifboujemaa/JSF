package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.user;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.User;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
@LocalBean
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext
	EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public UserServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	
	public User authentification( String login,String password) {
		User user =null;
		Query query=entityManager.createQuery("Select u from User u where u.login=:l and u.pwd=:p and u.status=true ");
		
		query.setParameter("l", login).setParameter("p", password);
		try{
			user=(User) query.getSingleResult();
		}catch(Exception e){
			user=null;
		}
		return user;
		
	}

	@Override
	public List<User> findAllAgent() {
		
		Query query=entityManager.createQuery("select u from User u");
		return query.getResultList();
	}

	@Override
	public User authentificationCondition( String login, String password) {
		User user =null;
		Query query=entityManager.createQuery("Select u from User u where u.login=:l and u.pwd=:p and u.status= :s");
		query.setParameter("l", login).setParameter("p", password).setParameter("s", true);
		try{
			user=(User) query.getSingleResult();
		}catch(Exception e){
			user=null;
		}
		return user;
	
	}

	@Override
	public User loginJSF(String login, String password) {
		User user =null;
		Query query=entityManager.createQuery("Select u from User u where u.login=:l and u.pwd=:p ");
		query.setParameter("l", login).setParameter("p", password);
		try{
			user=(User) query.getSingleResult();
		}catch(Exception e){
			user=null;
		}
		return user;
	}
	}

	

	

