package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Team
 *
 */
@Entity
@XmlRootElement
public class Team implements Serializable {

	
	private int idTeam;
	private String name;
	private int victories;
	private int draws;
	private int defeats;
	private int qualification;
	private String stage ;
	
	private List<Player> players = new ArrayList<Player>();
	
	private Agent agent;
	private List<Game> game;
	private static final long serialVersionUID = 1L;

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public Team() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public int getIdTeam() {
		return this.idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public int getVictories() {
		return this.victories;
	}

	public void setVictories(int victories) {
		this.victories = victories;
	}   
	public int getDraws() {
		return this.draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}   
	public int getDefeats() {
		return this.defeats;
	}

	public void setDefeats(int defeats) {
		this.defeats = defeats;
	}   
	

	public int getQualification() {
		return this.qualification;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}
	@ManyToOne
   public Agent getAgent() {
	return agent;
}
   public void setAgent(Agent agent) {
	this.agent = agent;
}
 @ManyToMany(mappedBy="teams")
   public List<Game> getGame() {
	return game;
}
   public void setGame(List<Game> game) {
	this.game = game;
}
   
   
  
	   
   @OneToMany(mappedBy="team")
   public List<Player> getPlayers() {
	return players;
}
   public void setPlayers(List<Player> players) {
	this.players = players;
}
   
   public void affectTeamToPlayers(List<Player> players){
		for(Player player:players){
			player.setTeam(this);
			this.getPlayers().add(player);
		}
	}
}
