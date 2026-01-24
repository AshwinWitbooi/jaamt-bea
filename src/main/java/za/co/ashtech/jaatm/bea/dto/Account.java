package za.co.ashtech.jaatm.bea.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

/**
 * Account
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T20:28:19.081308300+02:00[Africa/Johannesburg]")
public class Account {

  private String status;

  private String balance;

  public Account() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Account(String status, String balance) {
    this.status = status;
    this.balance = balance;
  }

  public Account status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull 
  @Schema(name = "status", example = "Active", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

//  public void setStatus(String status) {
//    this.status = status;
//  }

  public Account balance(String balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Get balance
   * @return balance
  */
  @NotNull 
  @Schema(name = "balance", example = "10000", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("balance")
  public String getBalance() {
    return balance;
  }

//  public void setBalance(Double balance) {
//    this.balance = balance;
//  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.status, account.status) &&
        Objects.equals(this.balance, account.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, balance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

