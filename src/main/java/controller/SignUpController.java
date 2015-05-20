package controller;

import Model.dto.SignUpForm;
import businesslogic.SignUp;
import businesslogic.SignupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yarik on 20.05.2015.
 */
@Controller
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    private SignupValidator signupValidator;
    @Autowired
    private SignUp signUp;

    @RequestMapping(method = RequestMethod.GET)
    public String signup(ModelMap model) {
        SignUpForm signupForm = new SignUpForm();
        model.put("signupForm", signupForm);
        System.out.println("form created");
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSignup(@ModelAttribute("signupForm") SignUpForm signupForm,  BindingResult result,
                                ModelMap model,
                                HttpServletResponse response) {
        signupValidator.validate(signupForm, result);


        if (result.hasErrors()) {
            return "signup";
        }

        signUp.addUser(signupForm);
        Cookie logCookie = new Cookie("LOGIN", signupForm.getLogin());
        Cookie pasCookie = new Cookie("PASSWORD", signupForm.getPassword());
        model.addAttribute("login", signupForm.getLogin());
        logCookie.setMaxAge(3600);
        pasCookie.setMaxAge(3600);
        response.addCookie(logCookie);
        response.addCookie(pasCookie);



        return "login";
    }
}
