package jsfproject.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
@FacesConverter("firstNameConverter")
public class ValidatorFirstName implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2.equals("")){
		FacesMessage msg = new FacesMessage("Error",
	            "FirstName should not contain number letters");
	         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	         throw new ConverterException(msg);
	         }
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
