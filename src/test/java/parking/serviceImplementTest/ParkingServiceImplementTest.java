package parking.serviceImplementTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import org.springframework.test.context.junit4.SpringRunner;

import parking.dto.model.RecordDto;
import parking.exception.ResourceNotFoundException;
import parking.model.Fields;
import parking.model.Record;
import parking.repository.ParkingRepository;

import parking.service.ParkingServiceImpl;

@RunWith(SpringRunner.class)
public class ParkingServiceImplementTest {

	@InjectMocks
    ParkingServiceImpl parkingService;
     
    @Mock
    ParkingRepository parkingRepo;
 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    
    @Test
    public void getAllParkingTest() throws ResourceNotFoundException
    {
        List<Record> list = new ArrayList<Record>();
        Record recOne = new Record();
        recOne.setRecordid("200rs200");
        recOne.setFields(new Fields());
        Record recTwo = new Record();
        recTwo.setRecordid("201rs200");
        recTwo.setFields(new Fields());
        Record recThree = new Record();
        recThree.setRecordid("202rs200");
        recThree.setFields(new Fields());
        
        list.add(recOne);
        list.add(recTwo);
        list.add(recThree);
         
        when(parkingRepo.getParking()).thenReturn(list);
         
        //test
        List<RecordDto> recList = parkingService.getParkingList();
         
        assertEquals(3, recList.size());
        verify(parkingRepo, times(1)).getParking();
    }
    
    @Test
    public void getAllParkingByLocationAndDistanceTest() throws ResourceNotFoundException
    {
        List<Record> list = new ArrayList<Record>();
        Record recOne = new Record();
        recOne.setRecordid("200rs200");
        recOne.setFields(new Fields());
        Record recTwo = new Record();
        recTwo.setRecordid("201rs200");
        recTwo.setFields(new Fields());
        Record recThree = new Record();
        recThree.setRecordid("202rs200");
        recThree.setFields(new Fields());
        
        list.add(recOne);
        list.add(recTwo);
        list.add(recThree);
        
        double lat = 48.1143054102;
		double lon = -1.6757817587;
		int dist = 3000; 
         
        when(parkingRepo.getParkingByLocationDistance(lat, lon, dist)).thenReturn(list);
         
        //test
        List<RecordDto> recList = parkingService.getParkingListByLocationDistance(lat, lon, dist);
         
        assertEquals(3, recList.size());
        verify(parkingRepo, times(1)).getParkingByLocationDistance(lat, lon, dist);
    }
}
