package com.nf.model.iconomi;

public class DAAAllocation {
    private String daaName;
    private Double allocationValue;

    public DAAAllocation(String daaName, Double allocationValue) {
        this.daaName = daaName;
        this.allocationValue = allocationValue;
    }



    public Double getAllocationValue() {
        return allocationValue;
    }

    public void setAllocationValue(Double allocationValue) {
        this.allocationValue = allocationValue;
    }

    public String getDaaName() {
        return daaName;
    }

    public void setDaaName(String daaName) {
        this.daaName = daaName;
    }
}
