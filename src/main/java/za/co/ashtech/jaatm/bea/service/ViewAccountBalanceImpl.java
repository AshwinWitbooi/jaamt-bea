package za.co.ashtech.jaatm.bea.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import za.co.ashtech.jaatm.bea.dto.Account;
import za.co.ashtech.jaatm.bea.model.JaatmUser;
import za.co.ashtech.jaatm.bea.repository.JaatmUserRepository;
import za.co.ashtech.jaatm.bea.util.JaatmOperationException;
import za.co.ashtech.jaatm.bea.util.JaatmConstants;
import za.co.ashtech.jaatm.bea.util.UserNotFoundException;

@Service
public class ViewAccountBalanceImpl implements IViewAccountBalance {
	
	private JaatmUserRepository jaatmUserRepository;
	
	
	public ViewAccountBalanceImpl(JaatmUserRepository jaatmUserRepository) {
		super();
		this.jaatmUserRepository = jaatmUserRepository;
	}



	@Override
	public Account getAccountBalance(String juid){
		
		Account account = null;
		
		try {
			/*
			 * Get JAATM_USER by JUID or throw a UserNotFoundException runtime exception 
			 */
			JaatmUser jaatmUser = jaatmUserRepository.findByJuid(juid).orElseThrow(() -> new UserNotFoundException(juid));
			
			
			// Create BigDecimal to handle converting cents and SA Rands
			BigDecimal amountInCents = new BigDecimal(jaatmUser.getAccount().getBalance());
			
			//Initialize response after user successfully returned
			account = new Account(jaatmUser.getAccount().getStatus(),amountInCents.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP).toPlainString());

		} catch (UserNotFoundException e) {
			throw e;
		}catch (Exception e) {
			throw new JaatmOperationException(JaatmConstants.ERROR_CODE_100);
		}
		
		//return account balance DTO
		return account;
	}

}
