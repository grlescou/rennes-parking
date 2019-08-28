package fr.grlescou.parking.service;

import java.util.List;

import fr.grlescou.parking.dto.model.RecordDto;
import fr.grlescou.parking.exception.ResourceNotFoundException;

public interface ParkingService {
	
	
	/**
     * Get all the parking in Rennes
     *
     * @param
     * @return List<RecordDto>
     * @throws ResourceNotFoundException 
     */
	public List<RecordDto> getParkingList() throws ResourceNotFoundException;
	
	
	
	/**
     * Get all the parking in Rennes related to the person localization (lat, lon) and a specify redius distance dist
     *
     * @param lat   
     * @param lon
     * @param dist
     * @return List<RecordDto>
     * @throws ResourceNotFoundException 
     */
	public List<RecordDto> getParkingListByLocationDistance(double lat, double lon, int dist) throws ResourceNotFoundException;
	
}
