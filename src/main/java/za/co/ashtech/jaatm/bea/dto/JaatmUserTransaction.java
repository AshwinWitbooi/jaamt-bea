package za.co.ashtech.jaatm.bea.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "transactionType", "amount", "transactionDate", "status" })
public class JaatmUserTransaction {

	@JsonProperty("transactionType")
	private String transactionType;
	@JsonProperty("amount")
	private String amount;
	@JsonProperty("transactionDate")
	private String transactionDate;
	@JsonProperty("status")
	private String status;
	
	public JaatmUserTransaction(String transactionType, String amount, String transactionDate, String status) {
		super();
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.status = status;
	}

	@JsonProperty("transactionType")
	public String getTransactionType() {
		return transactionType;
	}

	@JsonProperty("transactionType")
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@JsonProperty("amount")
	public String getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@JsonProperty("transactionDate")
	public String getTransactionDate() {
		return transactionDate;
	}

	@JsonProperty("transactionDate")
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

}