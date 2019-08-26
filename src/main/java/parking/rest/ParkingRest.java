package parking.rest;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.http.ResponseEntity;

import parking.dto.model.RecordDto;
import parking.exception.ResourceNotFoundException;
import parking.model.Record;
import parking.service.ParkingServiceImpl;

@RestController
@RequestMapping("/api/v1/parking")
@Api(value = "Parking Record information Management", description = "Operations concerning parking record")
@CrossOrigin(origins = "*")
public class ParkingRest {
	
	@Autowired
	ParkingServiceImpl parkingSvc;
	
	@ApiOperation(value = "Get all parking Record")
	@RequestMapping(value="", method = RequestMethod.GET)
	public ResponseEntity<List<RecordDto>> getParking() throws ResourceNotFoundException {
		
			
		List<RecordDto> recordDtoList = parkingSvc.getParkingList();
	
	  
	  if(!recordDtoList.isEmpty())
		  return ResponseEntity.ok().body(recordDtoList);
	  
	  return ResponseEntity.ok().body(Collections.emptyList());
		
	  
	  
	}
	
	@ApiOperation(value = "Get all parking Record by providing latitude, longitude and a radius distance in meter")
	@RequestMapping(value="/lat/{lat}/lon/{lon}/dist/{dist}", method = RequestMethod.GET)
	public ResponseEntity<List<RecordDto>>  getParking( @ApiParam(value = "latitude", required = true)@PathVariable(value = "lat") double lat, 
			@ApiParam(value = "longitude", required = true) @PathVariable(value = "lon") double lon, 
			@ApiParam(value = "distance in meter", required = true) @PathVariable(value = "dist") int dist) throws ResourceNotFoundException {
		
		/*lat = 48.1143054102;
		lon = -1.6757817587;
		dist = 3000; */
		
		List<RecordDto> recordDtoList = parkingSvc.getParkingListByLocationDistance(lat, lon, dist);
				
		
		 if(!recordDtoList.isEmpty())
			  return ResponseEntity.ok().body(recordDtoList);
		  
		  return ResponseEntity.ok().body(Collections.emptyList());
		
		
	}

}
