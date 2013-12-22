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
		Query query=entityManager.createQuery("select b from Article b");
		return query.getResultList();
	}
	

}
