package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.news;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;

@Remote
public interface NewsServicesRemote {
	public void createNews(News news);
	public void updateNews(News news);
	public void deleteNews(News news);
	public News findNewsById(int idNews);
	public List<News> findAllNews();

}
