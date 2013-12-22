package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.team;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Game;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;

/**
 * Session Bean implementation class TeamServices
 */
@Stateless
public class TeamServices implements TeamServicesRemote, TeamServicesLocal {
@PersistenceContext
    /**
     * Default constructor. 
     */
EntityManager entityManager ;
    public TeamServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createTeam(Team team) {
		entityManager.persist(team);		
	}

	@Override
	public void updateTeam(Team team) {
entityManager.merge(team);		
	}

	@Override
	public void deleteTeam(Team team) {
		entityManager.remove(entityManager.merge(team));
		
	}

	@Override
	public Team findTeamById(int idTeam) {
		Team team=entityManager.find(Team.class, idTeam);
		return team ;
	}

	@Override
	public List<Team> findAllTeam() {
		Query query=entityManager.createQuery("select t from Team t");
		return query.getResultList();
	}

	@Override
	public Team findTeamByName(String nameTeam) {
		Query query=entityManager.createQuery("select t from Team t where name='"+nameTeam+"' ");
		return (Team) query.getSingleResult();
	}

	@Override
	public List<Team> findTeamByGame(Game game) {
		Query query=entityManager.createQuery("select t from Team t where ");
	
		return query.getResultList();
	}

	@Override
	public List<Team> findTeamByGroup(String stage) {
		Query query=entityManager.createQuery("select t from Team t where stage ='"+stage+"'");
		
		return query.getResultList();
	}
	
	

	@Override
	public List<Game> findGameOnTeam(Team team) {
		Query query=entityManager.createQuery("select game from Team  where idTeam='" + team.getIdTeam() +  "' " );
		return query.getResultList();	
	}

}
