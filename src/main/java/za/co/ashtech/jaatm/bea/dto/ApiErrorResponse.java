package za.co.ashtech.jaatm.bea.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "timestamp", "status", "message", "errorCode" })
@Generated("jsonschema2pojo")
public class ApiErrorResponse {

	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("status")
	private HttpStatus status;
	@JsonProperty("message")
	private String message;
	@JsonProperty("errorCode")
	private String errorCode;	
	

	public ApiErrorResponse(HttpStatus status, String message, String errorCode) {
		super();
		this.timestamp = LocalDateTime.now().toString();
		this.status = status;
		this.message = message;
		this.errorCode = errorCode;
	}

	@JsonProperty("timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("status")
	public HttpStatus getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("errorCode")
	public String getErrorCode() {
		return errorCode;
	}

	@JsonProperty("errorCode")
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
