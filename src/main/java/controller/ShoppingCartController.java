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
public class ShoppingCartController {
    @Autowired
    private GenericDao genericDao;

    @Autowired
    private ToursForListFiller filler;

    @RequestMapping(value="/shoppingCart", method = RequestMethod.GET)
    public String showShoppingCart(@CookieValue(value="USER_ID") String userIdStr,
                            ModelMap model) {
       int userId = Integer.valueOf(userIdStr);
       List <TourEntity> userTours = new ArrayList<TourEntity>();
       List <ToursInShoppingCartEntity> allToursFromCarts = genericDao.findAll(ToursInShoppingCartEntity.class);
        for (ToursInShoppingCartEntity cur : allToursFromCarts) {
            if (userId == cur.getUserId()) {
                userTours.add((TourEntity) genericDao.findById(TourEntity.class, cur.getTourId()));
            }
        }
        List<TourForList> toursForList = new ArrayList<TourForList>();
        filler.fillList(userTours, toursForList);
        model.addAttribute("toursForList", toursForList);
        return "shoppingCart";
    }

    @RequestMapping(value="/removeFromCart", method = RequestMethod.POST)
    public String removeFromCart(@ModelAttribute("tourId") int tourId,
                            @CookieValue(value="USER_ID") String userIdStr,
                            ModelMap model) {

        int userId = Integer.valueOf(userIdStr);
        List <ToursInShoppingCartEntity> toursInShoppingCartEntities = genericDao.findAll(ToursInShoppingCartEntity.class);

        for(ToursInShoppingCartEntity cur : toursInShoppingCartEntities) {
            if ((cur.getUserId() == userId) && (cur.getTourId() == tourId)) {
                toursInShoppingCartEntities.remove(cur);
                genericDao.delete(cur);
                System.out.println("deleted");
                break;
            }
        }
        List<TourEntity> dbTours = new ArrayList<TourEntity>();
        for (ToursInShoppingCartEntity cur : toursInShoppingCartEntities) {
            dbTours.add((TourEntity) genericDao.findById(TourEntity.class, cur.getTourId()));
        }

        List<TourForList> toursForList = new ArrayList<TourForList>();
        filler.fillList(dbTours, toursForList);
        model.addAttribute("toursForList", toursForList);

        return "shoppingCart";
    }

}
