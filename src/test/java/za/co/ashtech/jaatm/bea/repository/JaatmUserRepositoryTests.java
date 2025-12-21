package za.co.ashtech.jaatm.bea.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import za.co.ashtech.jaatm.bea.model.JaatmAccount;
import za.co.ashtech.jaatm.bea.model.JaatmUser;

/*
 * This is the test class for JPA layer test.
 */

@DataJpaTest
class JaatmUserRepositoryTests {
	
	@Autowired
	JaatmUserRepository userRepository;
	

	@Test
	void executeTest() {
		//assert repository is not null
		assertNotNull(userRepository);
		
		//Create and set user and account model object
		JaatmUser juuser = new JaatmUser("JUID", "FIRSTNAME", "LASTNAME");
		juuser.setAccount(new JaatmAccount(Long.getLong("12236666969"), "ACTIVE"));
		
		//save entity
		userRepository.save(juuser);
		
		Optional<JaatmUser> userResult = userRepository.findById(Long.valueOf(1L));
		
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
		
		assertThrows(DataIntegrityViolationException.class, () -> {
			//save entity
			userRepository.save(new JaatmUser("JUID", null, "LASTNAME"));
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
