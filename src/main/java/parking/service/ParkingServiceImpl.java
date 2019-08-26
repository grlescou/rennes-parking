package parking.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parking.repository.ParkingRepository;
import parking.dto.mapper.RecordMapper;
import parking.dto.model.RecordDto;
import parking.exception.ResourceNotFoundException;
import parking.model.*;

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
