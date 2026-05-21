package za.co.ashtech.jaatm.bea.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import za.co.ashtech.jaatm.bea.model.JaatmTransaction;

public interface JaatmTransactionRepository extends CrudRepository<JaatmTransaction, Long> {
	/**
     * Finds all transactions for a specific JUID.
     * Returns an Optional containing the list of records, 
     * or an empty Optional if none exist.
     */
    Optional<List<JaatmTransaction>> findByJuid(String juid);
}
