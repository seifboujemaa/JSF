package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.article;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
@Local
public interface ArticleServicesLocal {
	public void createArticle(Article article);
	public void updateArticle(Article article);
	public void deleteArticle(Article article);
	public Article findArticleById(int idArticle);
	public List<Article> findAllArticle();
	
	
	public void addArtilceByTypeJournalistAndStatus(Article article);
	public void addArticleByTypeFreeLanceAndStatus(Article article);
	public List<Article> findAllArticleByTypeJournalist();
	public List<Article> findAllArticleByTypeFreeLance();
	public List<Article>  findAllArticleWithoutCriter();
	public void appointArticle(Article  article);
	public void declineArticle(Article article);
	
	
}
