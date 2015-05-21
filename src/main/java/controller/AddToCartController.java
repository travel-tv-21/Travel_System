package controller;

import Model.Entities.TourEntity;
import Model.Entities.ToursInShoppingCartEntity;
import Model.dao.interfaces.GenericDao;
import Model.dto.TourForList;
import businesslogic.ToursForListFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yarik on 21.05.2015.
 */

@Controller
public class AddToCartController {
    @Autowired
    private GenericDao genericDao;

    @Autowired
    private ToursForListFiller filler;

    @RequestMapping(value="/addToCart", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute("tourId") int tourId,
                                @CookieValue(value="USER_ID") String userId,
                                ModelMap model) {

        ToursInShoppingCartEntity newCartUnit = new ToursInShoppingCartEntity();
        System.out.println(userId +  " " + tourId);
        newCartUnit.setTourId(tourId);
        newCartUnit.setUserId(Integer.valueOf(userId));
        genericDao.create(newCartUnit);
        List<TourForList> toursForList = new ArrayList<TourForList>();
        List<TourEntity> dbTours = genericDao.findAll(TourEntity.class);
        filler.fillList(dbTours, toursForList);
        model.addAttribute("toursForList", toursForList);

        return "userMainPage";
    }
}
