
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
    "structure"
})
public class DAAStructure {

    @JsonProperty("structure")
    private Structure structure;

    @JsonProperty("structure")
    public Structure getStructure() {
        return structure;
    }

    @JsonProperty("structure")
    public void setStructure(Structure structure) {
        this.structure = structure;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).append("structure", structure).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(structure).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DAAStructure) == false) {
            return false;
        }
        DAAStructure rhs = ((DAAStructure) other);
        return new EqualsBuilder().append(structure, rhs.structure).isEquals();
    }

}
