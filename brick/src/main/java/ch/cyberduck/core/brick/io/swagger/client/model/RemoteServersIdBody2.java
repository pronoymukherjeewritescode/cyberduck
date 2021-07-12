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
 * RemoteServersIdBody2
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-12T10:20:43.848213+02:00[Europe/Paris]")
public class RemoteServersIdBody2 {
  @JsonProperty("aws_access_key")
  private String awsAccessKey = null;

  @JsonProperty("aws_secret_key")
  private String awsSecretKey = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("private_key")
  private String privateKey = null;

  @JsonProperty("ssl_certificate")
  private String sslCertificate = null;

  @JsonProperty("google_cloud_storage_credentials_json")
  private String googleCloudStorageCredentialsJson = null;

  @JsonProperty("wasabi_access_key")
  private String wasabiAccessKey = null;

  @JsonProperty("wasabi_secret_key")
  private String wasabiSecretKey = null;

  @JsonProperty("backblaze_b2_key_id")
  private String backblazeB2KeyId = null;

  @JsonProperty("backblaze_b2_application_key")
  private String backblazeB2ApplicationKey = null;

  @JsonProperty("rackspace_api_key")
  private String rackspaceApiKey = null;

  @JsonProperty("reset_authentication")
  private Boolean resetAuthentication = null;

  @JsonProperty("azure_blob_storage_access_key")
  private String azureBlobStorageAccessKey = null;

  @JsonProperty("hostname")
  private String hostname = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("max_connections")
  private Integer maxConnections = null;

  @JsonProperty("port")
  private Integer port = null;

  @JsonProperty("s3_bucket")
  private String s3Bucket = null;

  @JsonProperty("s3_region")
  private String s3Region = null;

  /**
   * Remote server certificate
   */
  public enum ServerCertificateEnum {
    REQUIRE_MATCH("require_match"),
    ALLOW_ANY("allow_any");

    private String value;

