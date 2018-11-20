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
 * Put Task Details
 */
@Schema(description = "Put Task Details")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-20T18:36:01.976Z[GMT]")public class PutTaskDetails {

  @SerializedName("date")
  private File date = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("idWorker")
  private Integer idWorker = null;
  public PutTaskDetails date(File date) {
    this.date = date;
    return this;
  }

  

  /**
  * Get date
  * @return date
  **/
  @Schema(description = "")
  public File getDate() {
    return date;
  }
  public void setDate(File date) {
    this.date = date;
  }
  public PutTaskDetails description(String description) {
    this.description = description;
    return this;
  }

  

  /**
  * Get description
  * @return description
  **/
  @Schema(description = "")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public PutTaskDetails idWorker(Integer idWorker) {
    this.idWorker = idWorker;
    return this;
  }

  

  /**
  * Get idWorker
  * @return idWorker
  **/
  @Schema(description = "")
  public Integer getIdWorker() {
    return idWorker;
  }
  public void setIdWorker(Integer idWorker) {
    this.idWorker = idWorker;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PutTaskDetails putTaskDetails = (PutTaskDetails) o;
    return Objects.equals(this.date, putTaskDetails.date) &&
        Objects.equals(this.description, putTaskDetails.description) &&
        Objects.equals(this.idWorker, putTaskDetails.idWorker);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(date, description, idWorker);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PutTaskDetails {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    idWorker: ").append(toIndentedString(idWorker)).append("\n");
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