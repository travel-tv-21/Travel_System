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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourForList that = (TourForList) o;

        if (countOfDays != that.countOfDays) return false;
        if (hot != that.hot) return false;
        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (imgPath != null ? !imgPath.equals(that.imgPath) : that.imgPath != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (imgPath != null ? imgPath.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + countOfDays;
        result = 31 * result + (hot ? 1 : 0);
        return result;
    }
}
