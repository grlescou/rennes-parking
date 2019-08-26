package fr.grlescou.parking.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.grlescou.parking.exception.ResourceNotFoundException;
import fr.grlescou.parking.model.*;

@Repository
public class ParkingRepository {
	
	@Autowired
    RestTemplate restTemplate;
	
	public List<Record> getParking() throws ResourceNotFoundException{
		
        String theUrl = "https://data.rennesmetropole.fr/api/records/1.0/search/?dataset=export-api-parking-citedia";
        //String theUrl ="https://data.rennesmetropole.fr/api/records/1.0/search/?dataset=export-api-parking-citedia&rows=14&geofilter.distance="+lat+","+lon+","+dist;
        ResponseEntity<Parking> response = restTemplate.exchange(theUrl, HttpMethod.GET, null, Parking.class );
       
        if(response.getStatusCode() == HttpStatus.OK) {
        Parking parking = response.getBody();
        return parking.getRecords();
        }
		
        throw new ResourceNotFoundException("Parking Records not found");
		
	}
	
	public List<Record> getParkingByLocationDistance(double lat, double lon, int dist) throws ResourceNotFoundException{
		
        String theUrl ="https://data.rennesmetropole.fr/api/records/1.0/search/?dataset=export-api-parking-citedia&rows=14&geofilter.distance="+lat+","+lon+","+dist;
        ResponseEntity<Parking> response = restTemplate.exchange(theUrl, HttpMethod.GET, null, Parking.class );
        
        if(response.getStatusCode() == HttpStatus.OK) {
        Parking parking = response.getBody();
        return parking.getRecords();
        }

		
		throw new ResourceNotFoundException("Parking Records not found");
		
	}

}
