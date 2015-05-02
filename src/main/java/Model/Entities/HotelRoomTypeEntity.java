package Model.Entities;

import javax.persistence.*;

/**
 * Created by Администратор on 01.05.2015.
 */
@Entity
@Table(name = "hotel_room_type", schema = "", catalog = "travel_agency")
public class HotelRoomTypeEntity {
    @Id
    private Integer Id;
    private int hotelId;
    private int roomTypesId;
    private Byte deleted;

    @Basic
    @Column(name = "hotelId", nullable = false, insertable = true, updatable = true)
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "roomTypesId", nullable = false, insertable = true, updatable = true)
    public int getRoomTypesId() {
        return roomTypesId;
    }

    public void setRoomTypesId(int roomTypesId) {
        this.roomTypesId = roomTypesId;
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
        if (!(o instanceof HotelRoomTypeEntity)) return false;

        HotelRoomTypeEntity that = (HotelRoomTypeEntity) o;

        if (hotelId != that.hotelId) return false;
        if (roomTypesId != that.roomTypesId) return false;
        if (Id != null ? !Id.equals(that.Id) : that.Id != null) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + hotelId;
        result = 31 * result + roomTypesId;
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
