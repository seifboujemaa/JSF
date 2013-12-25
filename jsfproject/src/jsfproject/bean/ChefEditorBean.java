package jsfproject.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.article.ArticleServicesLocal;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorLocal;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance.FreelanceLocal;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.journalist.JournalistServicesLocal;

@ManagedBean
@ViewScoped
public class ChefEditorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private JournalistServicesLocal localJournalist;
	@EJB
	private ChefEditorLocal localChefEditor;
	@EJB
	private ArticleServicesLocal localArticles ;
	

	private Journalist journalist = new Journalist();
	private FreeLance freeLance = new FreeLance();
	private Article article = new Article();

	private List<Journalist> journalists = new ArrayList<Journalist>();
	private List<FreeLance> freeLances = new ArrayList<FreeLance>();
	private List<Article> articles = new ArrayList<Article>();

	public ChefEditorBean(JournalistServicesLocal localJournalist,
			Journalist journalist, List<Journalist> journalists) {
		super();
		this.localJournalist = localJournalist;
		this.journalist = journalist;
		this.journalists = journalists;
	}

	public ChefEditorBean() {

	}
	
	

	public ArticleServicesLocal getLocalArticles() {
		return localArticles;
	}

	public void setLocalArticles(ArticleServicesLocal localArticles) {
		this.localArticles = localArticles;
	}

	public ChefEditorLocal getLocalChefEditor() {
		return localChefEditor;
	}

	public void setLocalChefEditor(ChefEditorLocal localChefEditor) {
		this.localChefEditor = localChefEditor;
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

	public FreeLance getFreeLance() {
		return freeLance;
	}

	public void setFreeLance(FreeLance freeLance) {
		this.freeLance = freeLance;
	}

	public List<FreeLance> getFreeLances() {
		return freeLances;
	}

	public void setFreeLances(List<FreeLance> freeLances) {
		this.freeLances = freeLances;
	}

	public JournalistServicesLocal getLocalJournalist() {
		return localJournalist;
	}

	public void setLocalJournalist(JournalistServicesLocal localJournalist) {
		this.localJournalist = localJournalist;
	}

	public Journalist getJournalist() {
		return journalist;
	}

	public void setJournalist(Journalist journalist) {
		this.journalist = journalist;
	}

	public List<Journalist> getJournalists() {
		return journalists;
	}

	public void setJournalists(List<Journalist> journalists) {
		this.journalists = journalists;
	}

	@PostConstruct
	public void init() {

		journalists = localJournalist.findAllJournalistJSF();
		freeLances = localChefEditor.findAllFreelances();
		articles = localArticles.findAllArticleWithoutCriter();
	}

	public String doAddjournalist() {
		localJournalist.createJournalist(journalist);
		journalist = new Journalist();
		journalists = localJournalist.findAllJournalistJSF();
		return null;
	}

	public String doUpdatejournalist() {
		localJournalist.updateJournalist(journalist);
		journalist = new Journalist();
		journalists = localJournalist.findAllJournalistJSF();
		return null;
	}

	public String doDeletejournalist() {
		localJournalist.deleteJournalist(journalist);
		journalist = new Journalist();
		journalists = localJournalist.findAllJournalistJSF();
		return null;
	}

	public String hideAddJournalistDialog() {
		journalist = new Journalist();

		return "PF('journalistAdd').hide();";
	}

	public String doAppointFreeLance() {
		localChefEditor.acceptFreeLance(freeLance);
		freeLance = new FreeLance();
		freeLances = localChefEditor.findAllFreelances();
		return null;
	}

	public String doDeclineFreeLance() {

		localChefEditor.declineFreeLance(freeLance);
		freeLance = new FreeLance();
		freeLances = localChefEditor.findAllFreelances();
		return null;
	}

	public String doAcceptArticle() {
		localArticles.appointArticle(article);
        article = new Article();
        articles = localArticles.findAllArticleWithoutCriter();
		return null;
	}

	public String doDeclineArticle() {
		localArticles.declineArticle(article);
        article = new Article();
        articles = localArticles.findAllArticleWithoutCriter();
		return null;
	}

}
