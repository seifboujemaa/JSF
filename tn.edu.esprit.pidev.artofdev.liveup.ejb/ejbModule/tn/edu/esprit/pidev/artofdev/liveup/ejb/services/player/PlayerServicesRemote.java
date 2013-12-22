package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.player;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;


@Remote
public interface PlayerServicesRemote {
	public void createPlayer(Player player);
	public void updatePlayer(Player player);
	public void deletePlayer(Player player);
	public Player findPlayerById(int idPlayer);
	public List<Player> findAllPlayer();
	public List<Player> findPlayerByTeam(int idTeam);

}
