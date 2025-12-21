package za.co.ashtech.jaatm.bea.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
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
		
		//save entity
		userRepository.save(new JaatmUser("JUID", "FIRSTNAME", "LASTNAME"));
		
		Optional<JaatmUser> userResult = userRepository.findById(Long.valueOf(1L));
		
		assertNotNull(userResult.get());
		
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
