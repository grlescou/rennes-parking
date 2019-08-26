package parking.dto.mapper;

import parking.dto.model.FieldDto;
import parking.model.Fields;

public class FieldMapper {

	public static FieldDto toDto(Fields fields) {
		
		FieldDto fieldDto = new FieldDto();

				fieldDto.setDist(fields.getDist());
				fieldDto.setFree(fields.getFree());
				fieldDto.setGeo(fields.getGeo());
				fieldDto.setId(fields.getId());
				fieldDto.setKey(fields.getKey());
				fieldDto.setMax(fields.getMax());
				fieldDto.setOrgahoraires(fields.getOrgahoraires());
				fieldDto.setStatus(fields.getStatus());
				fieldDto.setTarif15(fields.getTarif15());
				fieldDto.setTarif1h(fields.getTarif1h());
				fieldDto.setTarif1h30(fields.getTarif1h30());
				fieldDto.setTarif2h(fields.getTarif2h());
				fieldDto.setTarif30(fields.getTarif30());
				fieldDto.setTarif3h(fields.getTarif3h());
				fieldDto.setTarif4h(fields.getTarif4h());
				
	 return fieldDto;
				
	}

}
