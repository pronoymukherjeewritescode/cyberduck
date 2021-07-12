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
import org.joda.time.DateTime;
/**
 * SiteApiKeysBody
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-12T12:23:43.971535+02:00[Europe/Paris]")
public class SiteApiKeysBody {
  @JsonProperty("user_id")
  private Integer userId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("expires_at")
  private DateTime expiresAt = null;

  /**
   * Permissions for this API Key.  Keys with the &#x60;desktop_app&#x60; permission set only have the ability to do the functions provided in our Desktop App (File and Share Link operations).  Additional permission sets may become available in the future, such as for a Site Admin to give a key with no administrator privileges.  If you have ideas for permission sets, please let us know.
   */
  public enum PermissionSetEnum {
    NONE("none"),
    FULL("full"),
    DESKTOP_APP("desktop_app"),
    SYNC_APP("sync_app"),
    OFFICE_INTEGRATION("office_integration");

    private String value;

    PermissionSetEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static PermissionSetEnum fromValue(String text) {
      for (PermissionSetEnum b : PermissionSetEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("permission_set")
  private PermissionSetEnum permissionSet = PermissionSetEnum.FULL;

  @JsonProperty("path")
  private String path = null;

  public SiteApiKeysBody userId(Integer userId) {
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

  public SiteApiKeysBody name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Internal name for the API Key.  For your use.
   * @return name
  **/
  @Schema(example = "My Main API Key", description = "Internal name for the API Key.  For your use.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SiteApiKeysBody expiresAt(DateTime expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

   /**
   * API Key expiration date
   * @return expiresAt
  **/
  @Schema(example = "2000-01-01T01:00Z", description = "API Key expiration date")
  public DateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(DateTime expiresAt) {
    this.expiresAt = expiresAt;
  }

  public SiteApiKeysBody permissionSet(PermissionSetEnum permissionSet) {
    this.permissionSet = permissionSet;
    return this;
  }

   /**
   * Permissions for this API Key.  Keys with the &#x60;desktop_app&#x60; permission set only have the ability to do the functions provided in our Desktop App (File and Share Link operations).  Additional permission sets may become available in the future, such as for a Site Admin to give a key with no administrator privileges.  If you have ideas for permission sets, please let us know.
   * @return permissionSet
  **/
  @Schema(example = "full", description = "Permissions for this API Key.  Keys with the `desktop_app` permission set only have the ability to do the functions provided in our Desktop App (File and Share Link operations).  Additional permission sets may become available in the future, such as for a Site Admin to give a key with no administrator privileges.  If you have ideas for permission sets, please let us know.")
  public PermissionSetEnum getPermissionSet() {
    return permissionSet;
  }

  public void setPermissionSet(PermissionSetEnum permissionSet) {
    this.permissionSet = permissionSet;
  }

  public SiteApiKeysBody path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Folder path restriction for this api key.
   * @return path
  **/
  @Schema(example = "shared/docs", description = "Folder path restriction for this api key.")
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
    SiteApiKeysBody siteApiKeysBody = (SiteApiKeysBody) o;
    return Objects.equals(this.userId, siteApiKeysBody.userId) &&
        Objects.equals(this.name, siteApiKeysBody.name) &&
        Objects.equals(this.expiresAt, siteApiKeysBody.expiresAt) &&
        Objects.equals(this.permissionSet, siteApiKeysBody.permissionSet) &&
        Objects.equals(this.path, siteApiKeysBody.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name, expiresAt, permissionSet, path);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SiteApiKeysBody {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    permissionSet: ").append(toIndentedString(permissionSet)).append("\n");
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
