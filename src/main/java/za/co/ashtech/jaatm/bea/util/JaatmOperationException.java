package za.co.ashtech.jaatm.bea.util;

import org.springframework.http.HttpStatus;

/*
 * This exception will be thrown for specific operations
 * HttpStatus will be internal server error, will all be as set 
 * and error code will be specific for operation in execution
 */
public class JaatmOperationException extends JaatmApiException{
	
	private static final long serialVersionUID = 1L;

	public JaatmOperationException(String errorCode) {
        super("Error processing request. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR, errorCode);
    }

}
