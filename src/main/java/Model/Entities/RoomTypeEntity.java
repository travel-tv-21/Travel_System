package Model.Entities;

import javax.persistence.*;

/**
 * Created by Администратор on 01.05.2015.
 */
@Entity
@Table(name = "room_type", schema = "", catalog = "travel_agency")
public class RoomTypeEntity {
    private int id;
    private String name;
    private String description;
    private Integer roomPhotoId;
    private Integer numberOfPeople;
    private double price;
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
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "roomPhotoId", nullable = true, insertable = true, updatable = true)
    public Integer getRoomPhotoId() {
        return roomPhotoId;
    }

    public void setRoomPhotoId(Integer roomPhotoId) {
        this.roomPhotoId = roomPhotoId;
    }

    @Basic
    @Column(name = "numberOfPeople", nullable = true, insertable = true, updatable = true)
    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

        RoomTypeEntity that = (RoomTypeEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (numberOfPeople != null ? !numberOfPeople.equals(that.numberOfPeople) : that.numberOfPeople != null)
            return false;
        if (roomPhotoId != null ? !roomPhotoId.equals(that.roomPhotoId) : that.roomPhotoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (roomPhotoId != null ? roomPhotoId.hashCode() : 0);
        result = 31 * result + (numberOfPeople != null ? numberOfPeople.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }
}
