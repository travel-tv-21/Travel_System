package controller;

import Model.Entities.TourEntity;
import Model.Entities.UserTypeEntity;
import Model.dao.interfaces.GenericDao;
import Model.dto.SignInForm;
import Model.dto.TourForList;
import businesslogic.Authorization;
import businesslogic.ToursForListFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class SignInController {
    @Autowired
    private GenericDao genericDao;

    @Autowired
    private ToursForListFiller filler;

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
            UserTypeEntity userType = authorization.check(new SignInForm(login, pass), null);
            System.out.println(userType);
            if ((userType != null) && (userType.getName().equals(USER_TYPE_ADMIN_NAME))){
                model.addAttribute("login", login);
                List<TourForList> toursForList = new ArrayList<TourForList>();
                List<TourEntity> dbTours = genericDao.findAll(TourEntity.class);
                filler.fillList(dbTours, toursForList);
                model.addAttribute("toursForList", toursForList);
                model.addAttribute("tour", new TourEntity());
                //return "redirect:/addTour.html";
            } else if ((userType != null) && (userType.getName().equals(USER_TYPE_USER_NAME))) {
                page = "userMainPage";
                model.addAttribute("login", login);
                List<TourForList> toursForList = new ArrayList<TourForList>();
                List<TourEntity> dbTours = genericDao.findAll(TourEntity.class);
                filler.fillList(dbTours, toursForList);
                model.addAttribute("toursForList", toursForList);

                model.addAttribute("minPrice", 0);
                model.addAttribute("maxPrice", 0);
                model.addAttribute("startDateFrom", new Date());
                model.addAttribute("startDateTo", new Date());
                model.addAttribute("minDaysCount", 0);
                model.addAttribute("maxDaysCount", 0);

            }
        }

        return page;
	}

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String login(@ModelAttribute("singnInForm") SignInForm signInForm, ModelMap model, HttpServletResponse response) {
        String page = "userMainPage";
        Authorization authorization = new Authorization(genericDao);
        Cookie userIdCookie = new Cookie("USER_ID", "");
        //System.out.println(signInForm.getLogin() + " " + signInForm.getPassword());
        UserTypeEntity userType = authorization.check(signInForm, userIdCookie);
        if (userType == null) {
            page = "authorizationFailed";
        } else {
            Cookie logCookie = new Cookie("LOGIN", signInForm.getLogin());
            Cookie pasCookie = new Cookie("PASSWORD", signInForm.getPassword());


            model.addAttribute("login", signInForm.getLogin());
            logCookie.setMaxAge(3600);
            pasCookie.setMaxAge(3600);
            userIdCookie.setMaxAge(3600);
            response.addCookie(logCookie);
            response.addCookie(pasCookie);
            response.addCookie(userIdCookie);

            List<TourForList> toursForList = new ArrayList<TourForList>();
            List<TourEntity> dbTours = genericDao.findAll(TourEntity.class);
            filler.fillList(dbTours, toursForList);
            model.addAttribute("toursForList", toursForList);

            if (userType.getName().equals(USER_TYPE_ADMIN_NAME)) {
                page = "adminMainPage";
                model.addAttribute("tour", new TourEntity());
                //page ="redirect:/addTour";
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
        Cookie userIdCookie = new Cookie("USER_ID", "");
        logCookie.setMaxAge(0);
        pasCookie.setMaxAge(0);
        userIdCookie.setMaxAge(0);
        response.addCookie(logCookie);
        response.addCookie(pasCookie);
        response.addCookie(userIdCookie);
        return "login";
    }


}