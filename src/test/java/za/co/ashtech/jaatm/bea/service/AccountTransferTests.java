package za.co.ashtech.jaatm.bea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;
import za.co.ashtech.jaatm.bea.dto.TransferRequest;
import za.co.ashtech.jaatm.bea.model.JaatmAccount;
import za.co.ashtech.jaatm.bea.model.JaatmAddress;
import za.co.ashtech.jaatm.bea.model.JaatmUser;
import za.co.ashtech.jaatm.bea.repository.JaatmUserRepository;

@ExtendWith(MockitoExtension.class)
@Slf4j
class AccountTransferTests {

	@Mock
	JaatmUserRepository jaatmUserRepository;

	@InjectMocks
	AccountTransferImpl accountTransferImpl;
	
	@InjectMocks
	ViewUserAccountDetailsImpl userAccount;
	
	@Test
	void testUpdateAccount() {
		
		String juid = "JAATM-U001";
		
		//Create mocked database model
		JaatmUser jaatmUser001= new JaatmUser(juid,"John", "Queue",LocalDate.of(1988, 12, 3));
			jaatmUser001.setAddress(new JaatmAddress("111", "Akkerboom Straat", "Belhong", "Cape Town", "WC", "7963"));
			jaatmUser001.setAccount(new JaatmAccount(Long.valueOf("1623366"), "Active"));
		
		//Create optional user object
		Optional<JaatmUser> optionalUser = Optional.of(jaatmUser001);

		when(jaatmUserRepository.findByJuid(juid)).thenReturn(optionalUser);
		

		
			TransferRequest transferRequest = new TransferRequest();
			transferRequest.setAmount("10000");
			transferRequest.setFromAccountNumber("12346987");
			transferRequest.setToAccountNumber("12346987");
			transferRequest.setTransferReference("TR1236987");;
			
			accountTransferImpl.transfer(juid, transferRequest );
		
			assertEquals("16133.66", userAccount.getUserAccount(juid).getAccount().getBalance());

	}

}
