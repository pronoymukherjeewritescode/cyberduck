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
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * FileCommentsBody
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-12T12:23:43.971535+02:00[Europe/Paris]")
public class FileCommentsBody {
  @JsonProperty("body")
  private String body = null;

  @JsonProperty("path")
  private String path = null;

  public FileCommentsBody body(String body) {
    this.body = body;
    return this;
  }

   /**
   * Comment body.
   * @return body
  **/
  @Schema(required = true, description = "Comment body.")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public FileCommentsBody path(String path) {
    this.path = path;
    return this;
  }

   /**
   * File path.
   * @return path
  **/
  @Schema(required = true, description = "File path.")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileCommentsBody fileCommentsBody = (FileCommentsBody) o;
    return Objects.equals(this.body, fileCommentsBody.body) &&
        Objects.equals(this.path, fileCommentsBody.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(body, path);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileCommentsBody {\n");
    
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
