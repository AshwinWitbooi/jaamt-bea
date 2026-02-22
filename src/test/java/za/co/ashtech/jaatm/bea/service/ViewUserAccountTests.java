package za.co.ashtech.jaatm.bea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import lombok.extern.slf4j.Slf4j;
import za.co.ashtech.jaatm.bea.dto.User;
import za.co.ashtech.jaatm.bea.model.JaatmAccount;
import za.co.ashtech.jaatm.bea.model.JaatmAddress;
import za.co.ashtech.jaatm.bea.model.JaatmUser;
import za.co.ashtech.jaatm.bea.repository.JaatmUserRepository;
import za.co.ashtech.jaatm.bea.util.UserNotFoundException;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ViewUserAccountTests {

	@Mock
	JaatmUserRepository jaatmUserRepository;

	@InjectMocks
	ViewUserAccountDetailsImpl userAccount;

	@Test
	void testUserAccount() {
		
		//Create mocked database model
		JaatmUser jaatmUser001= new JaatmUser("JAATM-U001","John", "Queue",LocalDate.of(1988, 12, 3));
		jaatmUser001.setAddress(new JaatmAddress("111", "Akkerboom Straat", "Belhong", "Cape Town", "WC", "7963"));
		jaatmUser001.setAccount(new JaatmAccount(Long.valueOf("1623366"), "Active"));
		
		//Create optional user object
		Optional<JaatmUser> optionalUser = Optional.of(jaatmUser001);

		when(jaatmUserRepository.findByJuid("JAATM-U001")).thenReturn(optionalUser);
		
		 User userAccountResponse = userAccount.getUserAccount("JAATM-U001");
		
		assertNotNull(userAccountResponse);
		assertEquals("John", userAccountResponse.getFirstname());
	}

	@Test
	void testAccountBalanceJuidNull() {

		assertThrows(UserNotFoundException.class, () -> {
			userAccount.getUserAccount(null);
		});

	}
	
	
	
	

}
