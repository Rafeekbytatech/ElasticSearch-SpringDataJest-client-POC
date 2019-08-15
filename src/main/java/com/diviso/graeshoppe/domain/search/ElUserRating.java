/*package com.diviso.graeshoppe.domain.search;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

*//**
 * A ElUserRating.
 *//*
@Document(indexName = "eluserrating")
public class ElUserRating implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "rated_on")
    private ZonedDateTime ratedOn;

    @ManyToOne
    @JsonIgnoreProperties("elUserRatings")
    private ElStore elStore;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public ElUserRating userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getRating() {
        return rating;
    }

    public ElUserRating rating(Double rating) {
        this.rating = rating;
        return this;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ZonedDateTime getRatedOn() {
        return ratedOn;
    }

    public ElUserRating ratedOn(ZonedDateTime ratedOn) {
        this.ratedOn = ratedOn;
        return this;
    }

    public void setRatedOn(ZonedDateTime ratedOn) {
        this.ratedOn = ratedOn;
    }

    public ElStore getElStore() {
        return elStore;
    }

    public ElUserRating elStore(ElStore elStore) {
        this.elStore = elStore;
        return this;
    }

    public void setElStore(ElStore elStore) {
        this.elStore = elStore;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ElUserRating)) {
            return false;
        }
        return id != null && id.equals(((ElUserRating) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ElUserRating{" +
            "id=" + getId() +
            ", userName='" + getUserName() + "'" +
            ", rating=" + getRating() +
            ", ratedOn='" + getRatedOn() + "'" +
            "}";
    }
}
*/