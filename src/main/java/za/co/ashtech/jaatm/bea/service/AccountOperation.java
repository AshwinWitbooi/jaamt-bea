package za.co.ashtech.jaatm.bea.service;

import za.co.ashtech.jaatm.bea.dto.AccountOpRequest;

public interface AccountOperation {
	
	public void performAccountOperation(String juid, AccountOpRequest accountOpRequest);

}
