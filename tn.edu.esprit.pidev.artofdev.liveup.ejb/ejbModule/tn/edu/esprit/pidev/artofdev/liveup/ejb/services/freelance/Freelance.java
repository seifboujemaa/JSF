package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;

/**
 * Session Bean implementation class Freelance
 */
@Stateless

public class Freelance implements FreelanceRemote, FreelanceLocal {
@PersistenceContext
EntityManager entityManager ;
    /**
     * Default constructor. 
     */
    public Freelance() {
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	public List<Article> viewArticle() {
	Query query=entityManager.createQuery("select a from Article a");
	return query.getResultList();
	}
		
	

	@Override
	public List<News> viewNews() {
		Query query=entityManager.createQuery("select a from News a");
		return query.getResultList();
	}
	

	@Override
	public FreeLance authentification(String login, String password) {
		FreeLance freeLance=null;
		Query query=entityManager.createQuery("Select f from FreeLance f where f.login=:l and f.password=:p and f.status = true ");
		query.setParameter("l", login).setParameter("p", password);
		try{
			freeLance=(FreeLance) query.getSingleResult();
		}catch(Exception e){
			freeLance=null;
		}
		return freeLance;
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArticle(Article article) {
		entityManager.persist(article);		
		
	}

	@Override
	public void addNews(News news) {
		entityManager.persist(news);		
		
	}

	@Override
	public void modifyArticle(Article article) {
		entityManager.merge(article);
		
	}

	@Override
	public void modifyNews(News news) {
		entityManager.merge(news);
		
	}

	@Override
	public void deleteArticle(Article article) {
		entityManager.remove(entityManager.merge(article));		
		
	}

	@Override
	public void deleteNews(News news) {
		entityManager.remove(entityManager.merge(news));		
		
	}

	@Override
	public void createFreelance(Freelance freelance) {
		entityManager.persist(freelance);
		
	}

	@Override
	public void updateFreelance(FreeLance freelance) {
		entityManager.merge(freelance);
		
	}

	@Override
	public void deleteFreelance(Freelance freelance) {
		entityManager.remove(entityManager.merge(freelance));
		
	}

	@Override
	public FreeLance findFreelanceById(int idFreelance) {
		FreeLance freeLance= entityManager.find(FreeLance.class, idFreelance);
		return freeLance;
	}

	@Override
	public List<FreeLance> findAllFreelance() {
		Query query = entityManager.createQuery("from FreeLance f");
		List<FreeLance> freelances = query.getResultList();
		
		return freelances;
	}

}
