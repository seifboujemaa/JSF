package jsfproject.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.article.ArticleServicesLocal;

@ManagedBean
@ViewScoped
public class ArticleBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private ArticleServicesLocal localArticle;
	
	
	private Article article = new Article();
	
	private List<Article> articles = new ArrayList<Article>();
	private List<Article> articlesJournalist = new ArrayList<Article>();
	private List<Article> articlesFreeLance = new ArrayList<Article>();
	private List<Article> articlesChefEditor = new ArrayList<Article>();
	
	
	
	

	public List<Article> getArticlesChefEditor() {
		return articlesChefEditor;
	}

	public void setArticlesChefEditor(List<Article> articlesChefEditor) {
		this.articlesChefEditor = articlesChefEditor;
	}

	public List<Article> getArticlesJournalist() {
		return articlesJournalist;
	}

	public void setArticlesJournalist(List<Article> articlesJournalist) {
		this.articlesJournalist = articlesJournalist;
	}

	public List<Article> getArticlesFreeLance() {
		return articlesFreeLance;
	}

	public void setArticlesFreeLance(List<Article> articlesFreeLance) {
		this.articlesFreeLance = articlesFreeLance;
	}

	public ArticleServicesLocal getLocalArticle() {
		return localArticle;
	}

	public void setLocalArticle(ArticleServicesLocal localArticle) {
		this.localArticle = localArticle;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public ArticleBean() {
		// TODO Auto-generated constructor stub
	}

	public ArticleBean(ArticleServicesLocal localArticle, Article article,
			List<Article> articles) {
		super();
		this.localArticle = localArticle;
		this.article = article;
		this.articles = articles;
	}
	
	@PostConstruct
	public void init(){
		
		articles = localArticle.findAllArticle();
//		articlesFreeLance = localArticle.findAllArticleByTypeFreeLance();
//		articlesJournalist = localArticle.findAllArticleByTypeJournalist();
		articlesChefEditor = localArticle.findAllArticleWithoutCriter();
		
	}
	
	
//	public String doAddArticleJournalist(){
//		localArticle.addArtilceByTypeJournalistAndStatus(article);
//		article = new Article();
//		articlesJournalist = localArticle.findAllArticleByTypeJournalist();
//		return null;
//	}
//	
//	
//	
//	public String doUpdateArticleJournalist(){
//		localArticle.updateArticle(article);
//		article = new Article();
//		articlesJournalist = localArticle.findAllArticleByTypeJournalist();
//		
//		return null;
//	}
//	
//	public String doDeleteArticleJournalist(){
//		localArticle.deleteArticle(article);
//		article = new Article();
//		articlesJournalist = localArticle.findAllArticleByTypeJournalist();
//		
//		return null;
//	}
//	
//	public String doAddArticleFreeLance(){
//		
//		localArticle.addArticleByTypeFreeLanceAndStatus(article);
//		article = new Article();
//		articlesFreeLance = localArticle.findAllArticleByTypeFreeLance();
//		return null;
//	}
//	
//	public String doUpdateArticleFreeLance(){
//		localArticle.updateArticle(article);
//		article = new Article();
//		articlesFreeLance = localArticle.findAllArticleByTypeFreeLance();
//		
//		return null;
//	}
//	
//	public String doDeleteArticleFreeLance(){
//		localArticle.deleteArticle(article);
//		article = new Article();
//		articlesFreeLance = localArticle.findAllArticleByTypeFreeLance();
//		
//		return null;
//	}
	
	public String HideAddArticleDialog(){
		
		
			article = new Article();

			return "PF('articleAdd').hide();";
		
	
	}
	
	

}
