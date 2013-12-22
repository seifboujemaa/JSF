package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

		
	import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
	public class Mail implements Serializable{
		public String username;
		public String password;
		public String usernameTo;
		

		public Mail() {
			super();
		}

		public Mail(String username, String usernameTo, String password) {
			super();
			this.username = username;
			this.usernameTo = usernameTo;
			this.password = password;
			;	
		}
		



		public String getUsernameTo() {
			return usernameTo;
		}

		public void setUsernameTo(String usernameTo) {
			this.usernameTo = usernameTo;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}
	
	
	


