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
import org.threeten.bp.OffsetDateTime;

/**
 * Post Oil Details
 */
@Schema(description = "Post Oil Details")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-20T18:36:01.976Z[GMT]")public class PostOilDetails {

  @SerializedName("comments")
  private String comments = null;

  @SerializedName("date")
  private OffsetDateTime date = null;

  @SerializedName("photoOdometer")
  private File photoOdometer = null;

  @SerializedName("countOil")
  private Float countOil = null;

  @SerializedName("photoCheck")
  private File photoCheck = null;

  @SerializedName("idStatement")
  private Integer idStatement = null;

  @SerializedName("idCar")
  private Integer idCar = null;
  public PostOilDetails comments(String comments) {
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
  public PostOilDetails date(OffsetDateTime date) {
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
  public PostOilDetails photoOdometer(File photoOdometer) {
    this.photoOdometer = photoOdometer;
    return this;
  }

  

  /**
  * Get photoOdometer
  * @return photoOdometer
  **/
  @Schema(description = "")
  public File getPhotoOdometer() {
    return photoOdometer;
  }
  public void setPhotoOdometer(File photoOdometer) {
    this.photoOdometer = photoOdometer;
  }
  public PostOilDetails countOil(Float countOil) {
    this.countOil = countOil;
    return this;
  }

  

  /**
  * Get countOil
  * @return countOil
  **/
  @Schema(description = "")
  public Float getCountOil() {
    return countOil;
  }
  public void setCountOil(Float countOil) {
    this.countOil = countOil;
  }
  public PostOilDetails photoCheck(File photoCheck) {
    this.photoCheck = photoCheck;
    return this;
  }

  

  /**
  * Get photoCheck
  * @return photoCheck
  **/
  @Schema(description = "")
  public File getPhotoCheck() {
    return photoCheck;
  }
  public void setPhotoCheck(File photoCheck) {
    this.photoCheck = photoCheck;
  }
  public PostOilDetails idStatement(Integer idStatement) {
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
  public PostOilDetails idCar(Integer idCar) {
    this.idCar = idCar;
    return this;
  }

  

  /**
  * Get idCar
  * @return idCar
  **/
  @Schema(description = "")
  public Integer getIdCar() {
    return idCar;
  }
  public void setIdCar(Integer idCar) {
    this.idCar = idCar;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostOilDetails postOilDetails = (PostOilDetails) o;
    return Objects.equals(this.comments, postOilDetails.comments) &&
        Objects.equals(this.date, postOilDetails.date) &&
        Objects.equals(this.photoOdometer, postOilDetails.photoOdometer) &&
        Objects.equals(this.countOil, postOilDetails.countOil) &&
        Objects.equals(this.photoCheck, postOilDetails.photoCheck) &&
        Objects.equals(this.idStatement, postOilDetails.idStatement) &&
        Objects.equals(this.idCar, postOilDetails.idCar);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(comments, date, photoOdometer, countOil, photoCheck, idStatement, idCar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostOilDetails {\n");
    
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    photoOdometer: ").append(toIndentedString(photoOdometer)).append("\n");
    sb.append("    countOil: ").append(toIndentedString(countOil)).append("\n");
    sb.append("    photoCheck: ").append(toIndentedString(photoCheck)).append("\n");
    sb.append("    idStatement: ").append(toIndentedString(idStatement)).append("\n");
    sb.append("    idCar: ").append(toIndentedString(idCar)).append("\n");
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
