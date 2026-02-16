package za.co.ashtech.jaatm.bea.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

import za.co.ashtech.jaatm.bea.dto.Account;
import za.co.ashtech.jaatm.bea.dto.Address;
import za.co.ashtech.jaatm.bea.dto.User;
import za.co.ashtech.jaatm.bea.model.JaatmAddress;
import za.co.ashtech.jaatm.bea.model.JaatmUser;
import za.co.ashtech.jaatm.bea.repository.JaatmUserRepository;
import za.co.ashtech.jaatm.bea.util.JaatmOperationException;
import za.co.ashtech.jaatm.bea.util.JaatmConstants;
import za.co.ashtech.jaatm.bea.util.UserNotFoundException;

@Service
public class ViewUserAccountDetailsImpl implements IViewUserAccountDetails {
	
	private JaatmUserRepository jaatmUserRepository;
	
	public ViewUserAccountDetailsImpl(JaatmUserRepository jaatmUserRepository) {
		super();
		this.jaatmUserRepository = jaatmUserRepository;
	}



	@Override
	public User getUserAccount(String juid){
		
		User apiUserResponse = null;
		
		try {
			/*
			 * Get JAATM_USER by JUID or throw a UserNotFoundException runtime exception 
			 */
			JaatmUser jaatmUser = jaatmUserRepository.findByJuid(juid).orElseThrow(() -> new UserNotFoundException(juid));
			
			BigDecimal amountInCents = new BigDecimal(jaatmUser.getAccount().getBalance());
			
			//Initialize response after user successfully returned
			apiUserResponse = new User();
			apiUserResponse.setAccount(new Account());
			//convert cents to SARand
			apiUserResponse.setAccount(new Account(jaatmUser.getAccount().getStatus(), amountInCents.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP).toPlainString()));
			// get address
			JaatmAddress userAddress = jaatmUser.getAddress();
			apiUserResponse.setAddress(new Address(userAddress.getStreetNumber(), userAddress.getStreetName(),userAddress.getTown(),userAddress.getProvince(),userAddress.getPostalCode()));
			//Optional
			apiUserResponse.getAddress().setCity(userAddress.getCity());
			apiUserResponse.setDob(jaatmUser.getDob());
			apiUserResponse.setFirstname(jaatmUser.getFirstName());
			apiUserResponse.setLastname(jaatmUser.getLastName());
			apiUserResponse.setJuid(jaatmUser.getJuid());

		} catch (UserNotFoundException e) {
			throw e;
		}catch (Exception e) {
			throw new JaatmOperationException(JaatmConstants.ERROR_CODE_100);
		}
		
		//return account balance DTO
		return apiUserResponse;
	}

}
