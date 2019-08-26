package fr.grlescou.parking.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grlescou.parking.dto.mapper.RecordMapper;
import fr.grlescou.parking.dto.model.RecordDto;
import fr.grlescou.parking.exception.ResourceNotFoundException;
import fr.grlescou.parking.model.*;
import fr.grlescou.parking.repository.ParkingRepository;

@Service
public class ParkingServiceImpl implements ParkingService{

	
	@Autowired
	ParkingRepository parkingRepo;
	
	
	/**
     * Function to locate all the Parking Record "Record" and then
     * filter the results as per the given date based on data present in
     * trip schedule collection.
     *
     * @param sourceStopCode
     * @param destinationStopCode
     * @param tripDate
     * @return list of Parking Record "RecordDto" on given distance
	 * @throws ResourceNotFoundException 
     */
	
	@Override
	public List<RecordDto> getParkingList() throws ResourceNotFoundException{
		
		List<Record> RecordList = parkingRepo.getParking();
		if (!RecordList.isEmpty()) {
			return RecordList.stream()
					.map(record -> RecordMapper.toRecordDto(record))
					.collect(Collectors.toList());
			
			}
			
			return Collections.emptyList();
	}
	
	
	
	/**
     * Function to locate all the Parking Record "Record"  by location (lat,lon) and 
     * by a given distant radius
     *
     * @param lat
     * @param long
     * @param dist
     * @return list of Parking Record "RecordDto" on given distance
	 * @throws ResourceNotFoundException 
     */
	@Override
	public List<RecordDto> getParkingListByLocationDistance(double lat, double lon, int dist) throws ResourceNotFoundException{
		List<Record> RecordList =  parkingRepo.getParkingByLocationDistance(lat, lon, dist);
		
		if (!RecordList.isEmpty()) {
		return RecordList.stream()
				.map(record -> RecordMapper.toRecordDto(record))
				.collect(Collectors.toList());
		
		}
		
		return Collections.emptyList();
		
	}
	
	
}
