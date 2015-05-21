package Model.dto;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by yarik on 21.05.2015.
 */
@Component
public class TourForList {
    private int id;
    private String imgPath;
    private String name;
    private double price;
    private String description;
    private Date startDate;
    private int countOfDays;
    private boolean hot;

    public TourForList(int id, String imgPath, String name, double price, String description, Date startDate, int countOfDays, boolean hot) {
        this.id = id;
        this.imgPath = imgPath;
        this.name = name;
        this.price = price;
        this.description = description;
        this.startDate = startDate;
        this.countOfDays = countOfDays;
        this.hot = hot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TourForList() {
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getCountOfDays() {
        return countOfDays;
    }

    public void setCountOfDays(int countOfDays) {
        this.countOfDays = countOfDays;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }
}
