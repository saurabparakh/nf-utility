package com.nf.model.iconomi;

public class CustomDate {

    private Integer date;
    private Integer month;
    private Integer year;

    public CustomDate(Integer date, Integer month, Integer year ) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
