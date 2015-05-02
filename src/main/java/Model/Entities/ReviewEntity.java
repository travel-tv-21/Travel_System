package Model.Entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Администратор on 01.05.2015.
 */
@Entity
@Table(name = "review", schema = "", catalog = "travel_agency")
public class ReviewEntity {
    private int id;
    private String desciption;
    private Date dateSubmit;
    private int tourForReviews;
    private int userId;
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
    @Column(name = "desciption", nullable = false, insertable = true, updatable = true, length = 65535)
    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Basic
    @Column(name = "dateSubmit", nullable = true, insertable = true, updatable = true)
    public Date getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(Date dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    @Basic
    @Column(name = "tourForReviews", nullable = false, insertable = true, updatable = true)
    public int getTourForReviews() {
        return tourForReviews;
    }

    public void setTourForReviews(int tourForReviews) {
        this.tourForReviews = tourForReviews;
    }

    @Basic
    @Column(name = "userId", nullable = false, insertable = true, updatable = true)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

        ReviewEntity that = (ReviewEntity) o;

        if (id != that.id) return false;
        if (tourForReviews != that.tourForReviews) return false;
        if (userId != that.userId) return false;
        if (dateSubmit != null ? !dateSubmit.equals(that.dateSubmit) : that.dateSubmit != null) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;
        if (desciption != null ? !desciption.equals(that.desciption) : that.desciption != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (desciption != null ? desciption.hashCode() : 0);
        result = 31 * result + (dateSubmit != null ? dateSubmit.hashCode() : 0);
        result = 31 * result + tourForReviews;
        result = 31 * result + userId;
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }
}
