package za.co.ashtech.jaatm.bea.service;

import za.co.ashtech.jaatm.bea.dto.TransferRequest;

public interface AccountTransfer {
	
	public void transfer(String juid, TransferRequest transferRequest);

}
