package za.co.ashtech.jaatm.bea.util;

import org.springframework.http.HttpStatus;


/*
 * This is the Base API Exception class
 * Constructor args: Error message, HttpStatus and errorCode
 */
public class JaatmApiException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final HttpStatus status;
    private final String errorCode;

    protected JaatmApiException(String message, HttpStatus status, String errorCode) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }
    
    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
