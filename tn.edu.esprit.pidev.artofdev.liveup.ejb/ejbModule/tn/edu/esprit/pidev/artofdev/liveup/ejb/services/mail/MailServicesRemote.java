package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.mail;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Mail;
@Remote
public interface MailServicesRemote {
	
	
	public void sendMail(Mail mail);
	

}
