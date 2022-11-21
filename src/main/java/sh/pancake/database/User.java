package sh.pancake.database;

import java.sql.Timestamp;

public class User {
    private long id;
    private String primaryEmail;
    private String credential;
    private Timestamp verifiedAt;
    private Timestamp updatedAt;
    private Timestamp createdAt;
    private String profileName;
    private String profileImageUrl;
    private long permission;

    public User() {
    }

    public User(int id, String primaryEmail, String credential, Timestamp verifiedAt, Timestamp updatedAt,
            Timestamp createdAt,
            String profileName, String profileImageUrl, long permission) {
        this.id = id;
        this.primaryEmail = primaryEmail;
        this.credential = credential;
        this.verifiedAt = verifiedAt;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.profileName = profileName;
        this.profileImageUrl = profileImageUrl;
        this.permission = permission;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public Timestamp getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(Timestamp verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public long getPermission() {
        return permission;
    }

    public void setPermission(long permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", primaryEmail=" + primaryEmail + ", credential=" + credential + ", verifiedAt="
                + verifiedAt + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + ", profileName=" + profileName
                + ", profileImageUrl=" + profileImageUrl + ", permission=" + permission + "]";
    }
}
