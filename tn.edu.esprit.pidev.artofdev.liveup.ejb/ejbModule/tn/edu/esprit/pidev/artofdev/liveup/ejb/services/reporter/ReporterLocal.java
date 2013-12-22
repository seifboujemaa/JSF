package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter;

import java.io.File;
import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Video;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditor;

@Local
public interface ReporterLocal {
	public void createReporter(Reporter reporter);
	public List<Photo> viewPhoto();
	public List<Video> viewVideo();
	public byte[] imageToByte(File imageFile);
	public void addVideo(Video video);
	public void deleteVideo(Video video);
	public void deletePhoto(Photo photo);
	public void disconnect();
	public void addPhoto(Photo photo);
	
	
	public void addReporter(tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter reporter);
	public void deleteReporter(tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter reporter);
	public void updateReporter(tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter reporter);
	public List<tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter> findAllReporter();

}
