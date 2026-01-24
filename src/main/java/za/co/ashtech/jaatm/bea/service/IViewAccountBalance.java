package za.co.ashtech.jaatm.bea.service;

import za.co.ashtech.jaatm.bea.dto.Account;

public interface IViewAccountBalance {
	
	Account getAccountBalance(String juid);

}
