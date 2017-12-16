package net.service.projectstorebeans.web.validator;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        ResourceBundle bundle = ResourceBundle.getBundle("conf.messages",
                FacesContext.getCurrentInstance().getViewRoot().getLocale());

        try {
            String valueString = value.toString().trim();

            if (chekNameIsCorect(valueString)) {
                throw new IllegalArgumentException(bundle.getString("login_name_incorect"));
            }

            if (!Character.isLetter(valueString.charAt(0))) {
                throw new IllegalArgumentException(bundle.getString("login_input_error"));
            }

            if (valueString.length() < 3) {
                throw new IllegalArgumentException(bundle.getString("login_length_error"));
            }

        } catch (IllegalArgumentException e) {
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

    }

//    private Boolean chekFirstLiteral(String str) {
//
//        String firstSymbol = "" + str.charAt(0);
//        Pattern pattern = Pattern.compile("(\\W|\\d|_)");
//        Matcher matcher = pattern.matcher(firstSymbol);
//
//        return matcher.matches();
//    }

    private Boolean chekNameIsCorect(String str) {

        String[] nameDataBase = {"root", "main"};
        for (String value : nameDataBase) {
            if (value.equals(str)) {
                return true;
            }
        }
        return false;
    }

}
