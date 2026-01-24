package za.co.ashtech.jaatm.bea.dto;

import java.time.LocalDate;
import java.util.Objects;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * User
 */

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T20:28:19.081308300+02:00[Africa/Johannesburg]")
public class User {

  private String firstname;

  private String lastname;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dob;

  private String juid;

  private Account account;

  private Address address;

  public User() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public User(String firstname, String lastname, LocalDate dob, String juid, Account account) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.dob = dob;
    this.juid = juid;
    this.account = account;
  }

  public User firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  /**
   * Get firstname
   * @return firstname
  */
  @NotNull 
  @Schema(name = "firstname", example = "Joe", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("firstname")
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public User lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  /**
   * Get lastname
   * @return lastname
  */
  @NotNull 
  @Schema(name = "lastname", example = "James", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastname")
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public User dob(LocalDate dob) {
    this.dob = dob;
    return this;
  }

  /**
   * Get dob
   * @return dob
  */
  @NotNull @Valid 
  @Schema(name = "dob", example = "Sat Jan 01 02:00:00 SAST 2000", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dob")
  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public User juid(String juid) {
    this.juid = juid;
    return this;
  }

  /**
   * Get juid
   * @return juid
  */
  @NotNull 
  @Schema(name = "juid", example = "JUID123456", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("juid")
  public String getJuid() {
    return juid;
  }

  public void setJuid(String juid) {
    this.juid = juid;
  }

  public User account(Account account) {
    this.account = account;
    return this;
  }

  /**
   * Get account
   * @return account
  */
  @NotNull @Valid 
  @Schema(name = "account", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("account")
  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public User address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @Valid 
  @Schema(name = "address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.firstname, user.firstname) &&
        Objects.equals(this.lastname, user.lastname) &&
        Objects.equals(this.dob, user.dob) &&
        Objects.equals(this.juid, user.juid) &&
        Objects.equals(this.account, user.account) &&
        Objects.equals(this.address, user.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, dob, juid, account, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
    sb.append("    juid: ").append(toIndentedString(juid)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

