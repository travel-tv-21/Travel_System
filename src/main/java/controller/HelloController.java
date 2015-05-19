package controller;

import Model.dao.interfaces.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Model.dto.*;


@Controller
public class HelloController {
    @Autowired
    private GenericDao genericDao;


	@RequestMapping(value = "/index")
	public String askLogin(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        System.out.println("lalala");
        //UserTypeEntity user = new UserTypeEntity("types", (byte) 0);
        genericDao.create(user);
		return "login";
	}

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String printWelcome(@ModelAttribute("LoginForm") User user, ModelMap model) {
        String page = "welcome";

        return page;
    }
}