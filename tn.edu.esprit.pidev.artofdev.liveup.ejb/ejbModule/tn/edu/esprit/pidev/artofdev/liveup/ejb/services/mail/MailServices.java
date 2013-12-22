package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.mail;

import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Mail;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.mail.MailServicesLocal;




@Stateless
@LocalBean
public class MailServices implements MailServicesRemote {

	
	
	public MailServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void sendMail(Mail mail) {
		final String username = "akrem.sgh@gmail.com";
		final String password = "subzero3310";
		
		

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("akrem.sgh@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(mail.getUsernameTo()));
			message.setSubject("inscription");
			message.setText("Olfaaaaaaaaaaaaaaaaaaaaaaa");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}

}
