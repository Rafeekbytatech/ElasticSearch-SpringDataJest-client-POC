package com.diviso.graeshoppe.domain.search;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

import javax.persistence.*;
import com.diviso.graeshoppe.domain.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.*;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

/**
 * A Store.
 */
@Document(indexName = "store")
@Setting(settingPath = "settings/storesettings.json")
@Mapping(mappingPath = "mappings/storemappings.json")
public class Store implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "reg_no")
	private String regNo;

	@Column(name = "name")
	private String name;

	@Lob
	@Column(name = "image")
	private byte[] image;

	@Column(name = "image_content_type")
	private String imageContentType;

	@Column(name = "total_rating")
	private Double totalRating;
	@GeoPointField
	@Column(name = "location")
	private String location;

	@Column(name = "location_name")
	private String locationName;

	@Column(name = "contact_no")
	private Long contactNo;

	@Column(name = "opening_time")
	private Date openingTime;

	@Column(name = "email")
	private String email;

	@Column(name = "closing_time")
	private Date closingTime;

	@Column(name = "info")
	private String info;

	@Column(name = "min_amount")
	private Double minAmount;

	@Column(name = "max_delivery_time")
	private Date maxDeliveryTime;

	@OneToOne
	@JoinColumn(unique = true)
	private Propreitor Propreitor;

	@OneToOne
	@JoinColumn(unique = true)
	private StoreAddress StoreAddress;

	@OneToOne
	@JoinColumn(unique = true)
	private StoreSettings StoreSettings;

	@OneToMany(mappedBy = "store")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<StoreType> StoreTypes = new HashSet<>();

	@OneToMany(mappedBy = "store")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Review> Reviews = new HashSet<>();

	@OneToMany(mappedBy = "store")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<UserRating> UserRatings = new HashSet<>();

	@OneToMany(mappedBy = "store")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Banner> Banners = new HashSet<>();

	@OneToMany(mappedBy = "store")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<DeliveryInfo> DeliveryInfos = new HashSet<>();

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegNo() {
		return regNo;
	}

	public Store regNo(String regNo) {
		this.regNo = regNo;
		return this;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getName() {
		return name;
	}

	public Store name(String name) {
		this.name = name;
		return this;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public Store image(byte[] image) {
		this.image = image;
		return this;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public Store imageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
		return this;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public Double getTotalRating() {
		return totalRating;
	}

	public Store totalRating(Double totalRating) {
		this.totalRating = totalRating;
		return this;
	}

	public void setTotalRating(Double totalRating) {
		this.totalRating = totalRating;
	}

	public String getLocation() {
		return location;
	}

	public Store location(String location) {
		this.location = location;
		return this;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationName() {
		return locationName;
	}

	public Store locationName(String locationName) {
		this.locationName = locationName;
		return this;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public Store contactNo(Long contactNo) {
		this.contactNo = contactNo;
		return this;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public Date getOpeningTime() {
		return openingTime;
	}

	public Store openingTime(Date openingTime) {
		this.openingTime = openingTime;
		return this;
	}

	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}

	public String getEmail() {
		return email;
	}

	public Store email(String email) {
		this.email = email;
		return this;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getClosingTime() {
		return closingTime;
	}

	public Store closingTime(Date closingTime) {
		this.closingTime = closingTime;
		return this;
	}

	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}

	public String getInfo() {
		return info;
	}

	public Store info(String info) {
		this.info = info;
		return this;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Double getMinAmount() {
		return minAmount;
	}

	public Store minAmount(Double minAmount) {
		this.minAmount = minAmount;
		return this;
	}

	public void setMinAmount(Double minAmount) {
		this.minAmount = minAmount;
	}

	public Date getMaxDeliveryTime() {
		return maxDeliveryTime;
	}

	public Store maxDeliveryTime(Date maxDeliveryTime) {
		this.maxDeliveryTime = maxDeliveryTime;
		return this;
	}

	public void setMaxDeliveryTime(Date maxDeliveryTime) {
		this.maxDeliveryTime = maxDeliveryTime;
	}

	public Propreitor getPropreitor() {
		return Propreitor;
	}

	public Store Propreitor(Propreitor Propreitor) {
		this.Propreitor = Propreitor;
		return this;
	}

	public void setPropreitor(Propreitor Propreitor) {
		this.Propreitor = Propreitor;
	}

	public StoreAddress getStoreAddress() {
		return StoreAddress;
	}

	public Store StoreAddress(StoreAddress StoreAddress) {
		this.StoreAddress = StoreAddress;
		return this;
	}

	public void setStoreAddress(StoreAddress StoreAddress) {
		this.StoreAddress = StoreAddress;
	}

	public StoreSettings getStoreSettings() {
		return StoreSettings;
	}

	public Store StoreSettings(StoreSettings StoreSettings) {
		this.StoreSettings = StoreSettings;
		return this;
	}

	public void setStoreSettings(StoreSettings StoreSettings) {
		this.StoreSettings = StoreSettings;
	}

	public Set<StoreType> getStoreTypes() {
		return StoreTypes;
	}

	public Store StoreTypes(Set<StoreType> StoreTypes) {
		this.StoreTypes = StoreTypes;
		return this;
	}

	/*
	 * public Store addStoreType( StoreType StoreType) { this. StoreTypes.add(
	 * StoreType); StoreType.setStore(this); return this; }
	 * 
	 * public Store removeStoreType( StoreType StoreType) { this. StoreTypes.remove(
	 * StoreType); StoreType.setStore(null); return this; }
	 */

	public void setStoreTypes(Set<StoreType> StoreTypes) {
		this.StoreTypes = StoreTypes;
	}

	public Set<Review> getReviews() {
		return Reviews;
	}

	public Store Reviews(Set<Review> Reviews) {
		this.Reviews = Reviews;
		return this;
	}

	/*
	 * public Store addReview( Review Review) { this. Reviews.add( Review);
	 * Review.setStore(this); return this; }
	 * 
	 * public Store removeReview( Review Review) { this. Reviews.remove( Review);
	 * Review.setStore(null); return this; }
	 */

	public void setReviews(Set<Review> Reviews) {
		this.Reviews = Reviews;
	}

	public Set<UserRating> getUserRatings() {
		return UserRatings;
	}

	public Store UserRatings(Set<UserRating> UserRatings) {
		this.UserRatings = UserRatings;
		return this;
	}

	/*
	 * public Store addUserRating( UserRating UserRating) { this. UserRatings.add(
	 * UserRating); UserRating.setStore(this); return this; }
	 * 
	 * public Store removeUserRating( UserRating UserRating) { this.
	 * UserRatings.remove( UserRating); UserRating.setStore(null); return this; }
	 */
	public void setUserRatings(Set<UserRating> UserRatings) {
		this.UserRatings = UserRatings;
	}

	public Set<Banner> getBanners() {
		return Banners;
	}

	public Store Banners(Set<Banner> Banners) {
		this.Banners = Banners;
		return this;
	}

	/*
	 * public Store addBanner( Banner Banner) { this. Banners.add( Banner);
	 * Banner.setStore(this); return this; }
	 * 
	 * public Store removeBanner( Banner Banner) { this. Banners.remove( Banner);
	 * Banner.setStore(null); return this; }
	 */

	public void setBanners(Set<Banner> Banners) {
		this.Banners = Banners;
	}

	public Set<DeliveryInfo> getDeliveryInfos() {
		return DeliveryInfos;
	}

	/*
	 * public Store DeliveryInfos(Set< DeliveryInfo> deliveryInfos) {
	 * this.deliveryInfos = deliveryInfos; return this; }
	 */

	/*
	 * public Store addDeliveryInfo(DeliveryInfo DeliveryInfo) {
	 * this.DeliveryInfos.add(DeliveryInfo); deliveryInfo.setElStore(this); return
	 * this; }
	 * 
	 * public Store removeDeliveryInfo(DeliveryInfo DeliveryInfo) {
	 * this.DeliveryInfos.remove(elDeliveryInfo); elDeliveryInfo.setElStore(null);
	 * return this; }
	 */

	/*
	 * public void setElDeliveryInfos(Set<DeliveryInfo> deliveryInfos) {
	 * this.deliveryInfos = deliveryInfos; }
	 */
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Store)) {
			return false;
		}
		return id != null && id.equals(((Store) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "Store{" + "id=" + getId() + ", regNo='" + getRegNo() + "'" + ", name='" + getName() + "'" + ", image='"
				+ getImage() + "'" + ", imageContentType='" + getImageContentType() + "'" + ", totalRating="
				+ getTotalRating() + ", location='" + getLocation() + "'" + ", locationName='" + getLocationName() + "'"
				+ ", contactNo=" + getContactNo() + ", openingTime='" + getOpeningTime() + "'" + ", email='"
				+ getEmail() + "'" + ", closingTime='" + getClosingTime() + "'" + ", info='" + getInfo() + "'"
				+ ", minAmount=" + getMinAmount() + ", maxDeliveryTime='" + getMaxDeliveryTime() + "'" + "}";
	}
}
