package Model.Entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Администратор on 01.05.2015.
 */
@Entity
@Table(name = "tour", schema = "", catalog = "travel_agency")
public class TourEntity {
    private int id;
    private int numday;
    private int numPeopleId;
    private String description;
    private int hotelId;
    private Date startDate;
    private boolean insurance;
    private boolean hot;
    private Integer restTypeId;
    private double rating;
    private int photoId;
    private Byte deleted;
    private double price;
    private String name;
    

    public TourEntity() {
    }

    public TourEntity(String description, int numday, boolean insurance, boolean hot, double price, String name) {
        this.description = description;
        this.numday = numday;
        this.insurance = insurance;
        this.hot = hot;
        this.price = price;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "numday",  insertable = true, updatable = true)
    public int getNumday() {
        return numday;
    }

    public void setNumday(int numday) {
        this.numday = numday;
    }

    @Basic
    @Column(name = "numPeopleId",  insertable = true, updatable = true)
    public int getNumPeopleId() {
        return numPeopleId;
    }

    public void setNumPeopleId(int numPeopleId) {
        this.numPeopleId = numPeopleId;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "hotelId", insertable = true, updatable = true)
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "startDate", insertable = true, updatable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "insurance", nullable = true, insertable = true, updatable = true)
    public boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    @Basic
    @Column(name = "hot", nullable = true, insertable = true, updatable = true)
    public boolean getHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    @Basic
    @Column(name = "restTypeId", nullable = true, insertable = true, updatable = true)
    public Integer getRestTypeId() {
        return restTypeId;
    }

    public void setRestTypeId(Integer restTypeId) {
        this.restTypeId = restTypeId;
    }

    @Basic
    @Column(name = "Rating", insertable = true, updatable = true, precision = 0)
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "photoId", nullable = false, insertable = true, updatable = true)
    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    @Basic
    @Column(name = "deleted", nullable = true, insertable = true, updatable = true)
    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourEntity that = (TourEntity) o;

        if (hotelId != that.hotelId) return false;
        if (id != that.id) return false;
        if (numPeopleId != that.numPeopleId) return false;
        if (numday != that.numday) return false;
        if (photoId != that.photoId) return false;
        if (Double.compare(that.rating, rating) != 0) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        if (restTypeId != null ? !restTypeId.equals(that.restTypeId) : that.restTypeId != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + numday;
        result = 31 * result + numPeopleId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + hotelId;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (restTypeId != null ? restTypeId.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + photoId;
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }
}
