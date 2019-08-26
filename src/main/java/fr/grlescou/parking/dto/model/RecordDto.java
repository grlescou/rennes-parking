package fr.grlescou.parking.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import fr.grlescou.parking.model.Fields;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "datasetid",
    "recordid",
    "fieldDto",
    "record_timestamp"
})
@ApiModel(description = "Parking Record information. ")
public class RecordDto {
	
	
	@JsonProperty("datasetid")
	@ApiModelProperty(notes = "The dataset  ID of the external API")
    private String datasetid;
    @JsonProperty("recordid")
    @ApiModelProperty(notes = "The Record ID provided by the API")
    private String recordid;
    @JsonProperty("fields")
    @ApiModelProperty(notes = "The property fields of an Record")
    private FieldDto fieldDto;
    @JsonProperty("record_timestamp")
    @ApiModelProperty(notes = "The timestamps of a Record ")
    private String recordTimestamp;
    
    

    public RecordDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
    @JsonProperty("datasetid")
    public String getDatasetid() {
        return datasetid;
    }

    @JsonProperty("datasetid")
    public void setDatasetid(String datasetid) {
        this.datasetid = datasetid;
    }

    @JsonProperty("recordid")
    public String getRecordid() {
        return recordid;
    }

    @JsonProperty("recordid")
    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    @JsonProperty("fields")
    public FieldDto getFieldDto() {
        return fieldDto;
    }

    @JsonProperty("fields")
    public void setFieldDto(FieldDto FieldDto) {
        this.fieldDto = FieldDto;
    }

    @JsonProperty("record_timestamp")
    public String getRecordTimestamp() {
        return recordTimestamp;
    }

    @JsonProperty("record_timestamp")
    public void setRecordTimestamp(String recordTimestamp) {
        this.recordTimestamp = recordTimestamp;
    }

	@Override
	public String toString() {
		return "Record [datasetid=" + datasetid + ", recordid=" + recordid + ", fields=" + fieldDto + ", recordTimestamp="
				+ recordTimestamp + "]";
	}


    

}
