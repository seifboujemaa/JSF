package jsfproject.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Video;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.sevices.video.VideoServicesLocal;
@ManagedBean
@ViewScoped
public class VideoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private VideoServicesLocal localVideo ;
	private Video video = new Video();
	private  List<Video> videos = new ArrayList<Video>();
	public VideoServicesLocal getLocalVideo() {
		return localVideo;
	}
	public void setLocalVideo(VideoServicesLocal localVideo) {
		this.localVideo = localVideo;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	public VideoBean() {
		
	}
	
	public String doAddVideo(){
		localVideo.createVideo(video);
		video = new Video();
		videos = localVideo.findAllVideo();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Success", "Your video was added successfuly!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return null;
	}
	
	public String doDeleteVideo(){
		localVideo.deleteVideo(video);
		video = new Video();
		videos = localVideo.findAllVideo();
		return null;
		
	}
	@PostConstruct
	public void  init(){
		
	videos = localVideo.findAllVideo();	
	}
	

}
