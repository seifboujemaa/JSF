package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;

@Remote
public interface ChefEditorRemote {
	public void createChefEditor(ChefEditor chefeditor);
	public List<FreeLance> viewFreeLances();
	public List<FreeLance> viewRequest();
	public void acceptFreeLance(FreeLance freeLance);
	public void declineFreeLance(FreeLance freeLance);
	public void deleteFreeLance(FreeLance freeLance);
	public ChefEditor authentification(String login , String password);
	public void appointNews(News news);
	public void appointArticle(Article article);
	public void declineNews(News news);
	public void declineArticle(Article article);
	public List<News> viewNews();
	public List<Article> viewsArticles();
	public List<News> viewNewsUntreated();
	public List<Article> viewArticlesUntreated();
	public void disconnect();
	public List<FreeLance> findAllFreelances();
	public List<News> findAllNews();
	public List<Article> findAllArticles();


}
