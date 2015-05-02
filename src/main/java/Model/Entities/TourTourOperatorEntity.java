package Model.Entities;

import javax.persistence.*;

/**
 * Created by Администратор on 01.05.2015.
 */
@Entity
@Table(name = "tour_tour_operator", schema = "", catalog = "travel_agency")
public class TourTourOperatorEntity {
    @Id
    private Integer Id;
    private int tourOperatorId;
    private int tourId;
    private Byte deleted;

    @Basic
    @Column(name = "tourOperatorId", nullable = false, insertable = true, updatable = true)
    public int getTourOperatorId() {
        return tourOperatorId;
    }

    public void setTourOperatorId(int tourOperatorId) {
        this.tourOperatorId = tourOperatorId;
    }

    @Basic
    @Column(name = "tourId", nullable = false, insertable = true, updatable = true)
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
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

        TourTourOperatorEntity that = (TourTourOperatorEntity) o;

        if (tourId != that.tourId) return false;
        if (tourOperatorId != that.tourOperatorId) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tourOperatorId;
        result = 31 * result + tourId;
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
