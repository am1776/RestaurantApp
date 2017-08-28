package com.amallya.doordash.takehome.model;
/**
 * Created by anmallya on 8/26/2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PopularItem implements Serializable{

    @SerializedName("img_url")
    @Expose
    private String imgUrl;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
