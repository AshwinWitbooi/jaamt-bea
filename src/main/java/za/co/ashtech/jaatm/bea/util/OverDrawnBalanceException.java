package za.co.ashtech.jaatm.bea.util;

import org.springframework.http.HttpStatus;

/*The exception will be thrown if a user cannot be found*/
public class OverDrawnBalanceException extends JaatmApiException {

	private static final long serialVersionUID = 1L;

	public OverDrawnBalanceException(String juid) {
		super("Amount withdrawn exceed available balance for user: " + juid, HttpStatus.METHOD_NOT_ALLOWED, JaatmConstants.ERROR_CODE_1);
	}
}
