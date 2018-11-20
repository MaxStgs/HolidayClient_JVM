/*
 * HolidayAPI
 * My API work College Work
 *
 * OpenAPI spec version: 0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.File;
import java.io.IOException;

/**
 * Worker details
 */
@Schema(description = "Worker details")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-20T18:36:01.976Z[GMT]")public class WorkerDetails {

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("photo")
  private File photo = null;

  @SerializedName("phone")
  private String phone = null;

  @SerializedName("passportData")
  private String passportData = null;

  @SerializedName("role")
  private String role = null;

  @SerializedName("color")
  private String color = null;

  @SerializedName("login")
  private String login = null;

  @SerializedName("password")
  private String password = null;

  @SerializedName("rating")
  private Float rating = null;
  public WorkerDetails id(Integer id) {
    this.id = id;
    return this;
  }

  

  /**
  * Get id
  * @return id
  **/
  @Schema(description = "")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public WorkerDetails name(String name) {
    this.name = name;
    return this;
  }

  

  /**
  * Get name
  * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public WorkerDetails photo(File photo) {
    this.photo = photo;
    return this;
  }

  

  /**
  * Get photo
  * @return photo
  **/
  @Schema(description = "")
  public File getPhoto() {
    return photo;
  }
  public void setPhoto(File photo) {
    this.photo = photo;
  }
  public WorkerDetails phone(String phone) {
    this.phone = phone;
    return this;
  }

  

  /**
  * Get phone
  * @return phone
  **/
  @Schema(description = "")
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public WorkerDetails passportData(String passportData) {
    this.passportData = passportData;
    return this;
  }

  

  /**
  * Get passportData
  * @return passportData
  **/
  @Schema(description = "")
  public String getPassportData() {
    return passportData;
  }
  public void setPassportData(String passportData) {
    this.passportData = passportData;
  }
  public WorkerDetails role(String role) {
    this.role = role;
    return this;
  }

  

  /**
  * Get role
  * @return role
  **/
  @Schema(description = "")
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
  public WorkerDetails color(String color) {
    this.color = color;
    return this;
  }

  

  /**
  * Get color
  * @return color
  **/
  @Schema(description = "")
  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }
  public WorkerDetails login(String login) {
    this.login = login;
    return this;
  }

  

  /**
  * Get login
  * @return login
  **/
  @Schema(description = "")
  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }
  public WorkerDetails password(String password) {
    this.password = password;
    return this;
  }

  

  /**
  * Get password
  * @return password
  **/
  @Schema(description = "")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public WorkerDetails rating(Float rating) {
    this.rating = rating;
    return this;
  }

  

  /**
  * Get rating
  * @return rating
  **/
  @Schema(description = "")
  public Float getRating() {
    return rating;
  }
  public void setRating(Float rating) {
    this.rating = rating;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkerDetails workerDetails = (WorkerDetails) o;
    return Objects.equals(this.id, workerDetails.id) &&
        Objects.equals(this.name, workerDetails.name) &&
        Objects.equals(this.photo, workerDetails.photo) &&
        Objects.equals(this.phone, workerDetails.phone) &&
        Objects.equals(this.passportData, workerDetails.passportData) &&
        Objects.equals(this.role, workerDetails.role) &&
        Objects.equals(this.color, workerDetails.color) &&
        Objects.equals(this.login, workerDetails.login) &&
        Objects.equals(this.password, workerDetails.password) &&
        Objects.equals(this.rating, workerDetails.rating);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, name, photo, phone, passportData, role, color, login, password, rating);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkerDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    passportData: ").append(toIndentedString(passportData)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
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