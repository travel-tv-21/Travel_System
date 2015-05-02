package Model.Entities;

import javax.persistence.*;

/**
 * Created by Администратор on 01.05.2015.
 */
@Entity
@Table(name = "hotel", schema = "", catalog = "travel_agency")
public class HotelEntity {
    private int id;
    private String name;
    private String country;
    private double rating;
    private String city;
    private int typeFoodId;
    private String description;
    private int hotelPhotoId;
    private Byte deleted;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country", nullable = false, insertable = true, updatable = true, length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "rating", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "city", nullable = true, insertable = true, updatable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "typeFoodId", nullable = false, insertable = true, updatable = true)
    public int getTypeFoodId() {
        return typeFoodId;
    }

    public void setTypeFoodId(int typeFoodId) {
        this.typeFoodId = typeFoodId;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "hotelPhotoId", nullable = false, insertable = true, updatable = true)
    public int getHotelPhotoId() {
        return hotelPhotoId;
    }

    public void setHotelPhotoId(int hotelPhotoId) {
        this.hotelPhotoId = hotelPhotoId;
    }

    @Basic
    @Column(name = "deleted", nullable = true, insertable = true, updatable = true)
    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelEntity that = (HotelEntity) o;

        if (hotelPhotoId != that.hotelPhotoId) return false;
        if (id != that.id) return false;
        if (Double.compare(that.rating, rating) != 0) return false;
        if (typeFoodId != that.typeFoodId) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + typeFoodId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + hotelPhotoId;
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }
}
