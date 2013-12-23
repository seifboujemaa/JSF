package jsfproject.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.GET;

import sun.security.action.GetBooleanAction;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Administrator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.ChefEditor;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.SubscribedClient;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator.AdministratorServicesLocal;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.agent.AgentServicesLocal;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorLocal;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.lambda.LambdaServicesLocal;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter.ReporterLocal;

@ManagedBean
@ViewScoped
public class AdministratrBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private AdministratorServicesLocal  local ;
	@EJB
	private AgentServicesLocal localAgent;
	@EJB
    private ChefEditorLocal localchef;
	@EJB
	private ReporterLocal localReporter;
	@EJB
	private LambdaServicesLocal localClient;

	private ChefEditor chefEditor = new ChefEditor();
	private Agent agent = new Agent();
	private Reporter reporter = new Reporter();
	private SubscribedClient client = new SubscribedClient();
	
	
	
	private List<Agent> agents = new ArrayList<Agent>();
	private List<ChefEditor> chefEditors = new ArrayList<ChefEditor>();
	private List<Reporter> reporters = new ArrayList<Reporter>();
	private List<SubscribedClient> clients = new ArrayList<SubscribedClient>();
	
	
	private boolean bool ;
	private boolean boolDelete;
	private boolean boolUpdate;
	private boolean boolAdd;
	
	
	
	
	public LambdaServicesLocal getLocalClient() {
		return localClient;
	}
	public void setLocalClient(LambdaServicesLocal localClient) {
		this.localClient = localClient;
	}
	public SubscribedClient getClient() {
		return client;
	}
	public void setClient(SubscribedClient client) {
		this.client = client;
	}
	public List<SubscribedClient> getClients() {
		return clients;
	}
	public void setClients(List<SubscribedClient> clients) {
		this.clients = clients;
	}
	public ReporterLocal getLocalReporter() {
		return localReporter;
	}
	public void setLocalReporter(ReporterLocal localReporter) {
		this.localReporter = localReporter;
	}
	public Reporter getReporter() {
		return reporter;
	}
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}
	public List<Reporter> getReporters() {
		return reporters;
	}
	public void setReporters(List<Reporter> reporters) {
		this.reporters = reporters;
	}
	public List<ChefEditor> getChefEditors() {
		return chefEditors;
	}
	public void setChefEditors(List<ChefEditor> chefEditors) {
		this.chefEditors = chefEditors;
	}
	public ChefEditorLocal getLocalchef() {
		return localchef;
	}
	public void setLocalchef(ChefEditorLocal localchef) {
		this.localchef = localchef;
	}
	public ChefEditor getChefEditor() {
		return chefEditor;
	}
	public void setChefEditor(ChefEditor chefEditor) {
		this.chefEditor = chefEditor;
	}
	public boolean isBoolDelete() {
		return boolDelete;
	}
	public void setBoolDelete(boolean boolDelete) {
		this.boolDelete = boolDelete;
	}
	public boolean isBoolUpdate() {
		return boolUpdate;
	}
	public void setBoolUpdate(boolean boolUpdate) {
		this.boolUpdate = boolUpdate;
	}
	public boolean isBoolAdd() {
		return boolAdd;
	}
	public void setBoolAdd(boolean boolAdd) {
		this.boolAdd = boolAdd;
	}
	public boolean isBool() {
		return bool;
	}
	public void setBool(boolean bool) {
		this.bool = bool;
	}
	public AdministratorServicesLocal getLocal() {
		return local;
	}
	public void setLocal(AdministratorServicesLocal local) {
		this.local = local;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public AdministratrBean() {
		// TODO Auto-generated constructor stub
	}
	
	public AgentServicesLocal getLocalAgent() {
		return localAgent;
	}
	public void setLocalAgent(AgentServicesLocal localAgent) {
		this.localAgent = localAgent;
	}
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	
	
	
	
	public void formDisplayAdd(){
		boolAdd = true;
		boolDelete = false;
		boolUpdate = false;
		bool =true;
		
	}
	
	public String formDisplayDelete(){
		boolAdd = false;
		boolDelete = true;
		boolUpdate = false;
		bool =true;
		return null;
	}
	
	public String formDisplayUpdate(){
		boolAdd = false;
		boolDelete = false;
		boolUpdate = true;
		bool =true;
		return null;
	}
	
	public String formHide(){
		bool = false;
		return null;
	}
	
	
	
	
	public  String doAddAgent(){
		
		local.createAgent(agent);
		agent = new Agent();
		agents=localAgent.findAllAgent();
		bool = false;
		return null;
	}
	
	
	
	@PostConstruct
	public void init()
	{
		agents=localAgent.findAllAgent();
		chefEditors = localchef.findAllChefs();
		reporters = localReporter.findAllReporter();
		clients  = localClient.findAllClient();
	}
	
	

	
	
	public String doDeleteAgent(){
		
		localAgent.deleteAgent(agent);
		agent = new Agent();
		bool =false;
		agents=localAgent.findAllAgent();
		return null;
	}
	
	public String doUpdate(){
		localAgent.updateAgent(agent);
		agent = new Agent();
		bool=false;
		agents=localAgent.findAllAgent();
		return null;
		
	}
	
	public String doAddChef(){
		
		localchef.addChefEditor(chefEditor);
		chefEditor = new ChefEditor();
		bool = false;
		chefEditors = localchef.findAllChefs();
		return null;
		}
	
	
	public String doDeleteChef(){
		
		localchef.deleteChefEditor(chefEditor);
		chefEditor = new ChefEditor();
		bool = false;
		chefEditors = localchef.findAllChefs();
		return null ;
	}


	public String doUpdateChef(){
		
		localchef.updateChefEditor(chefEditor);
		chefEditor = new ChefEditor();
		bool = false;
		chefEditors = localchef.findAllChefs();
		return null ;
	}
	
	
	public String doUpdateReporter(){
		
		localReporter.updateReporter(reporter);
		reporter = new Reporter();
		bool = false;
		reporters = localReporter.findAllReporter();
		return null ;
	}
	
public String doAddReporter(){
		
		localReporter.addReporter(reporter);
		reporter = new Reporter();
		bool = false;
		reporters = localReporter.findAllReporter();
		return null ;
	}

public String doDeleteReporter(){
	
	localReporter.deleteReporter(reporter);
	reporter = new Reporter();
	bool = false;
	reporters = localReporter.findAllReporter();
	return null ;
}



public String doAddClient(){
	
	localClient.addClient(client);
	client = new SubscribedClient();
	bool = false;
	clients = localClient.findAllClient();
	return null ;
}

public String doDeleteClient(){
	
	localClient.deleteClient(client);
	client = new SubscribedClient();
	bool = false;
	clients = localClient.findAllClient();
	return null ;
}

public String doUpdateClient(){
	
	localClient.updateClient(client);
	client = new SubscribedClient();
	bool = false;
	clients = localClient.findAllClient();
	return null ;
}

public String hideAddAgentDialog(){
	agent = new Agent();
	
	return "PF('agentAdd').hide();";
}


	
	


}
