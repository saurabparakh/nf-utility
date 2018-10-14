package com.nf.model.iconomi;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Document(collection = "AssetStats")
public class AssetStats implements Comparable{

     @Id
     private String id;
     @Indexed
     private String name;
     @Indexed
     private Integer month;
     @Indexed
     private Integer date;
     @Indexed
     private Integer year;
     private Integer numberOfDAAs;
     private Double highestAllocationPercentage;
     private Double averageAllocationPercentage;
     private List<DAAAllocation> daaAllocationList = new ArrayList<>();
     private Date createdDate;

    public AssetStats() {
        Calendar cal = Calendar.getInstance();
        this.setDate(cal.get(Calendar.DATE));
        this.setMonth(cal.get(Calendar.MONTH));
        this.setYear(cal.get(Calendar.YEAR));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfDAAs() {
        return numberOfDAAs;
    }

    public void setNumberOfDAAs(Integer numberOfDAAs) {
        this.numberOfDAAs = numberOfDAAs;
    }

    public Double getHighestAllocationPercentage() {
        return highestAllocationPercentage;
    }

    public void setHighestAllocationPercentage(Double highestAllocationPercentage) {
        this.highestAllocationPercentage = highestAllocationPercentage;
    }

    public Double getAverageAllocationPercentage() {
        return averageAllocationPercentage;
    }

    public void setAverageAllocationPercentage(Double averageAllocationPercentage) {
        this.averageAllocationPercentage = averageAllocationPercentage;
    }

    public List<DAAAllocation> getDaaAllocationList() {
        return daaAllocationList;
    }

    public void setDaaAllocationList(List<DAAAllocation> daaAllocationList) {
        this.daaAllocationList = daaAllocationList;
    }

    public void calculate() {
        double highest = 0;
        double sum = 0;
        for(DAAAllocation daaAllocation: daaAllocationList) {
            sum = sum + daaAllocation.getAllocationValue();
            if(highest < daaAllocation.getAllocationValue())    {
                highest = daaAllocation.getAllocationValue();
            }
        }
        this.setHighestAllocationPercentage(highest);
        this.setAverageAllocationPercentage(sum/daaAllocationList.size());
        this.setNumberOfDAAs(daaAllocationList.size());
    }

    @Override
    public int compareTo(Object o) {
        return this.getNumberOfDAAs().compareTo(((AssetStats)o).getNumberOfDAAs());
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }
}
