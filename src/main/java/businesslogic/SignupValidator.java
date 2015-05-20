package businesslogic;

import Model.Entities.UserEntity;
import Model.dao.interfaces.GenericDao;
import Model.dto.SignUpForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * Created by yarik on 20.05.2015.
 */
@Component
public class SignupValidator implements Validator {
    @Autowired
    private GenericDao genericDao;
    @Override
    public boolean supports(Class<?> aClass) {
        return SignUpForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SignUpForm signUpForm = (SignUpForm) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login", "Login must not be empty.");
        String login = signUpForm.getLogin();
        if ((login.length()) > 16) {
            errors.rejectValue("login", "login.tooLong", "Login must not more than 16 characters.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
        if (!(signUpForm.getPassword()).equals(signUpForm
                .getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Name must not be empty.");
        String name = signUpForm.getName();
        if ((name.length()) > 20) {
            errors.rejectValue("name", "name.tooLong", "Name must not more than 20 characters.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Name must not be empty.");
        String phone = signUpForm.getPhone();
        if (phone.length() != 10) {
            errors.rejectValue("phone", "phone.bad", "Phone must be 10 characters.");
        }
        if (!phone.matches("[0-9]+")) {
            errors.rejectValue("phone", "phone.notJustNumbers", "Phone must contain just numbers");
        }
        List<UserEntity> users = genericDao.findAll(UserEntity.class);
        for (UserEntity u : users) {
            if (signUpForm.getLogin().equals(u.getLogin())) {
                errors.rejectValue("login", "login.alreadyExists", "User with the same login already exists");
            }
        }


        if( !EmailValidator.getInstance().isValid( signUpForm.getEmail() ) ){
            errors.rejectValue("email", "email.notValid", "Email address is not valid.");
        }

    }
}
