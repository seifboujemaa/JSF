package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.player;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;

/**
 * Session Bean implementation class PlayerServices
 */
@Stateless
public class PlayerServices implements PlayerServicesRemote, PlayerServicesLocal {
	@PersistenceContext

    /**
     * Default constructor. 
     * 
     */
	EntityManager entityManager ;

    public PlayerServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createPlayer(Player player) {
		entityManager.persist(player);

	}

	@Override
	public void updatePlayer(Player player) {
		entityManager.merge(player);
		
	}

	@Override
	public void deletePlayer(Player player) {
		entityManager.remove(entityManager.merge(player));
		
	}

	@Override
	public Player findPlayerById(int idPlayer) {
		Player player =entityManager.find(Player.class, idPlayer);
		return player;
	}

	@Override
	public List<Player> findAllPlayer() {
		Query query=entityManager.createQuery("select p from Player p");
		return query.getResultList();
	}

	@Override
	public List<Player> findPlayerByTeam(int  idTeam) {
		Query query=entityManager.createQuery("select g from Player g where team_idTeam='" + idTeam + "'  " );
		return query.getResultList();	
	}

}
