package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.team;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;


@Local
public interface TeamServicesLocal {
	
	public void createTeam(Team team);
	public void updateTeam(Team team);
	public void deleteTeam(Team team);
	public Team findTeamById(int idTeam);
	public Team findTeamByName(String nameTeam);

	public List<Team> findAllTeam();


}
