package parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ParkingApplication {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication.run(ParkingApplication.class, args);
		
	}
	
	
	 @Bean
	    public RestTemplate getRestTemplate() {
	        return new RestTemplate();
	    }
	

}
