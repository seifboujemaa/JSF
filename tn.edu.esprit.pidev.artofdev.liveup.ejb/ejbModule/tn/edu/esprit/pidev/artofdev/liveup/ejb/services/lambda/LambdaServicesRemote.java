package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.lambda;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Lambda;


@Remote
public interface LambdaServicesRemote {
	public void createLambda(Lambda lambda);
	public void updateLambda(Lambda lambda);
	public void deleteLambda(Lambda lambda);
	public Lambda findLambdaById(int idLambda);
	public List<Lambda> findAllLambda();

}
