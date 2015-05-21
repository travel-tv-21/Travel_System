package Model.Entities;

import javax.persistence.*;

@Entity
@Table(name = "toursInShoppingCart", schema = "", catalog = "travel_agency")
public class ToursInShoppingCartEntity {
    private int userId;
    private int tourId;

    public ToursInShoppingCartEntity() {
    }

    public ToursInShoppingCartEntity(int userId, int tourId) {
        this.userId = userId;
        this.tourId = tourId;
    }

    @Basic
    @Column(name = "userId", nullable = true, insertable = true, updatable = true)
    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "tourId", nullable = true, insertable = true, updatable = true)
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    private Integer id;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToursInShoppingCartEntity that = (ToursInShoppingCartEntity) o;

        if (tourId != that.tourId) return false;
        if (userId != that.userId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + tourId;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
