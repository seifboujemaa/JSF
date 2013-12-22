package tn.edu.esprit.pidev.artofdev.liveup.ejb.sevices.video;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Video;

public interface VideoServicesRemote {
	
	
	public void createVideo(Video video);
	public void updateVideo(Video video);
	public void deleteVideo(Video video);
	public Video findVideoById(int idJournalist);
	public List<Video> findAllVideo();  

}
