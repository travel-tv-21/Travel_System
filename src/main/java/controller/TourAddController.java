package controller;

import Model.Entities.PhotoEntity;
import Model.Entities.TourEntity;
import Model.dao.GenericDaoImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Администратор on 20.05.2015.
 */
@Controller
public class TourAddController {
    @Autowired
    GenericDaoImplement genericDao;

    public static final String pathImage="C:\\Users\\yarik\\IdeaProjects\\travelver12\\Travel_System\\src\\main\\webapp\\image\\";
    public static final String pathImageWeb = "/image/";

    @RequestMapping(method = RequestMethod.GET, value = "/addTour.html")
    public ModelAndView getTour(Model model){
        model.addAttribute("tour", new TourEntity());
        return new ModelAndView("adminMainPage");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addTour.html")
    public String saveTour( @ModelAttribute("tour") TourEntity tour, Model model,
                             MultipartFile file){
        byte[] bytes = new byte[0];
        int id =(int)Math.random()*1000;
        String path = pathImage + id + ".png";
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setFilePath(pathImageWeb+id+".png");

        genericDao.create(photoEntity);
        try {
            bytes = file.getBytes();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(path)));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tour.setStartDate(new Date());
        PhotoEntity entity = (PhotoEntity)genericDao.findAll(PhotoEntity.class).get(genericDao.findAll(PhotoEntity.class).size()-1);
        System.out.println(entity.getId());
        tour.setPhotoId(entity.getId()-1);
        genericDao.create(tour);
        //System.out.println(tour);
        return "adminMainPage";
    }
}
