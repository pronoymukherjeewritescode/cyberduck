/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.brick.io.swagger.client.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * GroupUsersIdBody2
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-11T22:16:14.309804+02:00[Europe/Paris]")
public class GroupUsersIdBody2 {
  @JsonProperty("group_id")
  private Integer groupId = null;

  @JsonProperty("user_id")
  private Integer userId = null;

  @JsonProperty("admin")
  private Boolean admin = null;

  public GroupUsersIdBody2 groupId(Integer groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * Group ID to add user to.
   * @return groupId
  **/
  @Schema(required = true, description = "Group ID to add user to.")
  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public GroupUsersIdBody2 userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * User ID to add to group.
   * @return userId
  **/
  @Schema(required = true, description = "User ID to add to group.")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public GroupUsersIdBody2 admin(Boolean admin) {
    this.admin = admin;
    return this;
  }

   /**
   * Is the user a group administrator?
   * @return admin
  **/
  @Schema(description = "Is the user a group administrator?")
  public Boolean isAdmin() {
    return admin;
  }

  public void setAdmin(Boolean admin) {
    this.admin = admin;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupUsersIdBody2 groupUsersIdBody2 = (GroupUsersIdBody2) o;
    return Objects.equals(this.groupId, groupUsersIdBody2.groupId) &&
        Objects.equals(this.userId, groupUsersIdBody2.userId) &&
        Objects.equals(this.admin, groupUsersIdBody2.admin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupId, userId, admin);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupUsersIdBody2 {\n");
    
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    admin: ").append(toIndentedString(admin)).append("\n");
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
