package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity
@XmlRootElement
public class Player implements Serializable {

	
	private int intPlayer;
	private String firstName;
	private String lastName;
	private int yellowCards;
	private int redCards;
	private int goals;
	private int playTime;
	
	private Agent agent;
	private Team team;
	private static final long serialVersionUID = 1L;

	public Player() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public int getIntPlayer() {
		return this.intPlayer;
	}

	public void setIntPlayer(int intPlayer) {
		this.intPlayer = intPlayer;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public int getYellowCards() {
		return this.yellowCards;
	}

	public void setYellowCards(int yellowCards) {
		this.yellowCards = yellowCards;
	}   
	public int getRedCards() {
		return this.redCards;
	}

	public void setRedCards(int redCards) {
		this.redCards = redCards;
	}   
	public int getGoals() {
		return this.goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}   
	public int getPlayTime() {
		return this.playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}
	@ManyToOne
	public Agent getAgent() {
		return agent;
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	@ManyToOne
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
   
	
}
