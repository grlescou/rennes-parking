package fr.grlescou.parking.service;

import java.util.List;

import fr.grlescou.parking.dto.model.RecordDto;
import fr.grlescou.parking.exception.ResourceNotFoundException;

public interface ParkingService {
	public List<RecordDto> getParkingList() throws ResourceNotFoundException;
	
	public List<RecordDto> getParkingListByLocationDistance(double lat, double lon, int dist) throws ResourceNotFoundException;
	
}
