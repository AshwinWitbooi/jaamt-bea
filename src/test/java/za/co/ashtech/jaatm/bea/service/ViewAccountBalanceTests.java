package za.co.ashtech.jaatm.bea.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class ViewAccountBalanceTests {

	@Autowired
	IViewAccountBalance accountBalance;

	@Test
	void testAccountBalance() {
		String u001 = accountBalance.getAccountBalance("JAATM-U001");

		log.info("BALANCE AMOUNT:"+Long.valueOf(u001)/100);
		
		assertNotNull(u001);
	}
	
	
	@Test
	void testAccountBalanceJuidNull() {
		
		assertThrows(NullPointerException.class, () -> {
			accountBalance.getAccountBalance(null);
		});

	}

}
