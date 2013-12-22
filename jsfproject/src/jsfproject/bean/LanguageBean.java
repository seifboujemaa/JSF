package jsfproject.bean;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class LanguageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String language = "resources.messages_en";

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String switchEnglish() {
        language = "resources.messages_en";
		return null;

	}

	public String switchFrench() {
		language="resources.messages_fr";
		return null;

	}

}
