package Model.Entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
/**
 * Created by Администратор on 01.05.2015.
 */
@Entity
@Table(name = "tour_marshrut", schema = "", catalog = "travel_agency")
public class TourMarshrutEntity {
    @Id
    private Integer Id;
    private int tourId;
    private int marshrutId;
    private Byte deleted;

    @Basic
    @Column(name = "tourId", nullable = false, insertable = true, updatable = true)
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    @Basic
    @Column(name = "marshrutId", nullable = false, insertable = true, updatable = true)
    public int getMarshrutId() {
        return marshrutId;
    }

    public void setMarshrutId(int marshrutId) {
        this.marshrutId = marshrutId;
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

        TourMarshrutEntity that = (TourMarshrutEntity) o;

        if (marshrutId != that.marshrutId) return false;
        if (tourId != that.tourId) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tourId;
        result = 31 * result + marshrutId;
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
