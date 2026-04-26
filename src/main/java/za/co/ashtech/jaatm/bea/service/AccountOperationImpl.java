package za.co.ashtech.jaatm.bea.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import za.co.ashtech.jaatm.bea.dto.AccountOpRequest;
import za.co.ashtech.jaatm.bea.model.JaatmUser;
import za.co.ashtech.jaatm.bea.repository.JaatmUserRepository;
import za.co.ashtech.jaatm.bea.util.OverDrawnBalanceException;
import za.co.ashtech.jaatm.bea.util.UserNotFoundException;

@Slf4j
@Service
public class AccountOperationImpl implements AccountOperation {
	
	private JaatmUserRepository jaatmUserRepository;
	
	public AccountOperationImpl(JaatmUserRepository jaatmUserRepository) {
		super();
		this.jaatmUserRepository = jaatmUserRepository;
	}

	@Override
	public void performAccountOperation(String juid, AccountOpRequest accountOpRequest) {
		
		/*
		 * Get JAATM_USER by JUID or throw a UserNotFoundException runtime exception 
		 */
		JaatmUser jaatmUser = jaatmUserRepository.findByJuid(juid).orElseThrow(() -> new UserNotFoundException(juid));
		
		//Check if operation is deposit
		if(accountOpRequest.getOperation().equals(AccountOpRequest.OperationEnum.DEPOSIT)) {
			
			Long currentBalance = jaatmUser.getAccount().getBalance();
			log.debug("::: :CURRENT BALANCE {}",currentBalance);
			
			//Create new balance
			long newBalance = currentBalance + accountOpRequest.getAmount().longValue();
			log.debug("::: :NEW BALANCE {}",newBalance);
			
			jaatmUser.getAccount().setBalance(newBalance);
			log.debug("::: :SET NEW BALANCE");			
			
		}else {
			
			//Check if balance is sufficient to allow withdrawal
			if(jaatmUser.getAccount().getBalance() >= accountOpRequest.getAmount().longValue()) {
				
				jaatmUser.getAccount().setBalance(jaatmUser.getAccount().getBalance() - accountOpRequest.getAmount().longValue());
			}else {
				throw new OverDrawnBalanceException(juid);
			}
			
		}
		
		//update user record with new balance
		jaatmUserRepository.save(jaatmUser);

	}

}
