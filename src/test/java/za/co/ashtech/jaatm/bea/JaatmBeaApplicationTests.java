package za.co.ashtech.jaatm.bea;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;
import za.co.ashtech.jaatm.bea.dto.Account;
import za.co.ashtech.jaatm.bea.dto.ApiErrorResponse;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JaatmBeaApplicationTests {
	
    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	void getAccountBalance() {
		
        ResponseEntity<Account> response =
                restTemplate.getForEntity("/api/v1/account/JAATM-U001", Account.class);
        
        log.debug("--->>>:::	"+response.getStatusCode());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("1500.00", response.getBody().getBalance());
	}
	
	
	@Test
	void getAccountBalanceNoUser() {
		
        ResponseEntity<ApiErrorResponse> response =
                restTemplate.getForEntity("/api/v1/account/JAATM-ERROR", ApiErrorResponse.class);

        log.debug("--->>>:::	"+response.getStatusCode());
        
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());		
	}
	

}
