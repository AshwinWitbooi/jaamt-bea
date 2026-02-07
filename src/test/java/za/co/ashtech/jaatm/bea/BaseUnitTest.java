package za.co.ashtech.jaatm.bea;

import java.util.UUID;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseUnitTest {
	
	
	/*Get common headers for integration test*/
	protected HttpHeaders getHeaders() {
		// 1. Create headers
		HttpHeaders headers = new HttpHeaders();
		headers.set("traceId", UUID.randomUUID().toString());
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		
		return headers;
	}



}
