package controller;

import Model.Entities.TourEntity;
import Model.dao.interfaces.GenericDao;
import Model.dto.TourForList;
import businesslogic.ToursForListFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yarik on 28.05.2015.
 */
@Controller
public class SearchController {
    @Autowired
    private GenericDao genericDao;
    @Autowired
    private ToursForListFiller filler;

    @RequestMapping(value="/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("query") String query,
                            ModelMap model) {
        List<TourForList> toursForList = new ArrayList<TourForList>();
        List<TourEntity> dbTours = genericDao.findAll(TourEntity.class);
        String [] keyWords = query.split("[\\s,;]+");

        for (int i = 0; i < dbTours.size(); i++) {
            boolean removed = false;
            if (!dbTours.get(i).getName().equals(query)) {
                dbTours.remove(i);
                i--;
            }
        }
        filler.fillList(dbTours, toursForList);
        model.addAttribute("toursForList", toursForList);
        return "userMainPage";
    }
}
