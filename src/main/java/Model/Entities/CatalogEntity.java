package Model.Entities;

import javax.persistence.*;

/**
 * Created by Администратор on 01.05.2015.
 */
@Entity
@Table(name = "catalog", schema = "", catalog = "travel_agency")
public class CatalogEntity {
    private int id;
    private String name;
    private Integer tourItem;

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
    @Column(name = "tourItem", nullable = true, insertable = true, updatable = true)
    public Integer getTourItem() {
        return tourItem;
    }

    public void setTourItem(Integer tourItem) {
        this.tourItem = tourItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatalogEntity that = (CatalogEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (tourItem != null ? !tourItem.equals(that.tourItem) : that.tourItem != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tourItem != null ? tourItem.hashCode() : 0);
        return result;
    }
}
