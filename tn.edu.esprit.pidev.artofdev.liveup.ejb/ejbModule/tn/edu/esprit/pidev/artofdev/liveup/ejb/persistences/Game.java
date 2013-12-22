package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Game
 *
 */
@Entity
@XmlRootElement
public class Game implements Serializable {

	
	private int idGame;
	private int team1Goals;
	private int team2Goals;
	private Date date;
	private String time;
	private String refree;
	private String type;
	private String groupe;
	
	private Agent agent;
	private Stadium stadium;
	
	
	

	private List<Photo> photos = new ArrayList<Photo>();
	private List<Video> videos = new ArrayList<Video>();
	private List<Event> events = new ArrayList<Event>();
	private List<Team> teams  = new ArrayList<Team>();
	
	private static final long serialVersionUID = 1L;

	public Game() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdGame() {
		return this.idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}
	
	
	public int getTeam1Goals() {
		return team1Goals;
	}
	public void setTeam1Goals(int team1Goals) {
		this.team1Goals = team1Goals;
	}
	public int getTeam2Goals() {
		return team2Goals;
	}
	public void setTeam2Goals(int team2Goals) {
		this.team2Goals = team2Goals;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
    }
	public String getRefree() {
		return refree;
	}
	public void setRefree(String refree) {
		this.refree = refree;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	@OneToMany(mappedBy="game")
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	@OneToMany(mappedBy="game")
	public List<Photo> getPhotos() {
		return photos;
	}
	
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	@ManyToOne
	public Agent getAgent() {
		return agent;
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	@OneToMany(mappedBy="game")
	public List<Event> getEvents() {
		return events;
	}
	
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	@ManyToOne
	public Stadium getStadium() {
		return stadium;
	}
	
	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}
	
	
	@ManyToMany
	public List<Team> getTeams() {
		return teams;
	}
	
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	
	
	/* public void affectGameToTeams(List<Team> teams){
			for(Team team:teams){
				team.setGame(this);
				this.getTeams().add(team);
			}
		}*/
   
}
