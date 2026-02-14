package za.co.ashtech.jaatm.bea.util;

import org.springframework.http.HttpStatus;

/*The exception will be thrown if a user cannot be found*/
public class UserNotFoundException extends JaatmApiException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String juid) {
		super("User not found: " + juid, HttpStatus.NOT_FOUND, JaatmConstants.ERROR_CODE_1);
	}
}
