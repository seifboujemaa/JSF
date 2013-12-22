package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.agent;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;

/**
 * Session Bean implementation class AgentServices
 */
@Stateless
public class AgentServices implements AgentServicesRemote, AgentServicesLocal {
@PersistenceContext
    /**
     * Default constructor. 
     */
EntityManager entityManager ;
    public AgentServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createAgent(Agent agent) {
		entityManager.persist(agent);		
	}

	@Override
	public void updateAgent(Agent agent) {
		entityManager.merge(agent);		
	}

	@Override
	public void deleteAgent(Agent agent) {
		entityManager.remove(entityManager.merge(agent));		
	}

	@Override
	public Agent findAgentById(int idAgent) {
		Agent agent = entityManager.find(Agent.class,idAgent );
		return agent ;
	}	


	@Override
	public List<Agent> findAllAgent() {
		Query query=entityManager.createQuery("select e from Agent e");
		return query.getResultList();
	}

}
