
package parking.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dataset",
    "timezone",
    "rows",
    "sort",
    "format",
    "geofilter.distance"
})
public class Parameters {

    @JsonProperty("dataset")
    private List<String> dataset = null;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("rows")
    private Integer rows;
    @JsonProperty("sort")
    private List<String> sort = null;
    @JsonProperty("format")
    private String format;
    @JsonProperty("geofilter.distance")
    private List<String> geofilterDistance = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dataset")
    public List<String> getDataset() {
        return dataset;
    }

    @JsonProperty("dataset")
    public void setDataset(List<String> dataset) {
        this.dataset = dataset;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("rows")
    public Integer getRows() {
        return rows;
    }

    @JsonProperty("rows")
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @JsonProperty("sort")
    public List<String> getSort() {
        return sort;
    }

    @JsonProperty("sort")
    public void setSort(List<String> sort) {
        this.sort = sort;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("geofilter.distance")
    public List<String> getGeofilterDistance() {
        return geofilterDistance;
    }

    @JsonProperty("geofilter.distance")
    public void setGeofilterDistance(List<String> geofilterDistance) {
        this.geofilterDistance = geofilterDistance;
    }



}
