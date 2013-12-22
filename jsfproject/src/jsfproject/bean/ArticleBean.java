package jsfproject.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
	}
	
	

}
