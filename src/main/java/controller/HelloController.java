package controller;

import Model.Entities.UserTypeEntity;
import Model.dao.interfaces.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HelloController {
    @Autowired
    private GenericDao genericDao;


	@RequestMapping(value = "/index")
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        System.out.println("lalala");
        UserTypeEntity user = new UserTypeEntity("types", (byte) 0);
        genericDao.create(user);
		return "hello";
	}
}