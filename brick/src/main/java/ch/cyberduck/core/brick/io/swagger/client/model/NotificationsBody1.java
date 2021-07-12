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
 * NotificationsBody1
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-11T22:23:45.902337+02:00[Europe/Paris]")
public class NotificationsBody1 {
  @JsonProperty("user_id")
  private Integer userId = null;

  @JsonProperty("notify_on_copy")
  private Boolean notifyOnCopy = null;

  @JsonProperty("notify_user_actions")
  private Boolean notifyUserActions = null;

  @JsonProperty("recursive")
  private Boolean recursive = null;

  @JsonProperty("send_interval")
  private String sendInterval = null;

  @JsonProperty("group_id")
  private Integer groupId = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("username")
  private String username = null;

  public NotificationsBody1 userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * The id of the user to notify. Provide &#x60;user_id&#x60;, &#x60;username&#x60; or &#x60;group_id&#x60;.
   * @return userId
  **/
  @Schema(description = "The id of the user to notify. Provide `user_id`, `username` or `group_id`.")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public NotificationsBody1 notifyOnCopy(Boolean notifyOnCopy) {
    this.notifyOnCopy = notifyOnCopy;
    return this;
  }

   /**
   * If &#x60;true&#x60;, copying or moving resources into this path will trigger a notification, in addition to just uploads.
   * @return notifyOnCopy
  **/
  @Schema(description = "If `true`, copying or moving resources into this path will trigger a notification, in addition to just uploads.")
  public Boolean isNotifyOnCopy() {
    return notifyOnCopy;
  }

  public void setNotifyOnCopy(Boolean notifyOnCopy) {
    this.notifyOnCopy = notifyOnCopy;
  }

  public NotificationsBody1 notifyUserActions(Boolean notifyUserActions) {
    this.notifyUserActions = notifyUserActions;
    return this;
  }

   /**
   * If &#x60;true&#x60; actions initiated by the user will still result in a notification
   * @return notifyUserActions
  **/
  @Schema(description = "If `true` actions initiated by the user will still result in a notification")
  public Boolean isNotifyUserActions() {
    return notifyUserActions;
  }

  public void setNotifyUserActions(Boolean notifyUserActions) {
    this.notifyUserActions = notifyUserActions;
  }

  public NotificationsBody1 recursive(Boolean recursive) {
    this.recursive = recursive;
    return this;
  }

   /**
   * If &#x60;true&#x60;, enable notifications for each subfolder in this path
   * @return recursive
  **/
  @Schema(description = "If `true`, enable notifications for each subfolder in this path")
  public Boolean isRecursive() {
    return recursive;
  }

  public void setRecursive(Boolean recursive) {
    this.recursive = recursive;
  }

  public NotificationsBody1 sendInterval(String sendInterval) {
    this.sendInterval = sendInterval;
    return this;
  }

   /**
   * The time interval that notifications are aggregated by.  Can be &#x60;five_minutes&#x60;, &#x60;fifteen_minutes&#x60;, &#x60;hourly&#x60;, or &#x60;daily&#x60;.
   * @return sendInterval
  **/
  @Schema(example = "daily", description = "The time interval that notifications are aggregated by.  Can be `five_minutes`, `fifteen_minutes`, `hourly`, or `daily`.")
  public String getSendInterval() {
    return sendInterval;
  }

  public void setSendInterval(String sendInterval) {
    this.sendInterval = sendInterval;
  }

  public NotificationsBody1 groupId(Integer groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * The ID of the group to notify.  Provide &#x60;user_id&#x60;, &#x60;username&#x60; or &#x60;group_id&#x60;.
   * @return groupId
  **/
  @Schema(description = "The ID of the group to notify.  Provide `user_id`, `username` or `group_id`.")
  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public NotificationsBody1 path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Path
   * @return path
  **/
  @Schema(description = "Path")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public NotificationsBody1 username(String username) {
    this.username = username;
    return this;
  }

   /**
   * The username of the user to notify.  Provide &#x60;user_id&#x60;, &#x60;username&#x60; or &#x60;group_id&#x60;.
   * @return username
  **/
  @Schema(description = "The username of the user to notify.  Provide `user_id`, `username` or `group_id`.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationsBody1 notificationsBody1 = (NotificationsBody1) o;
    return Objects.equals(this.userId, notificationsBody1.userId) &&
        Objects.equals(this.notifyOnCopy, notificationsBody1.notifyOnCopy) &&
        Objects.equals(this.notifyUserActions, notificationsBody1.notifyUserActions) &&
        Objects.equals(this.recursive, notificationsBody1.recursive) &&
        Objects.equals(this.sendInterval, notificationsBody1.sendInterval) &&
        Objects.equals(this.groupId, notificationsBody1.groupId) &&
        Objects.equals(this.path, notificationsBody1.path) &&
        Objects.equals(this.username, notificationsBody1.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, notifyOnCopy, notifyUserActions, recursive, sendInterval, groupId, path, username);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationsBody1 {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    notifyOnCopy: ").append(toIndentedString(notifyOnCopy)).append("\n");
    sb.append("    notifyUserActions: ").append(toIndentedString(notifyUserActions)).append("\n");
    sb.append("    recursive: ").append(toIndentedString(recursive)).append("\n");
    sb.append("    sendInterval: ").append(toIndentedString(sendInterval)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
