package za.co.ashtech.jaatm.bea.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import za.co.ashtech.jaatm.bea.model.JaatmAccount;
import za.co.ashtech.jaatm.bea.model.JaatmAddress;
import za.co.ashtech.jaatm.bea.model.JaatmUser;

/*
 * This is the test class for JPA layer test.
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JaatmUserRepositoryTests {
	
	@Autowired
	JaatmUserRepository userRepository;
	

	@Test
	void executeTest() {
		//assert repository is not null
		assertNotNull(userRepository);
		
		String juid = RandomStringUtils.secure().nextAlphanumeric(10);
				
		JaatmAccount userAccount = new JaatmAccount(Long.getLong("12236666969"), "ACTIVE");
		//Create and set user and account model object
		JaatmUser juuser = new JaatmUser(juid, "FIRSTNAME", "LASTNAME",LocalDate.of(1973, 3, 22));
		JaatmAddress userAddress = new JaatmAddress("1", "Test Street", "T Town", "T City", "WC", "7966");
		userAccount.setUser(juuser);
		juuser.setAccount(userAccount);
		userAddress.setUser(juuser);
		juuser.setAddress(userAddress);
		
		//save entity
		userRepository.save(juuser);
		
		Optional<JaatmUser> userResult = userRepository.findByJuid(juid);
		
		//assert user not null
		assertNotNull(userResult.get());
		//assert user balance not null
		assertNotNull(userResult.get().getAccount());
		
		userResult.orElseThrow(() -> new NullPointerException("No record found."));
	}
	
	@Test
	void executeNullFirstnameTest() {
		//assert repository is not null
		assertNotNull(userRepository);
		
		JaatmUser usertoSave = new JaatmUser("JUID", null, "LASTNAME",LocalDate.of(1973, 3, 22));
		
		assertThrows(DataIntegrityViolationException.class, () -> {
			//save entity
			userRepository.save(usertoSave);
		});
	}
	
	@Test
	void executeNullUserTest() {
		//assert repository is not null
		assertNotNull(userRepository);
		
		assertThrows(InvalidDataAccessApiUsageException.class, () -> {
			//save entity
			userRepository.save(null);
		});
	}
}
