package za.co.ashtech.jaatm.bea;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import za.co.ashtech.jaatm.bea.dto.GetAccountResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JaatmBeaApplicationTests {
	

    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	void getAccountBalance() {
		
        ResponseEntity<GetAccountResponse> response =
                restTemplate.getForEntity("/api/v1/account/JAATM-U001", GetAccountResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("1500.00", response.getBody().getAccountBalance());
	}

}
