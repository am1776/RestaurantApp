package com.amallya.doordash.takehome.model;

/**
 * Created by anmallya on 8/26/2017.
 */

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu implements Serializable {

    @SerializedName("popular_items")
    @Expose
    private List<PopularItem> popularItems = null;
    @SerializedName("is_catering")
    @Expose
    private Boolean isCatering;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    public List<PopularItem> getPopularItems() {
        return popularItems;
    }

    public void setPopularItems(List<PopularItem> popularItems) {
        this.popularItems = popularItems;
    }

    public Boolean getIsCatering() {
        return isCatering;
    }

    public void setIsCatering(Boolean isCatering) {
        this.isCatering = isCatering;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
