package ar.com.wolox.android.example.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id") private Integer id;
    @SerializedName("username") private String username;
    @SerializedName("email") private String email;
    @SerializedName("password") private String password;
    @SerializedName("picture") private String picture;
    @SerializedName("cover") private String cover;
    @SerializedName("description") private String description;
    @SerializedName("location") private String location;
    @SerializedName("name") private String name;
    @SerializedName("phone") private String phone;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(@NonNull String picture) {
        this.picture = picture;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(@NonNull String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(@NonNull String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }
}