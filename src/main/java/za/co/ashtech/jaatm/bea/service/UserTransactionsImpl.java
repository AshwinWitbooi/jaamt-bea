package za.co.ashtech.jaatm.bea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import za.co.ashtech.jaatm.bea.dto.JaatmUserTransaction;
import za.co.ashtech.jaatm.bea.repository.JaatmTransactionRepository;

@Service
public class UserTransactionsImpl implements UserTransactions {
	
	private final JaatmTransactionRepository jaatmTransactionRepository;
	
	public UserTransactionsImpl(JaatmTransactionRepository jaatmTransactionRepository) {
		super();
		this.jaatmTransactionRepository = jaatmTransactionRepository;
	}



	@Override
	public Optional<List<JaatmUserTransaction>> getUserTransactions(String juid) {
				
		return  Optional.ofNullable(jaatmTransactionRepository.findAll()).map(recordList -> {
			//list to be returned
			List<JaatmUserTransaction> responseList = new ArrayList<>();
			recordList.forEach(tx -> {
				responseList.add(new JaatmUserTransaction(tx.getTransactionType(), tx.getAmount(), tx.getTransactionDate().toString(), tx.getStatus()));
			});
			return responseList;
		});

	}

}
