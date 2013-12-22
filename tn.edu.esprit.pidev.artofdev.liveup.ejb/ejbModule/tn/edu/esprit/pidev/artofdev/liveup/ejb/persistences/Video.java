package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Video
 *
 */
@Entity
@XmlRootElement
public class Video implements Serializable {

	
	private int idVideo;
	private String url;
	private String description ;
	
	private Reporter reporter;
	private Game game;
	
	private static final long serialVersionUID = 1L;

	public Video() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdVideo() {
		return this.idVideo;
	}

	public void setIdVideo(int idVideo) {
		this.idVideo = idVideo;
	}   
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne
	@XmlTransient
	public Reporter getReporter() {
		return reporter;
	}
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}
	@ManyToOne
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	
   
}
