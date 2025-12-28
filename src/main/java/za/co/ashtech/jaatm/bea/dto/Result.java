package za.co.ashtech.jaatm.bea.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

/**
 * This is the standard API result that indicate response result
 */

@Schema(name = "Result_result", description = "This is the standard API result that indicate response result")
@JsonTypeName("Result_result")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-26T15:33:20.126202100+02:00[Africa/Johannesburg]")
public class Result {

  private String resultCode;

  private String resultMg;

  public Result resultCode(String resultCode) {
    this.resultCode = resultCode;
    return this;
  }

  /**
   * Get resultCode
   * @return resultCode
  */
  
  @Schema(name = "resultCode", example = "0", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resultCode")
  public String getResultCode() {
    return resultCode;
  }

  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  public Result resultMg(String resultMg) {
    this.resultMg = resultMg;
    return this;
  }

  /**
   * Get resultMg
   * @return resultMg
  */
  
  @Schema(name = "resultMg", example = "Message of operation output.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resultMg")
  public String getResultMg() {
    return resultMg;
  }

  public void setResultMg(String resultMg) {
    this.resultMg = resultMg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Result resultResult = (Result) o;
    return Objects.equals(this.resultCode, resultResult.resultCode) &&
        Objects.equals(this.resultMg, resultResult.resultMg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resultCode, resultMg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultResult {\n");
    sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
    sb.append("    resultMg: ").append(toIndentedString(resultMg)).append("\n");
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

