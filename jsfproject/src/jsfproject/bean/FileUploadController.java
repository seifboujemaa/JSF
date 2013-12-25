package jsfproject.bean;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.photo.PhotoServicesLocal;
 
@ManagedBean(name="fileUploadController")
@ViewScoped
public class FileUploadController {
  // private String destination="C:\\photos\\";
	private String destination = "C:\\Users\\admin\\git\\JSF\\jsfproject\\WebContent\\resources\\imagesUploaded\\";
	String fileName ="";

    public void upload(FileUploadEvent event) {
    	fileName = event.getFile().getFileName();
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }  

    public void copyFile(String fileName, InputStream in) {
           try {
             
             
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination + fileName));
             
                int read = 0;
                byte[] bytes = new byte[1024];
             
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
             
                in.close();
                out.flush();
                out.close();
             
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
    @EJB
    private PhotoServicesLocal localPhoto;
    private  Photo photo = new Photo();
   

    private List<Photo> photos = new ArrayList<Photo>();
  

	public PhotoServicesLocal getLocalPhoto() {
		return localPhoto;
	}

	public void setLocalPhoto(PhotoServicesLocal localPhoto) {
		this.localPhoto = localPhoto;
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

	public String doAddPhoto(){
		photo.setUrl("/resources/imagesUploaded/"+fileName);
		localPhoto.createPhoto(photo);
		photo = new Photo();
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Success", "Your photo was uploaded successfuly !");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		photos = localPhoto.findAllPhoto();
		return null;
	}
	@PostConstruct
	public void init(){
		
	photos = localPhoto.findAllPhoto();	
	}
	
		public String doDeletePhoto(){
		
		localPhoto.deletePhoto(photo);
		photo = new Photo();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Success", "Your photo was deleted successfuly !");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		photos = localPhoto.findAllPhoto();
		return null;
	}
	

    
}