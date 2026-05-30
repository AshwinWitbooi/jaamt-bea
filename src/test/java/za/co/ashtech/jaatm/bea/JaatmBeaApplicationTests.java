package za.co.ashtech.jaatm.bea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import za.co.ashtech.jaatm.bea.dto.Account;
import za.co.ashtech.jaatm.bea.dto.AccountOpRequest;
import za.co.ashtech.jaatm.bea.dto.AccountOpRequest.OperationEnum;
import za.co.ashtech.jaatm.bea.dto.JaatmUserTransaction;
import za.co.ashtech.jaatm.bea.repository.JaatmTransactionRepository;
import za.co.ashtech.jaatm.bea.dto.TransferRequest;
import za.co.ashtech.jaatm.bea.dto.User;
import za.co.ashtech.jaatm.bea.model.JaatmTransaction;

@Slf4j
class JaatmBeaApplicationTests extends  BaseUnitTest{

	@Autowired
    private TestRestTemplate restTemplate;
	@Autowired
	private JaatmTransactionRepository jaatmTransactionRepository;
	
//	@Test
	void getAccountBalance() {
		
		String juid = "JUID0001";
		
		// 2. Wrap headers in HttpEntity (no body for GET)
		HttpEntity<Object> entity = new HttpEntity<>(getHeaders());
		
		// 3. Call exchange
		ResponseEntity<Account> response = restTemplate.exchange(
		        "/api/v1/account/"+juid,
		        HttpMethod.GET,
		        entity,
		        Account.class
		);
        
        log.debug("--->>>:::	"+response.getStatusCode());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull("0", response.getBody().getBalance());
        Optional<List<JaatmTransaction>> verify = jaatmTransactionRepository.findByJuid(juid);
        verify.ifPresent(v -> log.info("RECORD WAS FOUND"));
	}
	
	
//	@Test
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
	
//	@Test
	void getUserAccount() {
		
		// 2. Wrap headers in HttpEntity (no body for GET)
		HttpEntity<Object> entity = new HttpEntity<>(getHeaders());
		
		// 3. Call exchange
		ResponseEntity<User> response = restTemplate.exchange(
		        "/api/v1/user/JUID0001",
		        HttpMethod.GET,
		        entity,
		        User.class
		);
		        
        log.debug("--->>>:::	"+response.getStatusCode());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
	}
	
//	@Test
	void updateUserAccount() {
		
		// 2. Wrap headers in HttpEntity (no body for GET)
		HttpEntity<Object> getUserentity = new HttpEntity<>(getHeaders());
		
		// 3. Call exchange
		ResponseEntity<User> getUserResponse = restTemplate.exchange(
		        "/api/v1/user/JUID0001",
		        HttpMethod.GET,
		        getUserentity,
		        User.class
		);
		
		User userDetails = getUserResponse.getBody();
		userDetails.setFirstname("Joe");
		
		HttpEntity<Object> entity = new HttpEntity<>(userDetails,getHeaders());
		
		// 3. Call exchange
		ResponseEntity<Void> response = restTemplate.exchange(
		        "/api/v1/user/JUID0001",
		        HttpMethod.PUT,
		        entity,
		        Void.class
		);
		        
        log.debug("--->>>:::	"+response.getStatusCode());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        
		// 3. Call exchange
		ResponseEntity<User> postUpdategetUserResponse = restTemplate.exchange(
		        "/api/v1/user/JUID0001",
		        HttpMethod.GET,
		        getUserentity,
		        User.class
		);
		
		//assert updated name
		assertEquals( "Joe",postUpdategetUserResponse.getBody().getFirstname());
	}
	
//	@Test
	void userAccountDeposit() {

		AccountOpRequest accountOpRequest = new AccountOpRequest();
		accountOpRequest.setAmount(Long.valueOf(10963000));
		accountOpRequest.setOperation(OperationEnum.DEPOSIT);
		// 2. Wrap headers in HttpEntity (no body for GET)
		HttpEntity<Object> getUserentity = new HttpEntity<>(accountOpRequest,getHeaders());
		
		// 3. Call exchange
		ResponseEntity<Void> getUserResponse = restTemplate.exchange(
		        "/api/v1/account/JUID0001",
		        HttpMethod.POST,
		        getUserentity,
		        Void.class
		);
		
		assertEquals(HttpStatus.OK, getUserResponse.getStatusCode());
		
	}
	
//	@Test
	void userAccountTransfer() {
		
		TransferRequest transferRequest = new TransferRequest();
		transferRequest.setAmount("136000");
		log.debug("--->>>:::	AMOUNT TO TRANSFER: "+transferRequest.getAmount());
		transferRequest.setFromAccountNumber("44444222336");
		transferRequest.setToAccountNumber("11111222336");
		transferRequest.setTransferReference("1234987");
		
		// 2. Wrap headers in HttpEntity (no body for GET)
		HttpEntity<Object> transferRequestEntity = new HttpEntity<>(transferRequest,getHeaders());
		
		// 3. Call exchange
		ResponseEntity<Void> getUserResponse = restTemplate.exchange(
		        "/api/v1/account/transfer/JUID0001",
		        HttpMethod.POST,
		        transferRequestEntity,
		        Void.class
		);
		
		assertEquals(HttpStatus.OK, getUserResponse.getStatusCode());		
		
	}

//	@Test
	void userAccountWithdawal() {

		AccountOpRequest accountOpRequest = new AccountOpRequest();
		accountOpRequest.setAmount(Long.valueOf(5000));
		accountOpRequest.setOperation(OperationEnum.WITHDRAWAL);
		// 2. Wrap headers in HttpEntity (no body for GET)
		HttpEntity<Object> getUserentity = new HttpEntity<>(accountOpRequest,getHeaders());
		
		// 3. Call exchange
		ResponseEntity<Void> getUserResponse = restTemplate.exchange(
		        "/api/v1/account/JUID0001",
		        HttpMethod.POST,
		        getUserentity,
		        Void.class
		);
		
		assertEquals(HttpStatus.OK, getUserResponse.getStatusCode());
		
	}
	
	@Test
	void userUserTransactionHistory() {

		// 2. Wrap headers in HttpEntity (no body for GET)
		HttpEntity<Object> entity = new HttpEntity<>(getHeaders());
		
		// 3. Call exchange
		ResponseEntity<List<JaatmUserTransaction>> response = restTemplate.exchange(
		        "/api/v1/user/JUID0001/transaction",
		        HttpMethod.GET,
		        entity,
		        new ParameterizedTypeReference<List<JaatmUserTransaction>>() {}
		);
		        
        log.debug("--->>>:::	"+response.getStatusCode());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
		
	}

}
