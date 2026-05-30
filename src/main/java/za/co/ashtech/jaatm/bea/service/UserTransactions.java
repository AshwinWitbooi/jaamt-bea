package za.co.ashtech.jaatm.bea.service;

import java.util.List;
import java.util.Optional;

import za.co.ashtech.jaatm.bea.dto.JaatmUserTransaction;

public interface UserTransactions {
	
	public Optional<List<JaatmUserTransaction>> getUserTransactions(String juid);

}
