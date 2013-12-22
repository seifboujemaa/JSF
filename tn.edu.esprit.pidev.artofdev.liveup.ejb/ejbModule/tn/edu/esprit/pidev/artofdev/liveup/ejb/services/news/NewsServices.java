package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.news;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;

@Stateless
public class NewsServices implements NewsServicesLocal , NewsServicesRemote {
@PersistenceContext

EntityManager entityManager ;
	
	
	public NewsServices(){
		
	}

	@Override
	public void createNews(News news) {
		entityManager.persist(news);	
		
	}

	@Override
	public void updateNews(News news) {
		entityManager.merge(news);
		
	}

	@Override
	public void deleteNews(News news) {
		entityManager.remove(entityManager.merge(news));		
	}

	@Override
	public News findNewsById(int idNews) {
		News news = entityManager.find(News.class,idNews );
		return news ;
	}

	@Override
	public List<News> findAllNews() {
		Query query=entityManager.createQuery("select n from News n");
		return query.getResultList();
	}

}
