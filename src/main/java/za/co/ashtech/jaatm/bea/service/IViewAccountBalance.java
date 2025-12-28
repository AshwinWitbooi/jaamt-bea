package za.co.ashtech.jaatm.bea.service;

import za.co.ashtech.jaatm.bea.dto.GetAccountResponse;

public interface IViewAccountBalance {
	
	GetAccountResponse getAccountBalance(String juid);

}
