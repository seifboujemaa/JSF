package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.game;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Game;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;


@Remote
public interface GameServicesRemote {
	public void createGame(Game game);
	public void updateGame(Game game);
	public void deleteGame(Game game);
	public Game findGameById(int idGame);
	public List<Game> findAllGame();
	public List<Game> findGameByDate(Date date);
	public List<Game> findGameByTeam(String team);
	public List<Game> findGameByGroup(String group);
	public List<Game> findGameByType(String type);
	public List<Team> findTeamsOnGame(Game game);

}
