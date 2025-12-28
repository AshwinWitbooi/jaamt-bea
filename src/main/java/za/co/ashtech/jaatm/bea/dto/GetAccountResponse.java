package za.co.ashtech.jaatm.bea.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

/**
 * GetAccountResponse
 */

@JsonTypeName("_get_account_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-26T15:33:20.126202100+02:00[Africa/Johannesburg]")
public class GetAccountResponse {

	  private Result result;

  private String juid;

  private String accountBalance;


  public GetAccountResponse juid(String juid) {
    this.juid = juid;
    return this;
  }

  /**
   * Get juid
   * @return juid
  */
  
  @Schema(name = "juid", example = "XXX", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("juid")
  public String getJuid() {
    return juid;
  }

  public void setJuid(String juid) {
    this.juid = juid;
  }

  public GetAccountResponse accountBalance(String accountBalance) {
    this.accountBalance = accountBalance;
    return this;
  }

  /**
   * Get accountBalance
   * @return accountBalance
  */
  
  @Schema(name = "accountBalance", example = "100", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountBalance")
  public String getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(String accountBalance) {
    this.accountBalance = accountBalance;
  }

  public GetAccountResponse result(Result result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
  */
  @Valid 
  @Schema(name = "result", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("result")
  public Result getResult() {
    return result;
  }

  public void setResult(Result result) {
    this.result = result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAccountResponse getAccountResponse = (GetAccountResponse) o;
    return Objects.equals(this.juid, getAccountResponse.juid) &&
        Objects.equals(this.accountBalance, getAccountResponse.accountBalance) &&
        Objects.equals(this.result, getAccountResponse.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(juid, accountBalance, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountJuidGet200Response {\n");
    sb.append("    juid: ").append(toIndentedString(juid)).append("\n");
    sb.append("    accountBalance: ").append(toIndentedString(accountBalance)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

