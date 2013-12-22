package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor;

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
 * Session Bean implementation class ChefEditor
 */
@Stateless
public class ChefEditor implements ChefEditorRemote, ChefEditorLocal {
  @PersistenceContext
	EntityManager em;
    
    public ChefEditor() {
        
    }

	@Override
	
	
	public void createChefEditor(ChefEditor chefeditor) {
		em.persist(chefeditor);

	}
	
	public List<FreeLance> viewFreeLances() {
		Query query=em.createQuery("select f from FreeLance f where f.status = false");
		return query.getResultList();
		
	}

	@Override
	public List<FreeLance> viewRequest() {
		Query query=em.createQuery("select f from FreeLance f where f.status = true");
		return query.getResultList();
	}

	@Override
	public void acceptFreeLance(FreeLance freeLance) {
		em.merge(freeLance);
		
	}

	@Override
	public void declineFreeLance(FreeLance freeLance) {
		em.remove(em.merge(freeLance));
		
	}

	@Override
	public void deleteFreeLance(FreeLance freeLance) {
		em.remove(em.merge(freeLance));
		
	}

	@Override
	public ChefEditor authentification(String login, String password) {
		ChefEditor chefEditor=null;
		Query query=em.createQuery("Select c from ChefEditor c where c.login=:l and c.passsword=:p ");
		query.setParameter("l", login).setParameter("p", password);
		try{
			chefEditor=(ChefEditor) query.getSingleResult();
		}catch(Exception e){
			chefEditor=null;
		}
		return chefEditor;
		
	}

	@Override
	public void appointNews(News news) {
		em.merge(news);
		
	}

	@Override
	public void appointArticle(Article article) {
		em.merge(article);
		
	}

	@Override
	public void declineNews(News news) {
		em.remove(em.merge(news));
		
	}

	@Override
	public void declineArticle(Article article) {
		em.remove(em.merge(article));
		
	}

	@Override
	public List<News> viewNews() {
		Query query=em.createQuery("select n from News n where n.status = true");
		return query.getResultList();
	}

	@Override
	public List<Article> viewsArticles() {
		Query query=em.createQuery("select a from Article a where a.status = true");
		return query.getResultList();
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<News> viewNewsUntreated() {
		Query query=em.createQuery("select n from News n where n.status = false");
		return query.getResultList();
	}

	@Override
	public List<Article> viewArticlesUntreated() {
		Query query=em.createQuery("select a from Article a where a.status = false");
		return query.getResultList();
	}

	@Override
	public List<FreeLance> findAllFreelances() {
		Query query=em.createQuery("select f from FreeLance f ");
		return query.getResultList();
	}

	@Override
	public List<News> findAllNews() {
		Query query=em.createQuery("select n from News n ");
		return query.getResultList();
	}

	@Override
	public List<Article> findAllArticles() {
		Query query=em.createQuery("select a from Article a");
		return query.getResultList();
	}

	@Override
	public List<tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.ChefEditor> findAllChefs() {
		
		Query query=em.createQuery("select c from ChefEditor c");
		return query.getResultList();
	}

	@Override
	public void addChefEditor(
			tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.ChefEditor chefeditor) {
		em.persist(chefeditor);
		
	}

	@Override
	public void deleteChefEditor(
			tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.ChefEditor chefeditor) {
		em.remove(em.merge(chefeditor));			
	}

	@Override
	public void updateChefEditor(
			tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.ChefEditor chefeditor) {
		em.merge(chefeditor);	
		
	}




    
    

}
