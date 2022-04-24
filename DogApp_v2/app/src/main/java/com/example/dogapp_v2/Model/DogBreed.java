package com.example.dogapp_v2.Model;

import com.google.gson.annotations.SerializedName;

public class DogBreed {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("origin")
    private String origin;

    @SerializedName("url")
    private String url;

    public String getId() {
        return id;
    }

    public DogBreed(String id, String name, String origin, String url) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.url = url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
