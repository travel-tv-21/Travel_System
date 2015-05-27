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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserMainPageController  {
    @Autowired
    private GenericDao genericDao;

    @Autowired
    private ToursForListFiller filler;

    @RequestMapping(method = RequestMethod.POST, value="/filter")
    public String filterTours(@ModelAttribute("minPrice") double minPrice,
                              @ModelAttribute("maxPrice") double maxPrice,
                              @ModelAttribute("startDateFrom") String startDateFrom,
                              @ModelAttribute("startDateTo") String startDateTo,
                              @ModelAttribute("minDaysCount") int minDaysCount,
                              @ModelAttribute("maxDaysCount") int maxDaysCount,
                              ModelMap model) throws ParseException {
        System.out.println(minPrice);
        System.out.println(maxPrice);
        System.out.println(startDateFrom);
        System.out.println(startDateTo);
        System.out.println(minDaysCount);
        System.out.println(maxDaysCount);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        List<TourForList> toursForList = new ArrayList<TourForList>();
        List<TourEntity> dbTours = genericDao.findAll(TourEntity.class);

        for (int i = 0; i < dbTours.size(); i++) {
            TourEntity t = dbTours.get(i);
            boolean canRemove = false;
            if (((minPrice > 0) && (t.getPrice() < minPrice))
                    || ((maxPrice > 0) && (t.getPrice() > maxPrice))
                    || ((minDaysCount > 0) && (t.getNumday() < minDaysCount))
                    || ((maxDaysCount > 0) && (t.getNumday() > maxDaysCount))) {
                canRemove = true;
            } else if (!"".equals(startDateFrom)) {
                Date startDateFrom1 = format.parse(startDateFrom);
                if (t.getStartDate().before(startDateFrom1)) {
                    canRemove = true;
                }
            } else if (!"".equals(startDateTo)) {
                Date startDateTo1 = format.parse(startDateTo);
                if (t.getStartDate().after(startDateTo1)) {
                    canRemove = true;
                }
            }
            if (canRemove) {
                dbTours.remove(t);
                i--;
            }
        }

        filler.fillList(dbTours, toursForList);
        model.addAttribute("toursForList", toursForList);
        return "userMainPage";
    }

}
