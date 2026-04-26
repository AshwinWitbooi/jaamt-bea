package za.co.ashtech.jaatm.bea.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import za.co.ashtech.jaatm.bea.dto.ApiErrorResponse;
import za.co.ashtech.jaatm.bea.util.OverDrawnBalanceException;
import za.co.ashtech.jaatm.bea.util.UserNotFoundException;

@RestControllerAdvice
public class GlobalApiErrorControllerAdvice {
	
    @ExceptionHandler(OverDrawnBalanceException.class)
    public ResponseEntity<ApiErrorResponse> handleOverDrawnBalanceException(
    		OverDrawnBalanceException ex) {
    	
        ApiErrorResponse response = new ApiErrorResponse(
                ex.getStatus(),
                ex.getMessage()
        );

        return ResponseEntity.status(ex.getStatus()).body(response);     
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(
    		UserNotFoundException ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                ex.getStatus(),
                ex.getMessage()
        );

        return ResponseEntity.status(ex.getStatus()).body(response);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleUnhandledException(
            Exception ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Unexpected error occurred. Please contact support team."
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex) {
    	
        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Invalid request. Please review and resent."
        );

    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);        
    }
}

