package za.co.ashtech.jaatm.bea.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * AccountOpRequest
 */

@JsonTypeName("AccountOpRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-18T15:10:17.290212900+02:00[Africa/Johannesburg]")
public class AccountOpRequest {

  /**
   * Gets or Sets operation
   */
  public enum OperationEnum {
    DEPOSIT("deposit"),
    
    WITHDRAWAL("withdrawal");

    private String value;

    OperationEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OperationEnum fromValue(String value) {
      for (OperationEnum b : OperationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private OperationEnum operation;

  private Long amount;

  public AccountOpRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AccountOpRequest(OperationEnum operation, Long amount) {
    this.operation = operation;
    this.amount = amount;
  }

  public AccountOpRequest operation(OperationEnum operation) {
    this.operation = operation;
    return this;
  }

  /**
   * Get operation
   * @return operation
  */
  @NotNull 
  @Schema(name = "operation", example = "withdrawal", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("operation")
  public OperationEnum getOperation() {
    return operation;
  }

  public void setOperation(OperationEnum operation) {
    this.operation = operation;
  }

  public AccountOpRequest amount(Long amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @NotNull @Valid 
  @Schema(name = "amount", example = "129969", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountOpRequest accountJuidPostRequest = (AccountOpRequest) o;
    return Objects.equals(this.operation, accountJuidPostRequest.operation) &&
        Objects.equals(this.amount, accountJuidPostRequest.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operation, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountJuidPostRequest {\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

