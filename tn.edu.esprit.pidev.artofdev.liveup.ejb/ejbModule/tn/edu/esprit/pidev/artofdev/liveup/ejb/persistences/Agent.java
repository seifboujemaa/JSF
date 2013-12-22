package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Entity implementation class for Entity: Agent
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@XmlRootElement
public class Agent extends User implements Serializable {
	
	private List<Player> players = new ArrayList<Player>();
	private List<Stadium> stadiums = new ArrayList<Stadium>();
	private List<Team> teams = new ArrayList<Team>();
	private List<Event> events  = new ArrayList<Event>();
	private List<Game> games = new ArrayList<Game>();
 
	private Administrator administrator;
	private static final long serialVersionUID = 1L;

	public Agent() {
		super();
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	@ManyToOne
	public Administrator getAdministrator() {
		return administrator;
	}
     @OneToMany(mappedBy="agent")
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
     @OneToMany(mappedBy="agent")
	public List<Stadium> getStadiums() {
		return stadiums;
	}

	public void setStadiums(List<Stadium> stadiums) {
		this.stadiums = stadiums;
	}
     @OneToMany(mappedBy="agent")
	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
     @OneToMany(mappedBy="agent")
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	@OneToMany(mappedBy="agent")
	public List<Game> getGames() {
		return games;
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}


   
}
