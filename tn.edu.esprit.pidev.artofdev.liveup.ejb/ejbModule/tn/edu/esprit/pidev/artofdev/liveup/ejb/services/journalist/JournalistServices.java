package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.journalist;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;

@Stateless
@LocalBean
public class JournalistServices implements JournalistServicesLocal,
		JournalistServicesRemote {

	@PersistenceContext
	EntityManager entityManager;

	public JournalistServices() {

	}

	@Override
	public void createJournalist(Journalist journalist) {
		entityManager.persist(journalist);

	}

	@Override
	public void updateJournalist(Journalist journalist) {
		entityManager.merge(journalist);

	}

	@Override
	public void deleteJournalist(Journalist journalist) {
		entityManager.remove(entityManager.merge(journalist));

	}

	@Override
	public Journalist findJournalistById(int idJournalist) {
		Journalist journalist = entityManager.find(Journalist.class,
				idJournalist);
		return journalist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Journalist> findAllJournalist() {
		Query query = entityManager.createQuery("from Journalist e");
		List<Journalist> journalists = query.getResultList();
		//System.out.println("EntityManager returned "+journalists.size()+" journalists");
		return journalists;
	}

}
