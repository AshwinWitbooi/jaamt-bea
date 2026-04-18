package za.co.ashtech.jaatm.bea.service;

import za.co.ashtech.jaatm.bea.dto.User;

public interface UpdateUserDetails {
	
	void updateAccount(String juid, User user);

}
