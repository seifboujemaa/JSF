package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Stadium
 *
 */
@Entity
@XmlRootElement
public class Stadium implements Serializable {

	
	private int idStadium;
	private String name;
	private int capacity;
	private String address;
	
	private Agent agent;
	private List<Game> games;
	private static final long serialVersionUID = 1L;

	public Stadium() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public int getIdStadium() {
		return this.idStadium;
	}

	public void setIdStadium(int idStadium) {
		this.idStadium = idStadium;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
   @ManyToOne
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	@OneToMany(mappedBy="stadium")
	public List<Game> getGames() {
		return games;
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	 public void affectStadiumToGames(List<Game> games){
			for(Game game:games){
				game.setStadium(this);
				this.getGames().add(game);
			}
		}
}
