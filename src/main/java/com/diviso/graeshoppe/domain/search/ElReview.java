/*package com.diviso.graeshoppe.domain.search;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

*//**
 * A ElReview.
 *//*
@Document(indexName = "elreview")
public class ElReview implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "review")
    private String review;

    @Column(name = "reviewed_date")
    private ZonedDateTime reviewedDate;

    @ManyToOne
    @JsonIgnoreProperties("elReviews")
    private ElStore elStore;

    @OneToMany(mappedBy = "elReview")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ElReply> elReplies = new HashSet<>();

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

    public ElReview userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReview() {
        return review;
    }

    public ElReview review(String review) {
        this.review = review;
        return this;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public ZonedDateTime getReviewedDate() {
        return reviewedDate;
    }

    public ElReview reviewedDate(ZonedDateTime reviewedDate) {
        this.reviewedDate = reviewedDate;
        return this;
    }

    public void setReviewedDate(ZonedDateTime reviewedDate) {
        this.reviewedDate = reviewedDate;
    }

    public ElStore getElStore() {
        return elStore;
    }

    public ElReview elStore(ElStore elStore) {
        this.elStore = elStore;
        return this;
    }

    public void setElStore(ElStore elStore) {
        this.elStore = elStore;
    }

    public Set<ElReply> getElReplies() {
        return elReplies;
    }

    public ElReview elReplies(Set<ElReply> elReplies) {
        this.elReplies = elReplies;
        return this;
    }

    public ElReview addElReply(ElReply elReply) {
        this.elReplies.add(elReply);
        elReply.setElReview(this);
        return this;
    }

    public ElReview removeElReply(ElReply elReply) {
        this.elReplies.remove(elReply);
        elReply.setElReview(null);
        return this;
    }

    public void setElReplies(Set<ElReply> elReplies) {
        this.elReplies = elReplies;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ElReview)) {
            return false;
        }
        return id != null && id.equals(((ElReview) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ElReview{" +
            "id=" + getId() +
            ", userName='" + getUserName() + "'" +
            ", review='" + getReview() + "'" +
            ", reviewedDate='" + getReviewedDate() + "'" +
            "}";
    }
}
*/