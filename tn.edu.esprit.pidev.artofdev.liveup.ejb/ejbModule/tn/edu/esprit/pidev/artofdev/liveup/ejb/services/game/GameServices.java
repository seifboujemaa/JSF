package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.game;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Game;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;


/**
 * Session Bean implementation class GameServices
 */
@Stateless
public class GameServices implements GameServicesRemote, GameServicesLocal {

@PersistenceContext
	
	EntityManager entityManager ;

    /**
     * Default constructor. 
     */
    public GameServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createGame(Game game) {
		entityManager.persist(game);
	}

	@Override
	public void updateGame(Game game) {
		entityManager.merge(game);
		
	}

	@Override
	public void deleteGame(Game game) {
		entityManager.remove(entityManager.merge(game));
		
	}

	@Override
	public Game findGameById(int idGame) {
		Game game =entityManager.find(Game.class, idGame);
		return game;
	}

	@Override
	public List<Game> findAllGame() {
		Query query=entityManager.createQuery("select g from Game g");
		return query.getResultList();
	}

	@Override
	public List<Game> findGameByDate(Date date ) {
		Query query=entityManager.createQuery("select g from Game g where date='" + date +  "' " );
		return query.getResultList();			
	}

	@Override
	public List<Game> findGameByTeam(String team) {
		Query query=entityManager.createQuery("select e from Game g where team1='" + team + "' or team2='" + team + "' " );
		return query.getResultList();	
	}

	@Override
	public List<Game> findGameByGroup(String group) {
		Query query=entityManager.createQuery("select g from Game g where groupe='" + group +  "' " );
		return query.getResultList();			
	}
	

	@Override
	public List<Game> findGameByType(String type) {
		Query query=entityManager.createQuery("select g from Game g where type='" + type +  "' " );
		return query.getResultList();			
	}

	@Override
	public List<Team> findTeamsOnGame(Game game) {
		Query query=entityManager.createQuery("select teams from Game  where idGame='" + game.getIdGame() +  "' " );
		return query.getResultList();			
		
	}
	
	

}
