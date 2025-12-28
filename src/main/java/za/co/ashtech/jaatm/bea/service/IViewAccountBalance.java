package za.co.ashtech.jaatm.bea.service;

import za.co.ashtech.jaatm.bea.dto.GetAccountBalanceResponse;

public interface IViewAccountBalance {
	
	GetAccountBalanceResponse getAccountBalance(String juid);

}
