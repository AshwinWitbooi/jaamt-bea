package za.co.ashtech.jaatm.bea.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.ashtech.jaatm.bea.dto.GetAccountBalanceResponse;
import za.co.ashtech.jaatm.bea.model.JaatmUser;
import za.co.ashtech.jaatm.bea.repository.JaatmUserRepository;

@Service
public class ViewAccountBalanceImpl implements IViewAccountBalance {
	
	@Autowired
	private JaatmUserRepository jaatmUserRepository;

	@Override
	public GetAccountBalanceResponse getAccountBalance(String juid) {
		
		GetAccountBalanceResponse getAccountResponse = null;
		
		/*
		 * Get JAATM_USER by JUID or throw a NullPointer exception 
		 */
		JaatmUser jaatmUser = jaatmUserRepository.findByJuid(juid).orElseThrow(() -> new NullPointerException("No user record found."));
		
		//Initialize response after user successfully returned
		getAccountResponse = new GetAccountBalanceResponse();
		getAccountResponse.setJuid(jaatmUser.getJuid());
		//convert cents to SARand
		BigDecimal amountInCents = new BigDecimal(jaatmUser.getAccount().getBalance());
		getAccountResponse.setAccountBalance(amountInCents.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP).toPlainString());
		
		//return account balance DTO
		return getAccountResponse;
	}

}
