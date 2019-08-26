package parking.service;

import java.util.List;

import parking.dto.model.RecordDto;
import parking.exception.ResourceNotFoundException;

public interface ParkingService {
	public List<RecordDto> getParkingList() throws ResourceNotFoundException;
	
	public List<RecordDto> getParkingListByLocationDistance(double lat, double lon, int dist) throws ResourceNotFoundException;
	
}
