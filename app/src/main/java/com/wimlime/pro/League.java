package com.wimlime.pro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class League {


    @SerializedName("id")
    @Expose
    String id;

    @SerializedName("name")
    @Expose
    String name;

    public String getId() {
        return id;
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
}
