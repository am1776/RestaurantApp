package com.amallya.doordash.takehome.model;

/**
 * Created by anmallya on 8/26/2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MerchantPromotion implements Serializable{

    @SerializedName("new_store_customers_only")
    @Expose
    private Boolean newStoreCustomersOnly;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("delivery_fee")
    @Expose
    private Integer deliveryFee;

    public Boolean getNewStoreCustomersOnly() {
        return newStoreCustomersOnly;
    }

    public void setNewStoreCustomersOnly(Boolean newStoreCustomersOnly) {
        this.newStoreCustomersOnly = newStoreCustomersOnly;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Integer deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

}
