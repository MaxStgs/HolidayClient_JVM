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
 * Equipment details
 */
@Schema(description = "Equipment details")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-20T18:36:01.976Z[GMT]")public class EquipmentDetails {

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("rentTime")
  private OffsetDateTime rentTime = null;

  @SerializedName("price")
  private Float price = null;
  public EquipmentDetails id(Integer id) {
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
  public EquipmentDetails rentTime(OffsetDateTime rentTime) {
    this.rentTime = rentTime;
    return this;
  }

  

  /**
  * Get rentTime
  * @return rentTime
  **/
  @Schema(description = "")
  public OffsetDateTime getRentTime() {
    return rentTime;
  }
  public void setRentTime(OffsetDateTime rentTime) {
    this.rentTime = rentTime;
  }
  public EquipmentDetails price(Float price) {
    this.price = price;
    return this;
  }

  

  /**
  * Get price
  * @return price
  **/
  @Schema(description = "")
  public Float getPrice() {
    return price;
  }
  public void setPrice(Float price) {
    this.price = price;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EquipmentDetails equipmentDetails = (EquipmentDetails) o;
    return Objects.equals(this.id, equipmentDetails.id) &&
        Objects.equals(this.rentTime, equipmentDetails.rentTime) &&
        Objects.equals(this.price, equipmentDetails.price);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, rentTime, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipmentDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    rentTime: ").append(toIndentedString(rentTime)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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