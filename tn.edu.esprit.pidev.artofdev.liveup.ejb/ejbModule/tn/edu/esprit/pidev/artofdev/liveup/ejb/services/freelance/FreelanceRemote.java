package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;

@Remote
public interface FreelanceRemote {
	
	
	public void createFreelance(Freelance freelance);
	public void updateFreelance(FreeLance freelance);
	public void deleteFreelance(Freelance freelance);
	public FreeLance findFreelanceById(int idFreelance);
	public List<FreeLance> findAllFreelance(); 
	
	public List<Article> viewArticle();
	public List<News> viewNews();
	public FreeLance authentification(String login,String password);
	public void disconnect();
	public void addArticle(Article article);
	public void addNews(News news);
	public void modifyArticle(Article article);
	public void modifyNews(News news);
	public void deleteArticle(Article article);
	public void deleteNews(News news);


}
