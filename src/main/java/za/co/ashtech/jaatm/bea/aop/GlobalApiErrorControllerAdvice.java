package za.co.ashtech.jaatm.bea.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import za.co.ashtech.jaatm.bea.dto.ApiErrorResponse;
import za.co.ashtech.jaatm.bea.util.UserNotFoundException;

@RestControllerAdvice
public class GlobalApiErrorControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(
    		UserNotFoundException ex,
            HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                ex.getStatus(),
                ex.getMessage(),
                ex.getErrorCode()
        );

        return ResponseEntity.status(ex.getStatus()).body(response);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiErrorResponse> handleValidationException(
//            MethodArgumentNotValidException ex,
//            HttpServletRequest request) {
//
//        String message = ex.getBindingResult()
//                .getFieldErrors()
//                .get(0)
//                .getDefaultMessage();
//
//        ApiErrorResponse response = new ApiErrorResponse(
//                HttpStatus.BAD_REQUEST,
//                message,
//                "VALIDATION_ERROR",
//                request.getRequestURI()
//        );
//
//        return ResponseEntity.badRequest().body(response);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiErrorResponse> handleUnhandledException(
//            Exception ex,
//            HttpServletRequest request) {
//
//        ApiErrorResponse response = new ApiErrorResponse(
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                "Unexpected error occurred",
//                "INTERNAL_ERROR",
//                request.getRequestURI()
//        );
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//    }
}

