package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.article;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;

@Stateless
public class ArticleServices implements ArticleServicesLocal,ArticleServicesRemote {
@PersistenceContext

EntityManager entityManager ;

public ArticleServices(){
	
}



	@Override
	public void createArticle(Article article) {
		entityManager.persist(article);
		
	}

	@Override
	public void updateArticle(Article article) {
		entityManager.merge(article);
		
	}

	@Override
	public void deleteArticle(Article article) {
		entityManager.remove(entityManager.merge(article));	
		
	}

	@Override
	public Article findArticleById(int idArticle) {
		Article article = entityManager.find(Article.class,idArticle );
		return article ;
	}

	@Override
	public List<Article> findAllArticle() {
		Query query=entityManager.createQuery("select b from Article b where b.status = true");
		return query.getResultList();
	}



	@Override
	public void addArtilceByTypeJournalistAndStatus(Article article) {
		article.setType("Journalist");
		article.setStatus(false);
		entityManager.persist(article);
		
		
	}



	@Override
	public void addArticleByTypeFreeLanceAndStatus(Article article) {
	  article.setType("FreeLance");
	  article.setStatus(false);
	  entityManager.persist(article);
	  
		
	}



	@Override
	public List<Article> findAllArticleByTypeJournalist() {
		Query query=entityManager.createQuery("select b from Article b where b.type = 'Journalist' ");
		return query.getResultList();
	}



	@Override
	public List<Article> findAllArticleByTypeFreeLance() {
		Query query=entityManager.createQuery("select b from Article b where b.type = 'FreeLance'");
		return query.getResultList();
	}



	@Override
	public List<Article> findAllArticleWithoutCriter() {
		Query query=entityManager.createQuery("select b from Article b ");
		return query.getResultList();
	}



	@Override
	public void appointArticle(Article article) {
		article.setStatus(true);
    	entityManager.merge(article);
		
	}



	@Override
	public void declineArticle(Article article) {
		entityManager.remove(entityManager.merge(article));
		
	}
	
	
//	public void appointArticle(Article  article) {
//		article.setStatus(true);
//		entityManager.merge(article);
//		
//	}
//	
//	public void declineArticle(Article article) {
//		entityManager.remove(entityManager.merge(article));
//		
//	}
	

}
