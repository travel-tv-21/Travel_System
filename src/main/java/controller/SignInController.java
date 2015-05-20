package controller;

import Model.Entities.UserTypeEntity;
import Model.dao.interfaces.GenericDao;
import Model.dto.SignInForm;
import businesslogic.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class SignInController {
    @Autowired
    private GenericDao genericDao;

    public static String USER_TYPE_ADMIN_NAME = "admin";
    public static String USER_TYPE_USER_NAME = "user";

	@RequestMapping(value = "/index")
	public String index(ModelMap model,
                           @CookieValue(value="LOGIN", defaultValue="") String login,
                           @CookieValue(value="PASSWORD", defaultValue="") String pass) {
        String page = "login";
//        System.out.println(login);
//        System.out.println(pass);

        if (!login.isEmpty() && !pass.isEmpty()) {
            Authorization authorization = new Authorization(genericDao);
            UserTypeEntity userType = authorization.check(new SignInForm(login, pass));
            if ((userType != null) && (userType.getName().equals(USER_TYPE_ADMIN_NAME))){
                page = "adminMainPage";
            } else if ((userType != null) && (userType.getName().equals(USER_TYPE_USER_NAME))) {
                page = "userMainPage";
            }
        }
        //System.out.println("lalala");
        //UserTypeEntity user = new UserTypeEntity("types", (byte) 0);
//        System.out.println(page);
        return page;
	}

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String login(@ModelAttribute("singnInForm") SignInForm signInForm, ModelMap model, HttpServletResponse response) {
        String page = "userMainPage";
        Authorization authorization = new Authorization(genericDao);
        UserTypeEntity userType = authorization.check(signInForm);
        if (userType == null) {
            page = "authorizationFailed";
        } else {
            Cookie logCookie = new Cookie("LOGIN", signInForm.getLogin());
            Cookie pasCookie = new Cookie("PASSWORD", signInForm.getPassword());
            model.addAttribute("login", signInForm.getLogin());
            logCookie.setMaxAge(3600);
            pasCookie.setMaxAge(3600);
            response.addCookie(logCookie);
            response.addCookie(pasCookie);
            if (userType.getName().equals(USER_TYPE_ADMIN_NAME)) {
                page = "adminMainPage";
            } else if (userType.getName().equals(USER_TYPE_USER_NAME)) {
                page = "userMainPage";
            }
        }

        return page;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletResponse response) {
        // Удаляем Cookie
        Cookie logCookie = new Cookie("LOGIN", "");
        Cookie pasCookie = new Cookie("PASSWORD", "");
        logCookie.setMaxAge(0);
        pasCookie.setMaxAge(0);
        response.addCookie(logCookie);
        response.addCookie(pasCookie);
        return "login";
    }


}