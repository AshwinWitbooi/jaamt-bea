package za.co.ashtech.jaatm.bea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.ashtech.jaatm.bea.model.JaatmUser;
import za.co.ashtech.jaatm.bea.repository.JaatmUserRepository;

@Service
public class ViewAccountBalanceImpl implements IViewAccountBalance {
	
	@Autowired
	private JaatmUserRepository jaatmUserRepository;

	@Override
	public String getAccountBalance(String juid) {
		
		/*
		 * Get JAATM_USER by JUID or throw a NullPointer exception 
		 */
		JaatmUser jaatmUser = jaatmUserRepository.findByJuid(juid).orElseThrow(() -> new NullPointerException("No user record found."));
		
		//return balance as String
		return Long.toString(jaatmUser.getAccount().getBalance());
	}

}
