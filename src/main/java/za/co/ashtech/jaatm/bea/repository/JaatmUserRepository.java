package za.co.ashtech.jaatm.bea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.ashtech.jaatm.bea.model.JaatmUser;

@Repository
public interface JaatmUserRepository extends CrudRepository<JaatmUser, Long> {

}
