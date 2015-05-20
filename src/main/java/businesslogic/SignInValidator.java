package businesslogic;

/**
 * Created by yarik on 21.05.2015.
 */

import Model.dto.SignInForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class SignInValidator {
@Autowired
private GenericDao genericDao;
@Override
public boolean supports(Class<?> aClass) {
        return SignInForm.class.isAssignableFrom(aClass);
        }

@Override
public void validate(Object o, Errors errors) {
        SignInForm signUpForm = (SignInForm) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login", "Login must not be empty.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");

        }





}
