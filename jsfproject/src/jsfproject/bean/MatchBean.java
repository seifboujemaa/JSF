package jsfproject.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Game;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.game.GameServicesLocal;

@ManagedBean
@ViewScoped
public class MatchBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @EJB
	private GameServicesLocal localGame;

	private Game game = new Game();

	private List<Game> games = new ArrayList<Game>();

	public MatchBean() {

	}

	public GameServicesLocal getLocalGame() {
		return localGame;
	}

	public void setLocalGame(GameServicesLocal localGame) {
		this.localGame = localGame;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@PostConstruct
	public void init() {
		games = localGame.findAllGame();

	}

	public String doAddMatch() {

		localGame.createGame(game);
		game = new Game();
		games = localGame.findAllGame();
		return null;
	}

	public String doUpdateMatch() {

		localGame.updateGame(game);
		game = new Game();
		games = localGame.findAllGame();
		return null;
	}

	public String doDeleteMatch() {

		localGame.deleteGame(game);
		game = new Game();
		games = localGame.findAllGame();
		return null;
	}
	
	public String hideAddGameDialog(){
		
		game = new Game();

		return "PF('gameAdd').hide();";
	}

}
