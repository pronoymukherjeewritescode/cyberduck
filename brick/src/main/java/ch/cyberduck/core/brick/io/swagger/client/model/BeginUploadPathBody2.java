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
 * BeginUploadPathBody2
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-11T22:16:14.309804+02:00[Europe/Paris]")
public class BeginUploadPathBody2 {
  @JsonProperty("mkdir_parents")
  private Boolean mkdirParents = null;

  @JsonProperty("part")
  private Integer part = null;

  @JsonProperty("parts")
  private Integer parts = null;

  @JsonProperty("ref")
  private String ref = null;

  @JsonProperty("restart")
  private Integer restart = null;

  @JsonProperty("with_rename")
  private Boolean withRename = null;

  public BeginUploadPathBody2 mkdirParents(Boolean mkdirParents) {
    this.mkdirParents = mkdirParents;
    return this;
  }

   /**
   * Create parent directories if they do not exist?
   * @return mkdirParents
  **/
  @Schema(description = "Create parent directories if they do not exist?")
  public Boolean isMkdirParents() {
    return mkdirParents;
  }

  public void setMkdirParents(Boolean mkdirParents) {
    this.mkdirParents = mkdirParents;
  }

  public BeginUploadPathBody2 part(Integer part) {
    this.part = part;
    return this;
  }

   /**
   * Part if uploading a part.
   * @return part
  **/
  @Schema(description = "Part if uploading a part.")
  public Integer getPart() {
    return part;
  }

  public void setPart(Integer part) {
    this.part = part;
  }

  public BeginUploadPathBody2 parts(Integer parts) {
    this.parts = parts;
    return this;
  }

   /**
   * How many parts to fetch?
   * @return parts
  **/
  @Schema(description = "How many parts to fetch?")
  public Integer getParts() {
    return parts;
  }

  public void setParts(Integer parts) {
    this.parts = parts;
  }

  public BeginUploadPathBody2 ref(String ref) {
    this.ref = ref;
    return this;
  }

   /**
   * Get ref
   * @return ref
  **/
  @Schema(description = "")
  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public BeginUploadPathBody2 restart(Integer restart) {
    this.restart = restart;
    return this;
  }

   /**
   * File byte offset to restart from.
   * @return restart
  **/
  @Schema(description = "File byte offset to restart from.")
  public Integer getRestart() {
    return restart;
  }

  public void setRestart(Integer restart) {
    this.restart = restart;
  }

  public BeginUploadPathBody2 withRename(Boolean withRename) {
    this.withRename = withRename;
    return this;
  }

   /**
   * Allow file rename instead of overwrite?
   * @return withRename
  **/
  @Schema(description = "Allow file rename instead of overwrite?")
  public Boolean isWithRename() {
    return withRename;
  }

  public void setWithRename(Boolean withRename) {
    this.withRename = withRename;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BeginUploadPathBody2 beginUploadPathBody2 = (BeginUploadPathBody2) o;
    return Objects.equals(this.mkdirParents, beginUploadPathBody2.mkdirParents) &&
        Objects.equals(this.part, beginUploadPathBody2.part) &&
        Objects.equals(this.parts, beginUploadPathBody2.parts) &&
        Objects.equals(this.ref, beginUploadPathBody2.ref) &&
        Objects.equals(this.restart, beginUploadPathBody2.restart) &&
        Objects.equals(this.withRename, beginUploadPathBody2.withRename);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mkdirParents, part, parts, ref, restart, withRename);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BeginUploadPathBody2 {\n");
    
    sb.append("    mkdirParents: ").append(toIndentedString(mkdirParents)).append("\n");
    sb.append("    part: ").append(toIndentedString(part)).append("\n");
    sb.append("    parts: ").append(toIndentedString(parts)).append("\n");
    sb.append("    ref: ").append(toIndentedString(ref)).append("\n");
    sb.append("    restart: ").append(toIndentedString(restart)).append("\n");
    sb.append("    withRename: ").append(toIndentedString(withRename)).append("\n");
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
