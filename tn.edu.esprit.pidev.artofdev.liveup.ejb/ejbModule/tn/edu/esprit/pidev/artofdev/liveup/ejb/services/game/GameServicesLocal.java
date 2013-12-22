package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.game;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Game;


@Local
public interface GameServicesLocal {
	public void createGame(Game game);
	public void updateGame(Game game);
	public void deleteGame(Game game);
	public Game findGameById(int idGame);
	public List<Game> findAllGame();
	public List<Game> findGameByDate(Date date);
	public List<Game> findGameByTeam(String team);
	public List<Game> findGameByGroup(String group);
	public List<Game> findGameByType(String type);

}
