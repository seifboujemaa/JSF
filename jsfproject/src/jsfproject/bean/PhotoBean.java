package jsfproject.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Video;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.photo.PhotoServicesLocal;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.sevices.video.VideoServicesLocal;
@ManagedBean
@ViewScoped
public class PhotoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Photo photo = new Photo();
	private Video video = new Video();
	private List<Photo> photos = new ArrayList<Photo>();
	private List<Video> videos = new ArrayList<Video>();
	@EJB
	private PhotoServicesLocal localPhoto ;
	@EJB
	private VideoServicesLocal localVideo;
	
	public PhotoBean() {
		// TODO Auto-generated constructor stub
	}

	public PhotoBean(Photo photo, List<Photo> photos,
			PhotoServicesLocal localPhoto) {
		super();
		this.photo = photo;
		this.photos = photos;
		this.localPhoto = localPhoto;
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

	public VideoServicesLocal getLocalVideo() {
		return localVideo;
	}

	public void setLocalVideo(VideoServicesLocal localVideo) {
		this.localVideo = localVideo;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public PhotoServicesLocal getLocalPhoto() {
		return localPhoto;
	}

	public void setLocalPhoto(PhotoServicesLocal localPhoto) {
		this.localPhoto = localPhoto;
	}
	@PostConstruct
	public void init(){
		
		photos = localPhoto.findAllPhoto();
		videos = localVideo.findAllVideo();
	}
	
	

}
