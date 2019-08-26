
package fr.grlescou.parking.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "tarif_1h30",
    "dist",
    "key",
    "tarif_1h",
    "max",
    "orgahoraires",
    "tarif_3h",
    "tarif_2h",
    "free",
    "tarif_30",
    "tarif_4h",
    "geo",
    "id",
    "tarif_15"
})
public class Fields {

    @JsonProperty("status")
    private String status;
    @JsonProperty("tarif_1h30")
    private String tarif1h30;
    @JsonProperty("dist")
    private String dist;
    @JsonProperty("key")
    private String key;
    @JsonProperty("tarif_1h")
    private String tarif1h;
    @JsonProperty("max")
    private Integer max;
    @JsonProperty("orgahoraires")
    private String orgahoraires;
    @JsonProperty("tarif_3h")
    private String tarif3h;
    @JsonProperty("tarif_2h")
    private String tarif2h;
    @JsonProperty("free")
    private Integer free;
    @JsonProperty("tarif_30")
    private String tarif30;
    @JsonProperty("tarif_4h")
    private String tarif4h;
    @JsonProperty("geo")
    private List<Double> geo = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("tarif_15")
    private String tarif15;
    
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("tarif_1h30")
    public String getTarif1h30() {
        return tarif1h30;
    }

    @JsonProperty("tarif_1h30")
    public void setTarif1h30(String tarif1h30) {
        this.tarif1h30 = tarif1h30;
    }

    @JsonProperty("dist")
    public String getDist() {
        return dist;
    }

    @JsonProperty("dist")
    public void setDist(String dist) {
        this.dist = dist;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("tarif_1h")
    public String getTarif1h() {
        return tarif1h;
    }

    @JsonProperty("tarif_1h")
    public void setTarif1h(String tarif1h) {
        this.tarif1h = tarif1h;
    }

    @JsonProperty("max")
    public Integer getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Integer max) {
        this.max = max;
    }

    @JsonProperty("orgahoraires")
    public String getOrgahoraires() {
        return orgahoraires;
    }

    @JsonProperty("orgahoraires")
    public void setOrgahoraires(String orgahoraires) {
        this.orgahoraires = orgahoraires;
    }

    @JsonProperty("tarif_3h")
    public String getTarif3h() {
        return tarif3h;
    }

    @JsonProperty("tarif_3h")
    public void setTarif3h(String tarif3h) {
        this.tarif3h = tarif3h;
    }

    @JsonProperty("tarif_2h")
    public String getTarif2h() {
        return tarif2h;
    }

    @JsonProperty("tarif_2h")
    public void setTarif2h(String tarif2h) {
        this.tarif2h = tarif2h;
    }

    @JsonProperty("free")
    public Integer getFree() {
        return free;
    }

    @JsonProperty("free")
    public void setFree(Integer free) {
        this.free = free;
    }

    @JsonProperty("tarif_30")
    public String getTarif30() {
        return tarif30;
    }

    @JsonProperty("tarif_30")
    public void setTarif30(String tarif30) {
        this.tarif30 = tarif30;
    }

    @JsonProperty("tarif_4h")
    public String getTarif4h() {
        return tarif4h;
    }

    @JsonProperty("tarif_4h")
    public void setTarif4h(String tarif4h) {
        this.tarif4h = tarif4h;
    }

    @JsonProperty("geo")
    public List<Double> getGeo() {
        return geo;
    }

    @JsonProperty("geo")
    public void setGeo(List<Double> geo) {
        this.geo = geo;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("tarif_15")
    public String getTarif15() {
        return tarif15;
    }

    @JsonProperty("tarif_15")
    public void setTarif15(String tarif15) {
        this.tarif15 = tarif15;
    }

	@Override
	public String toString() {
		return "Fields [status=" + status + ", tarif1h30=" + tarif1h30 + ", dist=" + dist + ", key=" + key
				+ ", tarif1h=" + tarif1h + ", max=" + max + ", orgahoraires=" + orgahoraires + ", tarif3h=" + tarif3h
				+ ", tarif2h=" + tarif2h + ", free=" + free + ", tarif30=" + tarif30 + ", tarif4h=" + tarif4h + ", geo=("
				+ geo.get(0)+","+geo.get(1) + "), id=" + id + ", tarif15=" + tarif15 + "]";
	}



}
