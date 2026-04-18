package za.co.ashtech.jaatm.bea.service;

import za.co.ashtech.jaatm.bea.dto.Account;

public interface ViewAccountBalance {
	
	Account getAccountBalance(String juid);

}
