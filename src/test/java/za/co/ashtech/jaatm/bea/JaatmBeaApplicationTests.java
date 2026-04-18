package za.co.ashtech.jaatm.bea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import za.co.ashtech.jaatm.bea.dto.Account;
import za.co.ashtech.jaatm.bea.dto.User;

@Slf4j
class JaatmBeaApplicationTests extends  BaseUnitTest{
	
    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	void getAccountBalance() {
		
		// 2. Wrap headers in HttpEntity (no body for GET)
		HttpEntity<Object> entity = new HttpEntity<>(getHeaders());
		
		// 3. Call exchange
		ResponseEntity<Account> response = restTemplate.exchange(
		        "/api/v1/account/JAATM-U001",
		        HttpMethod.GET,
		        entity,
		        Account.class
		);
        
        log.debug("--->>>:::	"+response.getStatusCode());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("1500.00", response.getBody().getBalance());
	}
	
	
	@Test
	void getAccountBalanceNoUser() {
		
		// 2. Wrap headers in HttpEntity (no body for GET)
		HttpEntity<Object> entity = new HttpEntity<>(getHeaders());
		
		// 3. Call exchange
		ResponseEntity<Account> response = restTemplate.exchange(
		        "/api/v1/account/JAATM-ERROR",
		        HttpMethod.GET,
		        entity,
		        Account.class
		);

        log.debug("--->>>:::	"+response.getStatusCode());
        
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());		
	}
	
	@Test
	void getUserAccount() {
		
		// 2. Wrap headers in HttpEntity (no body for GET)
		HttpEntity<Object> entity = new HttpEntity<>(getHeaders());
		
		// 3. Call exchange
		ResponseEntity<User> response = restTemplate.exchange(
		        "/api/v1/user/JAATM-U001",
		        HttpMethod.GET,
		        entity,
		        User.class
		);
		        
        log.debug("--->>>:::	"+response.getStatusCode());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
	}
	
	@Test
	void updateUserAccount() {
		
		// 2. Wrap headers in HttpEntity (no body for GET)
		HttpEntity<Object> getUserentity = new HttpEntity<>(getHeaders());
		
		// 3. Call exchange
		ResponseEntity<User> getUserResponse = restTemplate.exchange(
		        "/api/v1/user/JAATM-U001",
		        HttpMethod.GET,
		        getUserentity,
		        User.class
		);
		
		User userDetails = getUserResponse.getBody();
		userDetails.setFirstname("Updated Name");
		
		HttpEntity<Object> entity = new HttpEntity<>(userDetails,getHeaders());
		
		// 3. Call exchange
		ResponseEntity<Void> response = restTemplate.exchange(
		        "/api/v1/user/JAATM-U001",
		        HttpMethod.PUT,
		        entity,
		        Void.class
		);
		        
        log.debug("--->>>:::	"+response.getStatusCode());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        
		// 3. Call exchange
		ResponseEntity<User> postUpdategetUserResponse = restTemplate.exchange(
		        "/api/v1/user/JAATM-U001",
		        HttpMethod.GET,
		        getUserentity,
		        User.class
		);
		
		//assert updated name
		assertEquals( "Updated Name",postUpdategetUserResponse.getBody().getFirstname());
	}
	

}
