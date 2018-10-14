
package com.nf.model.iconomi;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rebalancedWeight",
    "targetWeight",
    "assetTicker",
    "assetName",
    "assetCategory"
})
public class Value {

    @JsonProperty("rebalancedWeight")
    private Double rebalancedWeight;
    @JsonProperty("targetWeight")
    private Double targetWeight;
    @JsonProperty("assetTicker")
    private String assetTicker;
    @JsonProperty("assetName")
    private String assetName;
    @JsonProperty("assetCategory")
    private String assetCategory;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rebalancedWeight")
    public Double getRebalancedWeight() {
        return rebalancedWeight;
    }

    @JsonProperty("rebalancedWeight")
    public void setRebalancedWeight(Double rebalancedWeight) {
        this.rebalancedWeight = rebalancedWeight;
    }

    @JsonProperty("targetWeight")
    public Double getTargetWeight() {
        return targetWeight;
    }

    @JsonProperty("targetWeight")
    public void setTargetWeight(Double targetWeight) {
        this.targetWeight = targetWeight;
    }

    @JsonProperty("assetTicker")
    public String getAssetTicker() {
        return assetTicker;
    }

    @JsonProperty("assetTicker")
    public void setAssetTicker(String assetTicker) {
        this.assetTicker = assetTicker;
    }

    @JsonProperty("assetName")
    public String getAssetName() {
        return assetName;
    }

    @JsonProperty("assetName")
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    @JsonProperty("assetCategory")
    public String getAssetCategory() {
        return assetCategory;
    }

    @JsonProperty("assetCategory")
    public void setAssetCategory(String assetCategory) {
        this.assetCategory = assetCategory;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rebalancedWeight", rebalancedWeight).append("targetWeight", targetWeight).append("assetTicker", assetTicker).append("assetName", assetName).append("assetCategory", assetCategory).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(assetName).append(additionalProperties).append(assetCategory).append(targetWeight).append(rebalancedWeight).append(assetTicker).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Value) == false) {
            return false;
        }
        Value rhs = ((Value) other);
        return new EqualsBuilder().append(assetName, rhs.assetName).append(additionalProperties, rhs.additionalProperties).append(assetCategory, rhs.assetCategory).append(targetWeight, rhs.targetWeight).append(rebalancedWeight, rhs.rebalancedWeight).append(assetTicker, rhs.assetTicker).isEquals();
    }

}
