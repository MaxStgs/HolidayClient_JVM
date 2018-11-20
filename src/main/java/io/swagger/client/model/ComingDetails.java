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
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;

/**
 * ComingDetails
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-20T18:36:01.976Z[GMT]")public class ComingDetails {

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("comments")
  private String comments = null;

  @SerializedName("Date")
  private OffsetDateTime date = null;

  @SerializedName("total")
  private Float total = null;

  @SerializedName("idStatement")
  private Integer idStatement = null;
  public ComingDetails id(Integer id) {
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
  public ComingDetails comments(String comments) {
    this.comments = comments;
    return this;
  }

  

  /**
  * Get comments
  * @return comments
  **/
  @Schema(description = "")
  public String getComments() {
    return comments;
  }
  public void setComments(String comments) {
    this.comments = comments;
  }
  public ComingDetails date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  

  /**
  * Get date
  * @return date
  **/
  @Schema(description = "")
  public OffsetDateTime getDate() {
    return date;
  }
  public void setDate(OffsetDateTime date) {
    this.date = date;
  }
  public ComingDetails total(Float total) {
    this.total = total;
    return this;
  }

  

  /**
  * Get total
  * @return total
  **/
  @Schema(description = "")
  public Float getTotal() {
    return total;
  }
  public void setTotal(Float total) {
    this.total = total;
  }
  public ComingDetails idStatement(Integer idStatement) {
    this.idStatement = idStatement;
    return this;
  }

  

  /**
  * Get idStatement
  * @return idStatement
  **/
  @Schema(description = "")
  public Integer getIdStatement() {
    return idStatement;
  }
  public void setIdStatement(Integer idStatement) {
    this.idStatement = idStatement;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComingDetails comingDetails = (ComingDetails) o;
    return Objects.equals(this.id, comingDetails.id) &&
        Objects.equals(this.comments, comingDetails.comments) &&
        Objects.equals(this.date, comingDetails.date) &&
        Objects.equals(this.total, comingDetails.total) &&
        Objects.equals(this.idStatement, comingDetails.idStatement);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, comments, date, total, idStatement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComingDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    idStatement: ").append(toIndentedString(idStatement)).append("\n");
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