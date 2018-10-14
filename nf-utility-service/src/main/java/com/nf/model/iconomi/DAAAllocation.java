package com.nf.model.iconomi;

public class DAAAllocation {
    private String assetName;
    private Double allocationValue;

    public DAAAllocation(String assetName, Double allocationValue) {
        this.assetName = assetName;
        this.allocationValue = allocationValue;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Double getAllocationValue() {
        return allocationValue;
    }

    public void setAllocationValue(Double allocationValue) {
        this.allocationValue = allocationValue;
    }
}
