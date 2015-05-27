package Model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by yarik on 26.05.2015.
 */
public class FilterForm {
    private double minPrice;
    private double maxPrice;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startDateFrom;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startDateTo;
    private int minDaysCount;
    private int maxDaysCount;
    private boolean hot;

    public FilterForm() {
    }

    public FilterForm(double minPrice, double maxPrice, Date startDateFrom, Date startDateTo, int minDaysCount, int maxDaysCount, boolean hot) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.startDateFrom = startDateFrom;
        this.startDateTo = startDateTo;
        this.minDaysCount = minDaysCount;
        this.maxDaysCount = maxDaysCount;
        this.hot = hot;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Date getStartDateFrom() {
        return startDateFrom;
    }

    public void setStartDateFrom(Date startDateFrom) {
        this.startDateFrom = startDateFrom;
    }

    public Date getStartDateTo() {
        return startDateTo;
    }

    public void setStartDateTo(Date startDateTo) {
        this.startDateTo = startDateTo;
    }

    public int getMinDaysCount() {
        return minDaysCount;
    }

    public void setMinDaysCount(int minDaysCount) {
        this.minDaysCount = minDaysCount;
    }

    public int getMaxDaysCount() {
        return maxDaysCount;
    }

    public void setMaxDaysCount(int maxDaysCount) {
        this.maxDaysCount = maxDaysCount;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }
}
