package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.mail;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Mail;

@Local
public interface MailServicesLocal {
	
	public void sendMail(Mail mail);
	

}
