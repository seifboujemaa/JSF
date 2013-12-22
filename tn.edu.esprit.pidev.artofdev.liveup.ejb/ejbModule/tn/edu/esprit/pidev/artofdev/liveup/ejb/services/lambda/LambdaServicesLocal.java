package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.lambda;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Lambda;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.SubscribedClient;


@Local
public interface LambdaServicesLocal {
	public void createLambda(Lambda lambda);
	public void updateLambda(Lambda lambda);
	public void deleteLambda(Lambda lambda);
	public Lambda findLambdaById(int idLambda);
	public List<Lambda> findAllLambda();
	
	
	public void addClient(SubscribedClient client);
	public void deleteClient(SubscribedClient client);
	public void updateClient(SubscribedClient client);
	public List<SubscribedClient> findAllClient();
	

}
