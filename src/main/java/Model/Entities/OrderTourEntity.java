package Model.Entities;

import javax.persistence.*;

/**
 * Created by Администратор on 01.05.2015.
 */
@Entity
@Table(name = "order_tour", schema = "", catalog = "travel_agency")
public class OrderTourEntity {
    @Id
    private Integer id;
    private int orderId;
    private int tourId;
    private Byte deleted;

    @Basic
    @Column(name = "orderId", nullable = false, insertable = true, updatable = true)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
        if (!(o instanceof OrderTourEntity)) return false;

        OrderTourEntity that = (OrderTourEntity) o;

        if (orderId != that.orderId) return false;
        if (tourId != that.tourId) return false;
        if (!deleted.equals(that.deleted)) return false;
        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + orderId;
        result = 31 * result + tourId;
        result = 31 * result + deleted.hashCode();
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
