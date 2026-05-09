package za.co.ashtech.jaatm.bea.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import za.co.ashtech.jaatm.bea.dto.TransferRequest;
import za.co.ashtech.jaatm.bea.model.JaatmUser;
import za.co.ashtech.jaatm.bea.repository.JaatmUserRepository;
import za.co.ashtech.jaatm.bea.util.JaatmConstants;
import za.co.ashtech.jaatm.bea.util.JaatmOperationException;

@Service
public class AccountTransferImpl extends BaseService implements AccountTransfer {
	
	private static final Logger transferImplLogger = LoggerFactory.getLogger(AccountTransferImpl.class);
	
	public AccountTransferImpl(JaatmUserRepository jaatmUserRepository) {
		super(jaatmUserRepository);
	}

	@Override
	public void transfer(String juid, TransferRequest transferRequest) {
		
		try {
			//Get user account
			JaatmUser jaatmUser = getJaatmUser(juid);
			
			//Subtract transfer amount from user account
			Long balance = jaatmUser.getAccount().getBalance();
			
			Long newBalance = balance - Long.valueOf(transferRequest.getAmount());
			
			jaatmUser.getAccount().setBalance(newBalance);
			transferImplLogger.info("::: -:SET NEW BALANCE.");
			
			//Log to simulate transfer
			transferImplLogger.info("::: -:STHIS SIMULATE A TRANSFER OF FUNDS OUT OF USER ACCOUNT.");
			
			//update user account
			getJaatmUserRepository().save(jaatmUser);
			
		} catch (Exception e) {
			throw new JaatmOperationException(JaatmConstants.ERROR_CODE_100);
		}

	}

}
