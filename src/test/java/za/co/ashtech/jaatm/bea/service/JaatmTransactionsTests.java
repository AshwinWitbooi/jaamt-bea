package za.co.ashtech.jaatm.bea.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;
import za.co.ashtech.jaatm.bea.dto.JaatmUserTransaction;
import za.co.ashtech.jaatm.bea.model.JaatmTransaction;
import za.co.ashtech.jaatm.bea.repository.JaatmTransactionRepository;

@ExtendWith(MockitoExtension.class)
@Slf4j
class JaatmTransactionsTests {

	@Mock
	JaatmTransactionRepository transactionRepository;
	
	@InjectMocks
	UserTransactionsImpl userTransactionsImpl;
	
	@Test
	void testUpdateAccount() {
		
		String juid = "JAATM-U001";
		
		JaatmTransaction one =  new JaatmTransaction();
			one.setJuid(juid);
			one.setTransactionType("DEPOSIT");
			one.setAmount("1000.00");
			one.setTransactionDate(LocalDateTime.now());
			one.setStatus("SUCCESS");
		
		JaatmTransaction two =  new JaatmTransaction();
			two.setJuid(juid);
			two.setTransactionType("WITHDRAWAL");
			two.setAmount("260.00");
			two.setTransactionDate(LocalDateTime.now());
			two.setStatus("FAILED");

		JaatmTransaction three =  new JaatmTransaction();
			three.setJuid(juid);
			three.setTransactionType("DEPOSIT");
			three.setAmount("7000.00");
			three.setTransactionDate(LocalDateTime.now());
			three.setStatus("SUCCESS");

		JaatmTransaction four =  new JaatmTransaction();
			four.setJuid(juid);
			four.setTransactionType("WITHDRAWAL");
			four.setAmount("120.00");
			four.setTransactionDate(LocalDateTime.now());
			four.setStatus("SUCCESS");
			
		//Create mocked database model
		Iterable<JaatmTransaction> transactions = List.of(four,two,three,four);
		
		when(transactionRepository.findAll()).thenReturn(transactions);
		
		Optional<List<JaatmUserTransaction>> userTxsOpt = userTransactionsImpl.getUserTransactions(juid);
		
		assertNotNull(userTxsOpt); // Optional itself (rarely needed)

		assertTrue(userTxsOpt.isPresent());

	}

}
