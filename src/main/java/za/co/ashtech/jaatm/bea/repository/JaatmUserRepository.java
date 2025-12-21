package za.co.ashtech.jaatm.bea.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.ashtech.jaatm.bea.model.JaatmUser;

@Repository
public interface JaatmUserRepository extends CrudRepository<JaatmUser, Long> {
	Optional<JaatmUser> findByJuid(String juid);
}
