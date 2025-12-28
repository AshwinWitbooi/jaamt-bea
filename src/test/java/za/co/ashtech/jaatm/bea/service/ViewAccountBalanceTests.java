package za.co.ashtech.jaatm.bea.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import lombok.extern.slf4j.Slf4j;
import za.co.ashtech.jaatm.bea.dto.GetAccountResponse;
import za.co.ashtech.jaatm.bea.model.JaatmAccount;
import za.co.ashtech.jaatm.bea.model.JaatmUser;
import za.co.ashtech.jaatm.bea.repository.JaatmUserRepository;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ViewAccountBalanceTests {

	@Mock
	JaatmUserRepository jaatmUserRepository;

	@InjectMocks
	ViewAccountBalanceImpl accountBalance;

	@Test
	void testAccountBalance() {
		
		//Create mocked database model
		JaatmUser jaatmUser001= new JaatmUser("JAATM-U001","John", "Queue");
		jaatmUser001.setAccount(new JaatmAccount(Long.valueOf("1623366"), "Active"));
		
		//Create optional user object
		Optional<JaatmUser> optionalUser = Optional.of(jaatmUser001);

		when(jaatmUserRepository.findByJuid("JAATM-U001")).thenReturn(optionalUser);
		
		GetAccountResponse accountBalanceResponse = accountBalance.getAccountBalance("JAATM-U001");
		
		log.info("BALANCE AMOUNT:" + new BigDecimal(accountBalanceResponse.getAccountBalance()).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));

		assertNotNull(accountBalanceResponse);
	}

	@Test
	void testAccountBalanceJuidNull() {

		assertThrows(NullPointerException.class, () -> {
			accountBalance.getAccountBalance(null);
		});

	}

}
