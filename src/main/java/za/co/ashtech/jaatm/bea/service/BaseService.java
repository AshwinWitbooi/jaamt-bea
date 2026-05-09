package za.co.ashtech.jaatm.bea.service;

import za.co.ashtech.jaatm.bea.model.JaatmUser;
import za.co.ashtech.jaatm.bea.repository.JaatmUserRepository;
import za.co.ashtech.jaatm.bea.util.UserNotFoundException;

public abstract class BaseService {
	
	private JaatmUserRepository jaatmUserRepository;

	protected BaseService(JaatmUserRepository jaatmUserRepository) {
		super();
		this.jaatmUserRepository = jaatmUserRepository;
	}
	
	/*
	 * Get JAATM_USER by JUID or throw a UserNotFoundException runtime exception 
	 */
	public JaatmUser getJaatmUser(String juid) {
		return getJaatmUserRepository().findByJuid(juid).orElseThrow(() -> new UserNotFoundException(juid));
	}

	protected JaatmUserRepository getJaatmUserRepository() {
		return jaatmUserRepository;
	}	

}
