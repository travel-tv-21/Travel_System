package businesslogic;

import Model.Entities.PhotoEntity;
import Model.Entities.TourEntity;
import Model.dao.interfaces.GenericDao;
import Model.dto.TourForList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yarik on 21.05.2015.
 */
@Component
public class ToursForListFiller {
    @Autowired
    private GenericDao genericDao;
    public void fillList(List<TourEntity>dbTours, List<TourForList> toursForList) {
        for (TourEntity tour : dbTours) {
            TourForList t = new TourForList();
            t.setId(tour.getId());
            t.setName(tour.getName());
            t.setDescription(tour.getDescription());
            t.setCountOfDays(tour.getNumday());
            t.setHot(tour.getHot());
            t.setStartDate(tour.getStartDate());
            t.setPrice(tour.getPrice());
            PhotoEntity photo = (PhotoEntity)genericDao.findById(PhotoEntity.class, tour.getPhotoId());
            t.setImgPath(photo.getFilePath());
            toursForList.add(t);
        }
    }
}
