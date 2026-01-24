package za.co.ashtech.jaatm.bea.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

/**
 * Address
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-15T20:39:07.264808700+02:00[Africa/Johannesburg]")
public class Address {

  private String streetNumber;

  private String streetName;

  private String town;

  private String city;

  private String province;

  private String postalCode;

  public Address() {
    super();
  }
  
  

  /**
   * Constructor with only required parameters
   */
  public Address(String streetNumber, String streetName, String town, String province, String postalCode) {
	super();
	this.streetNumber = streetNumber;
	this.streetName = streetName;
	this.town = town;
	this.province = province;
	this.postalCode = postalCode;
}

  public Address streetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
    return this;
  }

  /**
   * Get streetNumber
   * @return streetNumber
  */
  @NotNull 
  @Schema(name = "streetNumber", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("streetNumber")
  public String getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  public Address streetName(String streetName) {
    this.streetName = streetName;
    return this;
  }

  /**
   * Get streetName
   * @return streetName
  */
  @NotNull 
  @Schema(name = "streetName", example = "K-street", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("streetName")
  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public Address town(String town) {
    this.town = town;
    return this;
  }

  /**
   * Get town
   * @return town
  */
  
  @Schema(name = "town", example = "Kuilsriver", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("town")
  public String getTown() {
    return town;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public Address city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  */
  
  @Schema(name = "city", example = "Cape Town", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Address province(String province) {
    this.province = province;
    return this;
  }

  /**
   * Get province
   * @return province
  */
  
  @Schema(name = "province", example = "Western Cape", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("province")
  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public Address postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
  */
  
  @Schema(name = "postalCode", example = "7896", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("postalCode")
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.streetNumber, address.streetNumber) &&
        Objects.equals(this.streetName, address.streetName) &&
        Objects.equals(this.town, address.town) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.province, address.province) &&
        Objects.equals(this.postalCode, address.postalCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streetNumber, streetName, town, city, province, postalCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    sb.append("    streetNumber: ").append(toIndentedString(streetNumber)).append("\n");
    sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
    sb.append("    town: ").append(toIndentedString(town)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    province: ").append(toIndentedString(province)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
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