    ServerCertificateEnum(String value) {
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
    public static ServerCertificateEnum fromValue(String text) {
      for (ServerCertificateEnum b : ServerCertificateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("server_certificate")
  private ServerCertificateEnum serverCertificate = null;

  @JsonProperty("server_host_key")
  private String serverHostKey = null;

  /**
   * Remote server type.
   */
  public enum ServerTypeEnum {
    FTP("ftp"),
    SFTP("sftp"),
    S3("s3"),
    GOOGLE_CLOUD_STORAGE("google_cloud_storage"),
    WEBDAV("webdav"),
    WASABI("wasabi"),
    BACKBLAZE_B2("backblaze_b2"),
    ONE_DRIVE("one_drive"),
    RACKSPACE("rackspace"),
    BOX("box"),
    DROPBOX("dropbox"),
    GOOGLE_DRIVE("google_drive"),
    AZURE("azure"),
    SHAREPOINT("sharepoint"),
    S3_COMPATIBLE("s3_compatible");

    private String value;

    ServerTypeEnum(String value) {
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
    public static ServerTypeEnum fromValue(String text) {
      for (ServerTypeEnum b : ServerTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("server_type")
  private ServerTypeEnum serverType = null;

  /**
   * Should we require SSL?
   */
  public enum SslEnum {
    IF_AVAILABLE("if_available"),
    REQUIRE("require"),
    REQUIRE_IMPLICIT("require_implicit"),
    NEVER("never");

    private String value;

    SslEnum(String value) {
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
    public static SslEnum fromValue(String text) {
      for (SslEnum b : SslEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("ssl")
  private SslEnum ssl = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("google_cloud_storage_bucket")
  private String googleCloudStorageBucket = null;

  @JsonProperty("google_cloud_storage_project_id")
  private String googleCloudStorageProjectId = null;

  @JsonProperty("backblaze_b2_bucket")
  private String backblazeB2Bucket = null;

  @JsonProperty("backblaze_b2_s3_endpoint")
  private String backblazeB2S3Endpoint = null;

  @JsonProperty("wasabi_bucket")
  private String wasabiBucket = null;

  @JsonProperty("wasabi_region")
  private String wasabiRegion = null;

  @JsonProperty("rackspace_username")
  private String rackspaceUsername = null;

  @JsonProperty("rackspace_region")
  private String rackspaceRegion = null;

  @JsonProperty("rackspace_container")
  private String rackspaceContainer = null;

  /**
   * Either personal or business_other account types
   */
  public enum OneDriveAccountTypeEnum {
    PERSONAL("personal"),
    BUSINESS_OTHER("business_other");

    private String value;

    OneDriveAccountTypeEnum(String value) {
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
    public static OneDriveAccountTypeEnum fromValue(String text) {
      for (OneDriveAccountTypeEnum b : OneDriveAccountTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("one_drive_account_type")
  private OneDriveAccountTypeEnum oneDriveAccountType = null;

  @JsonProperty("azure_blob_storage_account")
  private String azureBlobStorageAccount = null;

  @JsonProperty("azure_blob_storage_container")
  private String azureBlobStorageContainer = null;

  @JsonProperty("s3_compatible_bucket")
  private String s3CompatibleBucket = null;

  @JsonProperty("s3_compatible_region")
  private String s3CompatibleRegion = null;

  @JsonProperty("s3_compatible_endpoint")
  private String s3CompatibleEndpoint = null;

  @JsonProperty("s3_compatible_access_key")
  private String s3CompatibleAccessKey = null;

  @JsonProperty("s3_compatible_secret_key")
  private String s3CompatibleSecretKey = null;

  public RemoteServersIdBody2 awsAccessKey(String awsAccessKey) {
    this.awsAccessKey = awsAccessKey;
    return this;
  }

   /**
   * AWS Access Key.
   * @return awsAccessKey
  **/
  @Schema(description = "AWS Access Key.")
  public String getAwsAccessKey() {
    return awsAccessKey;
  }

  public void setAwsAccessKey(String awsAccessKey) {
    this.awsAccessKey = awsAccessKey;
  }

  public RemoteServersIdBody2 awsSecretKey(String awsSecretKey) {
    this.awsSecretKey = awsSecretKey;
    return this;
  }

   /**
   * AWS secret key.
   * @return awsSecretKey
  **/
  @Schema(description = "AWS secret key.")
  public String getAwsSecretKey() {
    return awsSecretKey;
  }

  public void setAwsSecretKey(String awsSecretKey) {
    this.awsSecretKey = awsSecretKey;
  }

  public RemoteServersIdBody2 password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Password if needed.
   * @return password
  **/
  @Schema(description = "Password if needed.")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public RemoteServersIdBody2 privateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

   /**
   * Private key if needed.
   * @return privateKey
  **/
  @Schema(description = "Private key if needed.")
  public String getPrivateKey() {
    return privateKey;
  }

  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }

  public RemoteServersIdBody2 sslCertificate(String sslCertificate) {
    this.sslCertificate = sslCertificate;
    return this;
  }

   /**
   * SSL client certificate.
   * @return sslCertificate
  **/
  @Schema(description = "SSL client certificate.")
  public String getSslCertificate() {
    return sslCertificate;
  }

  public void setSslCertificate(String sslCertificate) {
    this.sslCertificate = sslCertificate;
  }

  public RemoteServersIdBody2 googleCloudStorageCredentialsJson(String googleCloudStorageCredentialsJson) {
    this.googleCloudStorageCredentialsJson = googleCloudStorageCredentialsJson;
    return this;
  }

   /**
   * A JSON file that contains the private key. To generate see https://cloud.google.com/storage/docs/json_api/v1/how-tos/authorizing#APIKey
   * @return googleCloudStorageCredentialsJson
  **/
  @Schema(description = "A JSON file that contains the private key. To generate see https://cloud.google.com/storage/docs/json_api/v1/how-tos/authorizing#APIKey")
  public String getGoogleCloudStorageCredentialsJson() {
    return googleCloudStorageCredentialsJson;
  }

  public void setGoogleCloudStorageCredentialsJson(String googleCloudStorageCredentialsJson) {
    this.googleCloudStorageCredentialsJson = googleCloudStorageCredentialsJson;
  }

  public RemoteServersIdBody2 wasabiAccessKey(String wasabiAccessKey) {
    this.wasabiAccessKey = wasabiAccessKey;
    return this;
  }

   /**
   * Wasabi access key.
   * @return wasabiAccessKey
  **/
  @Schema(description = "Wasabi access key.")
  public String getWasabiAccessKey() {
    return wasabiAccessKey;
  }

  public void setWasabiAccessKey(String wasabiAccessKey) {
    this.wasabiAccessKey = wasabiAccessKey;
  }

  public RemoteServersIdBody2 wasabiSecretKey(String wasabiSecretKey) {
    this.wasabiSecretKey = wasabiSecretKey;
    return this;
  }

   /**
   * Wasabi secret key.
   * @return wasabiSecretKey
  **/
  @Schema(description = "Wasabi secret key.")
  public String getWasabiSecretKey() {
    return wasabiSecretKey;
  }

  public void setWasabiSecretKey(String wasabiSecretKey) {
    this.wasabiSecretKey = wasabiSecretKey;
  }

  public RemoteServersIdBody2 backblazeB2KeyId(String backblazeB2KeyId) {
    this.backblazeB2KeyId = backblazeB2KeyId;
    return this;
  }

   /**
   * Backblaze B2 Cloud Storage keyID.
   * @return backblazeB2KeyId
  **/
  @Schema(description = "Backblaze B2 Cloud Storage keyID.")
  public String getBackblazeB2KeyId() {
    return backblazeB2KeyId;
  }

  public void setBackblazeB2KeyId(String backblazeB2KeyId) {
    this.backblazeB2KeyId = backblazeB2KeyId;
  }

  public RemoteServersIdBody2 backblazeB2ApplicationKey(String backblazeB2ApplicationKey) {
    this.backblazeB2ApplicationKey = backblazeB2ApplicationKey;
    return this;
  }

   /**
   * Backblaze B2 Cloud Storage applicationKey.
   * @return backblazeB2ApplicationKey
  **/
  @Schema(description = "Backblaze B2 Cloud Storage applicationKey.")
  public String getBackblazeB2ApplicationKey() {
    return backblazeB2ApplicationKey;
  }

  public void setBackblazeB2ApplicationKey(String backblazeB2ApplicationKey) {
    this.backblazeB2ApplicationKey = backblazeB2ApplicationKey;
  }

  public RemoteServersIdBody2 rackspaceApiKey(String rackspaceApiKey) {
    this.rackspaceApiKey = rackspaceApiKey;
    return this;
  }

   /**
   * Rackspace API key from the Rackspace Cloud Control Panel.
   * @return rackspaceApiKey
  **/
  @Schema(description = "Rackspace API key from the Rackspace Cloud Control Panel.")
  public String getRackspaceApiKey() {
    return rackspaceApiKey;
  }

  public void setRackspaceApiKey(String rackspaceApiKey) {
    this.rackspaceApiKey = rackspaceApiKey;
  }

  public RemoteServersIdBody2 resetAuthentication(Boolean resetAuthentication) {
    this.resetAuthentication = resetAuthentication;
    return this;
  }

   /**
   * Reset authenticated account
   * @return resetAuthentication
  **/
  @Schema(description = "Reset authenticated account")
  public Boolean isResetAuthentication() {
    return resetAuthentication;
  }

  public void setResetAuthentication(Boolean resetAuthentication) {
    this.resetAuthentication = resetAuthentication;
  }

  public RemoteServersIdBody2 azureBlobStorageAccessKey(String azureBlobStorageAccessKey) {
    this.azureBlobStorageAccessKey = azureBlobStorageAccessKey;
    return this;
  }

   /**
   * Azure Blob Storage secret key.
   * @return azureBlobStorageAccessKey
  **/
  @Schema(description = "Azure Blob Storage secret key.")
  public String getAzureBlobStorageAccessKey() {
    return azureBlobStorageAccessKey;
  }

  public void setAzureBlobStorageAccessKey(String azureBlobStorageAccessKey) {
    this.azureBlobStorageAccessKey = azureBlobStorageAccessKey;
  }

  public RemoteServersIdBody2 hostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

   /**
   * Hostname or IP address
   * @return hostname
  **/
  @Schema(example = "remote-server.com", description = "Hostname or IP address")
  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public RemoteServersIdBody2 name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Internal name for your reference
   * @return name
  **/
  @Schema(example = "My Remote server", description = "Internal name for your reference")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RemoteServersIdBody2 maxConnections(Integer maxConnections) {
    this.maxConnections = maxConnections;
    return this;
  }

   /**
   * Max number of parallel connections.  Ignored for S3 connections (we will parallelize these as much as possible).
   * @return maxConnections
  **/
  @Schema(example = "1", description = "Max number of parallel connections.  Ignored for S3 connections (we will parallelize these as much as possible).")
  public Integer getMaxConnections() {
    return maxConnections;
  }

  public void setMaxConnections(Integer maxConnections) {
    this.maxConnections = maxConnections;
  }

  public RemoteServersIdBody2 port(Integer port) {
    this.port = port;
    return this;
  }

   /**
   * Port for remote server.  Not needed for S3.
   * @return port
  **/
  @Schema(example = "1", description = "Port for remote server.  Not needed for S3.")
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public RemoteServersIdBody2 s3Bucket(String s3Bucket) {
    this.s3Bucket = s3Bucket;
    return this;
  }

   /**
   * S3 bucket name
   * @return s3Bucket
  **/
  @Schema(example = "my-bucket", description = "S3 bucket name")
  public String getS3Bucket() {
    return s3Bucket;
  }

  public void setS3Bucket(String s3Bucket) {
    this.s3Bucket = s3Bucket;
  }

  public RemoteServersIdBody2 s3Region(String s3Region) {
    this.s3Region = s3Region;
    return this;
  }

   /**
   * S3 region
   * @return s3Region
  **/
  @Schema(example = "us-east-1", description = "S3 region")
  public String getS3Region() {
    return s3Region;
  }

  public void setS3Region(String s3Region) {
    this.s3Region = s3Region;
  }

  public RemoteServersIdBody2 serverCertificate(ServerCertificateEnum serverCertificate) {
    this.serverCertificate = serverCertificate;
    return this;
  }

   /**
   * Remote server certificate
   * @return serverCertificate
  **/
  @Schema(example = "require_match", description = "Remote server certificate")
  public ServerCertificateEnum getServerCertificate() {
    return serverCertificate;
  }

  public void setServerCertificate(ServerCertificateEnum serverCertificate) {
    this.serverCertificate = serverCertificate;
  }

  public RemoteServersIdBody2 serverHostKey(String serverHostKey) {
    this.serverHostKey = serverHostKey;
    return this;
  }

   /**
   * Remote server SSH Host Key. If provided, we will require that the server host key matches the provided key. Uses OpenSSH format similar to what would go into ~/.ssh/known_hosts
   * @return serverHostKey
  **/
  @Schema(example = "[public key]", description = "Remote server SSH Host Key. If provided, we will require that the server host key matches the provided key. Uses OpenSSH format similar to what would go into ~/.ssh/known_hosts")
  public String getServerHostKey() {
    return serverHostKey;
  }

  public void setServerHostKey(String serverHostKey) {
    this.serverHostKey = serverHostKey;
  }

  public RemoteServersIdBody2 serverType(ServerTypeEnum serverType) {
    this.serverType = serverType;
    return this;
  }

   /**
   * Remote server type.
   * @return serverType
  **/
  @Schema(example = "s3", description = "Remote server type.")
  public ServerTypeEnum getServerType() {
    return serverType;
  }

  public void setServerType(ServerTypeEnum serverType) {
    this.serverType = serverType;
  }

  public RemoteServersIdBody2 ssl(SslEnum ssl) {
    this.ssl = ssl;
    return this;
  }

   /**
   * Should we require SSL?
   * @return ssl
  **/
  @Schema(example = "if_available", description = "Should we require SSL?")
  public SslEnum getSsl() {
    return ssl;
  }

  public void setSsl(SslEnum ssl) {
    this.ssl = ssl;
  }

  public RemoteServersIdBody2 username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Remote server username.  Not needed for S3 buckets.
   * @return username
  **/
  @Schema(example = "user", description = "Remote server username.  Not needed for S3 buckets.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public RemoteServersIdBody2 googleCloudStorageBucket(String googleCloudStorageBucket) {
    this.googleCloudStorageBucket = googleCloudStorageBucket;
    return this;
  }

   /**
   * Google Cloud Storage bucket name
   * @return googleCloudStorageBucket
  **/
  @Schema(example = "my-bucket", description = "Google Cloud Storage bucket name")
  public String getGoogleCloudStorageBucket() {
    return googleCloudStorageBucket;
  }

  public void setGoogleCloudStorageBucket(String googleCloudStorageBucket) {
    this.googleCloudStorageBucket = googleCloudStorageBucket;
  }

  public RemoteServersIdBody2 googleCloudStorageProjectId(String googleCloudStorageProjectId) {
    this.googleCloudStorageProjectId = googleCloudStorageProjectId;
    return this;
  }

   /**
   * Google Cloud Project ID
   * @return googleCloudStorageProjectId
  **/
  @Schema(example = "my-project", description = "Google Cloud Project ID")
  public String getGoogleCloudStorageProjectId() {
    return googleCloudStorageProjectId;
  }

  public void setGoogleCloudStorageProjectId(String googleCloudStorageProjectId) {
    this.googleCloudStorageProjectId = googleCloudStorageProjectId;
  }

  public RemoteServersIdBody2 backblazeB2Bucket(String backblazeB2Bucket) {
    this.backblazeB2Bucket = backblazeB2Bucket;
    return this;
  }

   /**
   * Backblaze B2 Cloud Storage Bucket name
   * @return backblazeB2Bucket
  **/
  @Schema(example = "my-bucket", description = "Backblaze B2 Cloud Storage Bucket name")
  public String getBackblazeB2Bucket() {
    return backblazeB2Bucket;
  }

  public void setBackblazeB2Bucket(String backblazeB2Bucket) {
    this.backblazeB2Bucket = backblazeB2Bucket;
  }

  public RemoteServersIdBody2 backblazeB2S3Endpoint(String backblazeB2S3Endpoint) {
    this.backblazeB2S3Endpoint = backblazeB2S3Endpoint;
    return this;
  }

   /**
   * Backblaze B2 Cloud Storage S3 Endpoint
   * @return backblazeB2S3Endpoint
  **/
  @Schema(example = "s3.us-west-001.backblazeb2.com", description = "Backblaze B2 Cloud Storage S3 Endpoint")
  public String getBackblazeB2S3Endpoint() {
    return backblazeB2S3Endpoint;
  }

  public void setBackblazeB2S3Endpoint(String backblazeB2S3Endpoint) {
    this.backblazeB2S3Endpoint = backblazeB2S3Endpoint;
  }

  public RemoteServersIdBody2 wasabiBucket(String wasabiBucket) {
    this.wasabiBucket = wasabiBucket;
    return this;
  }

   /**
   * Wasabi Bucket name
   * @return wasabiBucket
  **/
  @Schema(example = "my-bucket", description = "Wasabi Bucket name")
  public String getWasabiBucket() {
    return wasabiBucket;
  }

  public void setWasabiBucket(String wasabiBucket) {
    this.wasabiBucket = wasabiBucket;
  }

  public RemoteServersIdBody2 wasabiRegion(String wasabiRegion) {
    this.wasabiRegion = wasabiRegion;
    return this;
  }

   /**
   * Wasabi region
   * @return wasabiRegion
  **/
  @Schema(example = "us-west-1", description = "Wasabi region")
  public String getWasabiRegion() {
    return wasabiRegion;
  }

  public void setWasabiRegion(String wasabiRegion) {
    this.wasabiRegion = wasabiRegion;
  }

  public RemoteServersIdBody2 rackspaceUsername(String rackspaceUsername) {
    this.rackspaceUsername = rackspaceUsername;
    return this;
  }

   /**
   * Rackspace username used to login to the Rackspace Cloud Control Panel.
   * @return rackspaceUsername
  **/
  @Schema(example = "rackspaceuser", description = "Rackspace username used to login to the Rackspace Cloud Control Panel.")
  public String getRackspaceUsername() {
    return rackspaceUsername;
  }

  public void setRackspaceUsername(String rackspaceUsername) {
    this.rackspaceUsername = rackspaceUsername;
  }

  public RemoteServersIdBody2 rackspaceRegion(String rackspaceRegion) {
    this.rackspaceRegion = rackspaceRegion;
    return this;
  }

   /**
   * Three letter airport code for Rackspace region. See https://support.rackspace.com/how-to/about-regions/
   * @return rackspaceRegion
  **/
  @Schema(example = "dfw", description = "Three letter airport code for Rackspace region. See https://support.rackspace.com/how-to/about-regions/")
  public String getRackspaceRegion() {
    return rackspaceRegion;
  }

  public void setRackspaceRegion(String rackspaceRegion) {
    this.rackspaceRegion = rackspaceRegion;
  }

  public RemoteServersIdBody2 rackspaceContainer(String rackspaceContainer) {
    this.rackspaceContainer = rackspaceContainer;
    return this;
  }

   /**
   * The name of the container (top level directory) where files will sync.
   * @return rackspaceContainer
  **/
  @Schema(example = "my-container", description = "The name of the container (top level directory) where files will sync.")
  public String getRackspaceContainer() {
    return rackspaceContainer;
  }

  public void setRackspaceContainer(String rackspaceContainer) {
    this.rackspaceContainer = rackspaceContainer;
  }

  public RemoteServersIdBody2 oneDriveAccountType(OneDriveAccountTypeEnum oneDriveAccountType) {
    this.oneDriveAccountType = oneDriveAccountType;
    return this;
  }

   /**
   * Either personal or business_other account types
   * @return oneDriveAccountType
  **/
  @Schema(example = "personal", description = "Either personal or business_other account types")
  public OneDriveAccountTypeEnum getOneDriveAccountType() {
    return oneDriveAccountType;
  }

  public void setOneDriveAccountType(OneDriveAccountTypeEnum oneDriveAccountType) {
    this.oneDriveAccountType = oneDriveAccountType;
  }

  public RemoteServersIdBody2 azureBlobStorageAccount(String azureBlobStorageAccount) {
    this.azureBlobStorageAccount = azureBlobStorageAccount;
    return this;
  }

   /**
   * Azure Blob Storage Account name
   * @return azureBlobStorageAccount
  **/
  @Schema(example = "storage-account-name", description = "Azure Blob Storage Account name")
  public String getAzureBlobStorageAccount() {
    return azureBlobStorageAccount;
  }

  public void setAzureBlobStorageAccount(String azureBlobStorageAccount) {
    this.azureBlobStorageAccount = azureBlobStorageAccount;
  }

  public RemoteServersIdBody2 azureBlobStorageContainer(String azureBlobStorageContainer) {
    this.azureBlobStorageContainer = azureBlobStorageContainer;
    return this;
  }

   /**
   * Azure Blob Storage Container name
   * @return azureBlobStorageContainer
  **/
  @Schema(example = "container-name", description = "Azure Blob Storage Container name")
  public String getAzureBlobStorageContainer() {
    return azureBlobStorageContainer;
  }

  public void setAzureBlobStorageContainer(String azureBlobStorageContainer) {
    this.azureBlobStorageContainer = azureBlobStorageContainer;
  }

  public RemoteServersIdBody2 s3CompatibleBucket(String s3CompatibleBucket) {
    this.s3CompatibleBucket = s3CompatibleBucket;
    return this;
  }

   /**
   * S3-compatible Bucket name
   * @return s3CompatibleBucket
  **/
  @Schema(example = "my-bucket", description = "S3-compatible Bucket name")
  public String getS3CompatibleBucket() {
    return s3CompatibleBucket;
  }

  public void setS3CompatibleBucket(String s3CompatibleBucket) {
    this.s3CompatibleBucket = s3CompatibleBucket;
  }

  public RemoteServersIdBody2 s3CompatibleRegion(String s3CompatibleRegion) {
    this.s3CompatibleRegion = s3CompatibleRegion;
    return this;
  }

   /**
   * S3-compatible Bucket name
   * @return s3CompatibleRegion
  **/
  @Schema(example = "us-east-1", description = "S3-compatible Bucket name")
  public String getS3CompatibleRegion() {
    return s3CompatibleRegion;
  }

  public void setS3CompatibleRegion(String s3CompatibleRegion) {
    this.s3CompatibleRegion = s3CompatibleRegion;
  }

  public RemoteServersIdBody2 s3CompatibleEndpoint(String s3CompatibleEndpoint) {
    this.s3CompatibleEndpoint = s3CompatibleEndpoint;
    return this;
  }

   /**
   * S3-compatible endpoint
   * @return s3CompatibleEndpoint
  **/
  @Schema(example = "mys3platform.com", description = "S3-compatible endpoint")
  public String getS3CompatibleEndpoint() {
    return s3CompatibleEndpoint;
  }

  public void setS3CompatibleEndpoint(String s3CompatibleEndpoint) {
    this.s3CompatibleEndpoint = s3CompatibleEndpoint;
  }

  public RemoteServersIdBody2 s3CompatibleAccessKey(String s3CompatibleAccessKey) {
    this.s3CompatibleAccessKey = s3CompatibleAccessKey;
    return this;
  }

   /**
   * S3-compatible access key
   * @return s3CompatibleAccessKey
  **/
  @Schema(description = "S3-compatible access key")
  public String getS3CompatibleAccessKey() {
    return s3CompatibleAccessKey;
  }

  public void setS3CompatibleAccessKey(String s3CompatibleAccessKey) {
    this.s3CompatibleAccessKey = s3CompatibleAccessKey;
  }

  public RemoteServersIdBody2 s3CompatibleSecretKey(String s3CompatibleSecretKey) {
    this.s3CompatibleSecretKey = s3CompatibleSecretKey;
    return this;
  }

   /**
   * S3-compatible secret key
   * @return s3CompatibleSecretKey
  **/
  @Schema(description = "S3-compatible secret key")
  public String getS3CompatibleSecretKey() {
    return s3CompatibleSecretKey;
  }

  public void setS3CompatibleSecretKey(String s3CompatibleSecretKey) {
    this.s3CompatibleSecretKey = s3CompatibleSecretKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RemoteServersIdBody2 remoteServersIdBody2 = (RemoteServersIdBody2) o;
    return Objects.equals(this.awsAccessKey, remoteServersIdBody2.awsAccessKey) &&
        Objects.equals(this.awsSecretKey, remoteServersIdBody2.awsSecretKey) &&
        Objects.equals(this.password, remoteServersIdBody2.password) &&
        Objects.equals(this.privateKey, remoteServersIdBody2.privateKey) &&
        Objects.equals(this.sslCertificate, remoteServersIdBody2.sslCertificate) &&
        Objects.equals(this.googleCloudStorageCredentialsJson, remoteServersIdBody2.googleCloudStorageCredentialsJson) &&
        Objects.equals(this.wasabiAccessKey, remoteServersIdBody2.wasabiAccessKey) &&
        Objects.equals(this.wasabiSecretKey, remoteServersIdBody2.wasabiSecretKey) &&
        Objects.equals(this.backblazeB2KeyId, remoteServersIdBody2.backblazeB2KeyId) &&
        Objects.equals(this.backblazeB2ApplicationKey, remoteServersIdBody2.backblazeB2ApplicationKey) &&
        Objects.equals(this.rackspaceApiKey, remoteServersIdBody2.rackspaceApiKey) &&
        Objects.equals(this.resetAuthentication, remoteServersIdBody2.resetAuthentication) &&
        Objects.equals(this.azureBlobStorageAccessKey, remoteServersIdBody2.azureBlobStorageAccessKey) &&
        Objects.equals(this.hostname, remoteServersIdBody2.hostname) &&
        Objects.equals(this.name, remoteServersIdBody2.name) &&
        Objects.equals(this.maxConnections, remoteServersIdBody2.maxConnections) &&
        Objects.equals(this.port, remoteServersIdBody2.port) &&
        Objects.equals(this.s3Bucket, remoteServersIdBody2.s3Bucket) &&
        Objects.equals(this.s3Region, remoteServersIdBody2.s3Region) &&
        Objects.equals(this.serverCertificate, remoteServersIdBody2.serverCertificate) &&
        Objects.equals(this.serverHostKey, remoteServersIdBody2.serverHostKey) &&
        Objects.equals(this.serverType, remoteServersIdBody2.serverType) &&
        Objects.equals(this.ssl, remoteServersIdBody2.ssl) &&
        Objects.equals(this.username, remoteServersIdBody2.username) &&
        Objects.equals(this.googleCloudStorageBucket, remoteServersIdBody2.googleCloudStorageBucket) &&
        Objects.equals(this.googleCloudStorageProjectId, remoteServersIdBody2.googleCloudStorageProjectId) &&
        Objects.equals(this.backblazeB2Bucket, remoteServersIdBody2.backblazeB2Bucket) &&
        Objects.equals(this.backblazeB2S3Endpoint, remoteServersIdBody2.backblazeB2S3Endpoint) &&
        Objects.equals(this.wasabiBucket, remoteServersIdBody2.wasabiBucket) &&
        Objects.equals(this.wasabiRegion, remoteServersIdBody2.wasabiRegion) &&
        Objects.equals(this.rackspaceUsername, remoteServersIdBody2.rackspaceUsername) &&
        Objects.equals(this.rackspaceRegion, remoteServersIdBody2.rackspaceRegion) &&
        Objects.equals(this.rackspaceContainer, remoteServersIdBody2.rackspaceContainer) &&
        Objects.equals(this.oneDriveAccountType, remoteServersIdBody2.oneDriveAccountType) &&
        Objects.equals(this.azureBlobStorageAccount, remoteServersIdBody2.azureBlobStorageAccount) &&
        Objects.equals(this.azureBlobStorageContainer, remoteServersIdBody2.azureBlobStorageContainer) &&
        Objects.equals(this.s3CompatibleBucket, remoteServersIdBody2.s3CompatibleBucket) &&
        Objects.equals(this.s3CompatibleRegion, remoteServersIdBody2.s3CompatibleRegion) &&
        Objects.equals(this.s3CompatibleEndpoint, remoteServersIdBody2.s3CompatibleEndpoint) &&
        Objects.equals(this.s3CompatibleAccessKey, remoteServersIdBody2.s3CompatibleAccessKey) &&
        Objects.equals(this.s3CompatibleSecretKey, remoteServersIdBody2.s3CompatibleSecretKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(awsAccessKey, awsSecretKey, password, privateKey, sslCertificate, googleCloudStorageCredentialsJson, wasabiAccessKey, wasabiSecretKey, backblazeB2KeyId, backblazeB2ApplicationKey, rackspaceApiKey, resetAuthentication, azureBlobStorageAccessKey, hostname, name, maxConnections, port, s3Bucket, s3Region, serverCertificate, serverHostKey, serverType, ssl, username, googleCloudStorageBucket, googleCloudStorageProjectId, backblazeB2Bucket, backblazeB2S3Endpoint, wasabiBucket, wasabiRegion, rackspaceUsername, rackspaceRegion, rackspaceContainer, oneDriveAccountType, azureBlobStorageAccount, azureBlobStorageContainer, s3CompatibleBucket, s3CompatibleRegion, s3CompatibleEndpoint, s3CompatibleAccessKey, s3CompatibleSecretKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RemoteServersIdBody2 {\n");
    
    sb.append("    awsAccessKey: ").append(toIndentedString(awsAccessKey)).append("\n");
    sb.append("    awsSecretKey: ").append(toIndentedString(awsSecretKey)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    privateKey: ").append(toIndentedString(privateKey)).append("\n");
    sb.append("    sslCertificate: ").append(toIndentedString(sslCertificate)).append("\n");
    sb.append("    googleCloudStorageCredentialsJson: ").append(toIndentedString(googleCloudStorageCredentialsJson)).append("\n");
    sb.append("    wasabiAccessKey: ").append(toIndentedString(wasabiAccessKey)).append("\n");
    sb.append("    wasabiSecretKey: ").append(toIndentedString(wasabiSecretKey)).append("\n");
    sb.append("    backblazeB2KeyId: ").append(toIndentedString(backblazeB2KeyId)).append("\n");
    sb.append("    backblazeB2ApplicationKey: ").append(toIndentedString(backblazeB2ApplicationKey)).append("\n");
    sb.append("    rackspaceApiKey: ").append(toIndentedString(rackspaceApiKey)).append("\n");
    sb.append("    resetAuthentication: ").append(toIndentedString(resetAuthentication)).append("\n");
    sb.append("    azureBlobStorageAccessKey: ").append(toIndentedString(azureBlobStorageAccessKey)).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    maxConnections: ").append(toIndentedString(maxConnections)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    s3Bucket: ").append(toIndentedString(s3Bucket)).append("\n");
    sb.append("    s3Region: ").append(toIndentedString(s3Region)).append("\n");
    sb.append("    serverCertificate: ").append(toIndentedString(serverCertificate)).append("\n");
    sb.append("    serverHostKey: ").append(toIndentedString(serverHostKey)).append("\n");
    sb.append("    serverType: ").append(toIndentedString(serverType)).append("\n");
    sb.append("    ssl: ").append(toIndentedString(ssl)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    googleCloudStorageBucket: ").append(toIndentedString(googleCloudStorageBucket)).append("\n");
    sb.append("    googleCloudStorageProjectId: ").append(toIndentedString(googleCloudStorageProjectId)).append("\n");
    sb.append("    backblazeB2Bucket: ").append(toIndentedString(backblazeB2Bucket)).append("\n");
    sb.append("    backblazeB2S3Endpoint: ").append(toIndentedString(backblazeB2S3Endpoint)).append("\n");
    sb.append("    wasabiBucket: ").append(toIndentedString(wasabiBucket)).append("\n");
    sb.append("    wasabiRegion: ").append(toIndentedString(wasabiRegion)).append("\n");
    sb.append("    rackspaceUsername: ").append(toIndentedString(rackspaceUsername)).append("\n");
    sb.append("    rackspaceRegion: ").append(toIndentedString(rackspaceRegion)).append("\n");
    sb.append("    rackspaceContainer: ").append(toIndentedString(rackspaceContainer)).append("\n");
    sb.append("    oneDriveAccountType: ").append(toIndentedString(oneDriveAccountType)).append("\n");
    sb.append("    azureBlobStorageAccount: ").append(toIndentedString(azureBlobStorageAccount)).append("\n");
    sb.append("    azureBlobStorageContainer: ").append(toIndentedString(azureBlobStorageContainer)).append("\n");
    sb.append("    s3CompatibleBucket: ").append(toIndentedString(s3CompatibleBucket)).append("\n");
    sb.append("    s3CompatibleRegion: ").append(toIndentedString(s3CompatibleRegion)).append("\n");
    sb.append("    s3CompatibleEndpoint: ").append(toIndentedString(s3CompatibleEndpoint)).append("\n");
    sb.append("    s3CompatibleAccessKey: ").append(toIndentedString(s3CompatibleAccessKey)).append("\n");
    sb.append("    s3CompatibleSecretKey: ").append(toIndentedString(s3CompatibleSecretKey)).append("\n");
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
