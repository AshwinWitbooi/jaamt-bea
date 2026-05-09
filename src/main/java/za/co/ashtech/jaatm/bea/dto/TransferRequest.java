package za.co.ashtech.jaatm.bea.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * AccountTransferJuidPostRequest
 */

@JsonTypeName("_account_transfer__juid__post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-05-02T11:58:01.017742400+02:00[Africa/Johannesburg]")
public class TransferRequest {

  private String amount;

  private String fromAccountNumber;

  private String toAccountNumber;

  private String transferReference;

  public TransferRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TransferRequest(String amount, String fromAccountNumber, String toAccountNumber, String transferReference) {
    this.amount = amount;
    this.fromAccountNumber = fromAccountNumber;
    this.toAccountNumber = toAccountNumber;
    this.transferReference = transferReference;
  }

  public TransferRequest amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Amount to be transfered
   * @return amount
  */
  @NotNull @Valid 
  @Schema(name = "amount", example = "129969", description = "Amount to be transfered", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public TransferRequest fromAccountNumber(String fromAccountNumber) {
    this.fromAccountNumber = fromAccountNumber;
    return this;
  }

  /**
   * Account from which transfer will be done
   * @return fromAccountNumber
  */
  @NotNull 
  @Schema(name = "fromAccountNumber", example = "10222226", description = "Account from which transfer will be done", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("fromAccountNumber")
  public String getFromAccountNumber() {
    return fromAccountNumber;
  }

  public void setFromAccountNumber(String fromAccountNumber) {
    this.fromAccountNumber = fromAccountNumber;
  }

  public TransferRequest toAccountNumber(String toAccountNumber) {
    this.toAccountNumber = toAccountNumber;
    return this;
  }

  /**
   * Account to which transfer will be done
   * @return toAccountNumber
  */
  @NotNull 
  @Schema(name = "toAccountNumber", example = "10222226", description = "Account to which transfer will be done", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("toAccountNumber")
  public String getToAccountNumber() {
    return toAccountNumber;
  }

  public void setToAccountNumber(String toAccountNumber) {
    this.toAccountNumber = toAccountNumber;
  }

  public TransferRequest transferReference(String transferReference) {
    this.transferReference = transferReference;
    return this;
  }

  /**
   * Reference number to be used for transfer
   * @return transferReference
  */
  @NotNull 
  @Schema(name = "transferReference", example = "11123", description = "Reference number to be used for transfer", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("transferReference")
  public String getTransferReference() {
    return transferReference;
  }

  public void setTransferReference(String transferReference) {
    this.transferReference = transferReference;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferRequest accountTransferJuidPostRequest = (TransferRequest) o;
    return Objects.equals(this.amount, accountTransferJuidPostRequest.amount) &&
        Objects.equals(this.fromAccountNumber, accountTransferJuidPostRequest.fromAccountNumber) &&
        Objects.equals(this.toAccountNumber, accountTransferJuidPostRequest.toAccountNumber) &&
        Objects.equals(this.transferReference, accountTransferJuidPostRequest.transferReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, fromAccountNumber, toAccountNumber, transferReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransferJuidPostRequest {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    fromAccountNumber: ").append(toIndentedString(fromAccountNumber)).append("\n");
    sb.append("    toAccountNumber: ").append(toIndentedString(toAccountNumber)).append("\n");
    sb.append("    transferReference: ").append(toIndentedString(transferReference)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

