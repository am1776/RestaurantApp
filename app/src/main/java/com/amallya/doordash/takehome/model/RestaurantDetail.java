package com.amallya.doordash.takehome.model;

/**
 * Created by anmallya on 8/26/2017.
 */



import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantDetail {

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("yelp_review_count")
    @Expose
    private Integer yelpReviewCount;
    @SerializedName("max_order_size")
    @Expose
    private Object maxOrderSize;
    @SerializedName("delivery_fee")
    @Expose
    private Integer deliveryFee;
    @SerializedName("max_composite_score")
    @Expose
    private Integer maxCompositeScore;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("average_rating")
    @Expose
    private Double averageRating;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("delivery_radius")
    @Expose
    private Integer deliveryRadius;
    @SerializedName("inflation_rate")
    @Expose
    private Double inflationRate;
    @SerializedName("menus")
    @Expose
    private List<Menu> menus = null;
    @SerializedName("show_store_menu_header_photo")
    @Expose
    private Boolean showStoreMenuHeaderPhoto;
    @SerializedName("composite_score")
    @Expose
    private Integer compositeScore;
    @SerializedName("number_of_ratings")
    @Expose
    private Integer numberOfRatings;
    @SerializedName("status_type")
    @Expose
    private String statusType;
    @SerializedName("is_only_catering")
    @Expose
    private Boolean isOnlyCatering;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("object_type")
    @Expose
    private String objectType;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("business")
    @Expose
    private Business business;
    @SerializedName("yelp_biz_id")
    @Expose
    private String yelpBizId;
    @SerializedName("asap_time")
    @Expose
    private Integer asapTime;
    @SerializedName("yelp_rating")
    @Expose
    private Double yelpRating;
    @SerializedName("extra_sos_delivery_fee")
    @Expose
    private Integer extraSosDeliveryFee;
    @SerializedName("business_id")
    @Expose
    private Integer businessId;
    @SerializedName("special_instructions_max_length")
    @Expose
    private Object specialInstructionsMaxLength;
    @SerializedName("cover_img_url")
    @Expose
    private String coverImgUrl;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("price_range")
    @Expose
    private Integer priceRange;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("show_suggested_items")
    @Expose
    private Boolean showSuggestedItems;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_newly_added")
    @Expose
    private Boolean isNewlyAdded;
    @SerializedName("is_good_for_group_orders")
    @Expose
    private Boolean isGoodForGroupOrders;
    @SerializedName("service_rate")
    @Expose
    private Double serviceRate;
    @SerializedName("merchant_promotions")
    @Expose
    private List<MerchantPromotion> merchantPromotions = null;
    @SerializedName("header_image_url")
    @Expose
    private Object headerImageUrl;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getYelpReviewCount() {
        return yelpReviewCount;
    }

    public void setYelpReviewCount(Integer yelpReviewCount) {
        this.yelpReviewCount = yelpReviewCount;
    }

    public Object getMaxOrderSize() {
        return maxOrderSize;
    }

    public void setMaxOrderSize(Object maxOrderSize) {
        this.maxOrderSize = maxOrderSize;
    }

    public Integer getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Integer deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Integer getMaxCompositeScore() {
        return maxCompositeScore;
    }

    public void setMaxCompositeScore(Integer maxCompositeScore) {
        this.maxCompositeScore = maxCompositeScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getDeliveryRadius() {
        return deliveryRadius;
    }

    public void setDeliveryRadius(Integer deliveryRadius) {
        this.deliveryRadius = deliveryRadius;
    }

    public Double getInflationRate() {
        return inflationRate;
    }

    public void setInflationRate(Double inflationRate) {
        this.inflationRate = inflationRate;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Boolean getShowStoreMenuHeaderPhoto() {
        return showStoreMenuHeaderPhoto;
    }

    public void setShowStoreMenuHeaderPhoto(Boolean showStoreMenuHeaderPhoto) {
        this.showStoreMenuHeaderPhoto = showStoreMenuHeaderPhoto;
    }

    public Integer getCompositeScore() {
        return compositeScore;
    }

    public void setCompositeScore(Integer compositeScore) {
        this.compositeScore = compositeScore;
    }

    public Integer getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(Integer numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public Boolean getIsOnlyCatering() {
        return isOnlyCatering;
    }

    public void setIsOnlyCatering(Boolean isOnlyCatering) {
        this.isOnlyCatering = isOnlyCatering;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getYelpBizId() {
        return yelpBizId;
    }

    public void setYelpBizId(String yelpBizId) {
        this.yelpBizId = yelpBizId;
    }

    public Integer getAsapTime() {
        return asapTime;
    }

    public void setAsapTime(Integer asapTime) {
        this.asapTime = asapTime;
    }

    public Double getYelpRating() {
        return yelpRating;
    }

    public void setYelpRating(Double yelpRating) {
        this.yelpRating = yelpRating;
    }

    public Integer getExtraSosDeliveryFee() {
        return extraSosDeliveryFee;
    }

    public void setExtraSosDeliveryFee(Integer extraSosDeliveryFee) {
        this.extraSosDeliveryFee = extraSosDeliveryFee;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Object getSpecialInstructionsMaxLength() {
        return specialInstructionsMaxLength;
    }

    public void setSpecialInstructionsMaxLength(Object specialInstructionsMaxLength) {
        this.specialInstructionsMaxLength = specialInstructionsMaxLength;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getShowSuggestedItems() {
        return showSuggestedItems;
    }

    public void setShowSuggestedItems(Boolean showSuggestedItems) {
        this.showSuggestedItems = showSuggestedItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsNewlyAdded() {
        return isNewlyAdded;
    }

    public void setIsNewlyAdded(Boolean isNewlyAdded) {
        this.isNewlyAdded = isNewlyAdded;
    }

    public Boolean getIsGoodForGroupOrders() {
        return isGoodForGroupOrders;
    }

    public void setIsGoodForGroupOrders(Boolean isGoodForGroupOrders) {
        this.isGoodForGroupOrders = isGoodForGroupOrders;
    }

    public Double getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(Double serviceRate) {
        this.serviceRate = serviceRate;
    }

    public List<MerchantPromotion> getMerchantPromotions() {
        return merchantPromotions;
    }

    public void setMerchantPromotions(List<MerchantPromotion> merchantPromotions) {
        this.merchantPromotions = merchantPromotions;
    }

    public Object getHeaderImageUrl() {
        return headerImageUrl;
    }

    public void setHeaderImageUrl(Object headerImageUrl) {
        this.headerImageUrl = headerImageUrl;
    }

}
