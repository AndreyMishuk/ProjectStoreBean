package net.service.projectstorebeans.web.validator;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("net.service.projectstorebeans.web.validator.LoginValidator")
public class LoginValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        if (value.toString().length() < 5) {
            ResourceBundle bundle = ResourceBundle.getBundle("conf.messages",
                    FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesMessage message = new FacesMessage("login_length_error");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

}
