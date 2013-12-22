package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Entity implementation class for Entity: Journalist
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@XmlRootElement
public class Journalist extends User implements Serializable {

	private List<News> news= new ArrayList<News>();
	private List<Article> articles = new ArrayList<Article>();
	
	private ChefEditor chefEditor;
	
	private static final long serialVersionUID = 1L;

	public Journalist() {
		super();
	}
    @OneToMany(mappedBy="journalist")
	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}
	@OneToMany(mappedBy="journalist")
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	@ManyToOne
	public ChefEditor getChefEditor() {
		return chefEditor;
	}
	public void setChefEditor(ChefEditor chefEditor) {
		this.chefEditor = chefEditor;
	}
	
	
   
}
