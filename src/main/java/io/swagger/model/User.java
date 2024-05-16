package io.swagger.model;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-05-15T11:30:40.071880526Z[GMT]")

public class User {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @Email
  @JsonProperty("emailId")
  private String emailId = null;

  @JsonProperty("age")
  private Long age = null;

  @JsonProperty("phone")
  private String phone = null;

  /**
   * Manager or Reportee role
   */
  public enum RoleEnum {
    MGR("MGR"),

    REPORTEE("REPORTEE"),

    ADMIN("ADMIN");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RoleEnum fromValue(String text) {
      for (RoleEnum b : RoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("role")
  private RoleEnum role = null;

  @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()-_+=])[a-zA-Z0-9!@#$%^&*()-_+=]{8,16}$")
  @JsonProperty("password")
  private String password = null;

  @JsonProperty("managerName")
  private String managerName = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("tag")
  private String tag = null;

  public User id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * 
   * @return id
   **/
  @Schema(description = "")

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * 
   * @return firstName
   **/
  @Schema(description = "")

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * 
   * @return lastName
   **/
  @Schema(description = "")

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User emailId(String emailId) {
    this.emailId = emailId;
    return this;
  }

  /**
   * Get emailId
   * 
   * @return emailId
   **/
  @Schema(description = "")

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public User age(Long age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * 
   * @return age
   **/
  @Schema(description = "")

  public Long getAge() {
    return age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

  public User phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * 
   * @return phone
   **/
  @Schema(required = true, description = "")
  @NotNull

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public User role(RoleEnum role) {
    this.role = role;
    return this;
  }

  /**
   * Manager or Reportee role
   * 
   * @return role
   **/
  @Schema(description = "Manager or Reportee role")

  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * 
   * @return password
   **/
  @Schema(description = "")

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User managerName(String managerName) {
    this.managerName = managerName;
    return this;
  }

  /**
   * Name of the Manager to whom current User reports to
   * 
   * @return managerName
   **/
  @Schema(description = "Name of the Manager to whom current User reports to")

  public String getManagerName() {
    return managerName;
  }

  public void setManagerName(String managerName) {
    this.managerName = managerName;
  }

  public User address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * 
   * @return address
   **/
  @Schema(description = "")

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public User tag(String tag) {
    this.tag = tag;
    return this;
  }

  /**
   * Get tag
   * 
   * @return tag
   **/
  @Schema(description = "")

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.emailId, user.emailId) &&
        Objects.equals(this.age, user.age) &&
        Objects.equals(this.phone, user.phone) &&
        Objects.equals(this.role, user.role) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.managerName, user.managerName) &&
        Objects.equals(this.address, user.address) &&
        Objects.equals(this.tag, user.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, emailId, age, phone, role, password, managerName, address, tag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    managerName: ").append(toIndentedString(managerName)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
