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
import io.swagger.client.model.SubtaskDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * List of Subtasks
 */
@Schema(description = "List of Subtasks")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-20T18:36:01.976Z[GMT]")public class ListOfSubtasks {

  @SerializedName("list")
  private List<SubtaskDetails> list = null;
  public ListOfSubtasks list(List<SubtaskDetails> list) {
    this.list = list;
    return this;
  }

  public ListOfSubtasks addListItem(SubtaskDetails listItem) {
    if (this.list == null) {
      this.list = new ArrayList<SubtaskDetails>();
    }
    this.list.add(listItem);
    return this;
  }

  /**
  * Get list
  * @return list
  **/
  @Schema(description = "")
  public List<SubtaskDetails> getList() {
    return list;
  }
  public void setList(List<SubtaskDetails> list) {
    this.list = list;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListOfSubtasks listOfSubtasks = (ListOfSubtasks) o;
    return Objects.equals(this.list, listOfSubtasks.list);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(list);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListOfSubtasks {\n");
    
    sb.append("    list: ").append(toIndentedString(list)).append("\n");
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
