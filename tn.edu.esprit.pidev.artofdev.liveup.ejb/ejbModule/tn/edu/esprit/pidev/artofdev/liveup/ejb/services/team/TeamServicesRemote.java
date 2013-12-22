package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.team;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Game;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;

@Remote
public interface TeamServicesRemote {
	public void createTeam(Team team);
	public void updateTeam(Team team);
	public void deleteTeam(Team team);
	public Team findTeamById(int idTeam);
	public Team findTeamByName(String nameTeam);
	public List<Team> findAllTeam();
	public List<Team>  findTeamByGame(Game game);
	public List<Team> findTeamByGroup(String stage) ;
	
	public List<Game> findGameOnTeam(Team team);

}
