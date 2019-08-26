package fr.grlescou.parking.dto.mapper;

import fr.grlescou.parking.dto.model.RecordDto;
import fr.grlescou.parking.model.Record;

public class RecordMapper {
	
	public static  RecordDto toRecordDto(Record record) {
		
		RecordDto recordDto =  new RecordDto();
				recordDto.setDatasetid(record.getDatasetid());
				recordDto.setRecordid(record.getRecordid());
				recordDto.setFieldDto(FieldMapper.toDto(record.getFields()));
				recordDto.setRecordTimestamp(record.getRecordTimestamp());
		
		return recordDto;
	}

}
