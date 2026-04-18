package za.co.ashtech.jaatm.bea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import za.co.ashtech.jaatm.bea.util.JaatmOperationException;

@ExtendWith(MockitoExtension.class)
@Slf4j
class UpdateAccountDetailsTests {

	@Mock
	JaatmUserRepository jaatmUserRepository;

	@InjectMocks
	UpdateUserDetailsImpl updateUserDetailsImpl;
	
	@InjectMocks
	ViewUserAccountDetailsImpl userAccount;

	@Test
	void testUpdateAccount() {
		
		//Create mocked database model
		JaatmUser jaatmUser001= new JaatmUser("JAATM-U001","John", "Queue",LocalDate.of(1988, 12, 3));
		jaatmUser001.setAddress(new JaatmAddress("111", "Akkerboom Straat", "Belhong", "Cape Town", "WC", "7963"));
		jaatmUser001.setAccount(new JaatmAccount(Long.valueOf("1623366"), "Active"));
		
		//Create optional user object
		Optional<JaatmUser> optionalUser = Optional.of(jaatmUser001);

		when(jaatmUserRepository.findByJuid("JAATM-U001")).thenReturn(optionalUser);
		
		User updateUser =  new User();
		updateUser.setFirstname("UpdateMe");
		updateUserDetailsImpl. updateAccount("JAATM-U001", updateUser);
		
		assertEquals("UpdateMe", userAccount.getUserAccount("JAATM-U001").getFirstname());

	}

	@Test
	void testUpdateAccountNull() {

		assertThrows(JaatmOperationException.class, () -> {
			updateUserDetailsImpl.updateAccount(null,null);
		});

	}
	
	
	
	

}
