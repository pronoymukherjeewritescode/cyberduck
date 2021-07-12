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
 * MessageCommentReactionsBody1
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-11T22:22:59.746599+02:00[Europe/Paris]")
public class MessageCommentReactionsBody1 {
  @JsonProperty("user_id")
  private Integer userId = null;

  @JsonProperty("emoji")
  private String emoji = null;

  public MessageCommentReactionsBody1 userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * User ID.  Provide a value of &#x60;0&#x60; to operate the current session&#x27;s user.
   * @return userId
  **/
  @Schema(description = "User ID.  Provide a value of `0` to operate the current session's user.")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public MessageCommentReactionsBody1 emoji(String emoji) {
    this.emoji = emoji;
    return this;
  }

   /**
   * Emoji to react with.
   * @return emoji
  **/
  @Schema(required = true, description = "Emoji to react with.")
  public String getEmoji() {
    return emoji;
  }

  public void setEmoji(String emoji) {
    this.emoji = emoji;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageCommentReactionsBody1 messageCommentReactionsBody1 = (MessageCommentReactionsBody1) o;
    return Objects.equals(this.userId, messageCommentReactionsBody1.userId) &&
        Objects.equals(this.emoji, messageCommentReactionsBody1.emoji);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, emoji);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageCommentReactionsBody1 {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    emoji: ").append(toIndentedString(emoji)).append("\n");
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
