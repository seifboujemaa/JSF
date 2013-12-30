package jsfproject.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Game;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.game.GameServicesLocal;
@ManagedBean
@ViewScoped
public class TournamentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private GameServicesLocal localGame ; 
	
	private List<Game> gamesA  = new ArrayList<Game>();
	private List<Game> gamesB  = new ArrayList<Game>();
	private List<Game> gamesC  = new ArrayList<Game>();
	private List<Game> gamesD  = new ArrayList<Game>();
	
	private List<Game> game1_8 = new ArrayList<Game>();
	private List<Game> game1_4 = new ArrayList<Game>();
	private List<Game> game1_2 = new ArrayList<Game>();
	private List<Game> game1_1 = new ArrayList<Game>();
	
	private Game game  = new Game();

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
	
	

	public List<Game> getGamesA() {
		return gamesA;
	}

	public void setGamesA(List<Game> gamesA) {
		this.gamesA = gamesA;
	}

	public List<Game> getGamesB() {
		return gamesB;
	}

	public void setGamesB(List<Game> gamesB) {
		this.gamesB = gamesB;
	}

	public List<Game> getGamesC() {
		return gamesC;
	}

	public void setGamesC(List<Game> gamesC) {
		this.gamesC = gamesC;
	}

	public List<Game> getGamesD() {
		return gamesD;
	}

	public void setGamesD(List<Game> gamesD) {
		this.gamesD = gamesD;
	}
	

	public List<Game> getGame1_8() {
		return game1_8;
	}

	public void setGame1_8(List<Game> game1_8) {
		this.game1_8 = game1_8;
	}

	public List<Game> getGame1_4() {
		return game1_4;
	}

	public void setGame1_4(List<Game> game1_4) {
		this.game1_4 = game1_4;
	}

	public List<Game> getGame1_2() {
		return game1_2;
	}

	public void setGame1_2(List<Game> game1_2) {
		this.game1_2 = game1_2;
	}

	public List<Game> getGame1_1() {
		return game1_1;
	}

	public void setGame1_1(List<Game> game1_1) {
		this.game1_1 = game1_1;
	}

	public TournamentBean() {
		
	}
	@PostConstruct
	public  void init(){
		gamesA = localGame.findGameByGroup("A");
		gamesB = localGame.findGameByGroup("B");
		gamesC = localGame.findGameByGroup("C");
		gamesD = localGame.findGameByGroup("D");	
		
		game1_8 = localGame.findGameByType("1/8");
		game1_4 = localGame.findGameByType("1/4");
		game1_2 = localGame.findGameByType("1/2");
		game1_1 = localGame.findGameByType("1/1");
	}
	
	
	

}
