package za.co.ashtech.jaatm.bea.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import za.co.ashtech.jaatm.bea.model.JaatmTransaction;

/*
 * This is the test class for JPA layer test.
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JaatmTransactionRepositoryTests {
	
	@Autowired
	JaatmTransactionRepository jaatmTransacrionRepository;
	
	@Test
	void findByJuidTest() {
		//assert repository is not null
		assertNotNull(jaatmTransacrionRepository);
						
		String juid = "JUID0001";
		Optional<List<JaatmTransaction>> transactionsOpt = jaatmTransacrionRepository.findByJuid(juid);
		
		assertNotNull(transactionsOpt.get());
	}
	
	@Test
	void executeSaveTest() {
		//assert repository is not null
		assertNotNull(jaatmTransacrionRepository);
		
		String juid = RandomStringUtils.secure().nextAlphanumeric(10);
		
		JaatmTransaction jt = new JaatmTransaction();
		jt.setAmount("100000");
		jt.setJuid(juid);
		jt.setStatus("SUCCESS");
		jt.setTransactionDate(LocalDateTime.now());
		jt.setTransactionType("View Balance");
		
		jaatmTransacrionRepository.save(jt);
		
	}
	
//	@Test
//	void executeNullUserTest() {
//		//assert repository is not null
//		assertNotNull(jaatmTransacrionRepository);
//		
//		assertThrows(InvalidDataAccessApiUsageException.class, () -> {
//			//save entity
//			jaatmTransacrionRepository.save(null);
//		});
//	}

}
