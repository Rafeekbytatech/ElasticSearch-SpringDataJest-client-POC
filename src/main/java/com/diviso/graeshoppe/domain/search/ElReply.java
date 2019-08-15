/*package com.diviso.graeshoppe.domain.search;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

*//**
 * A ElReply.
 *//*
@Document(indexName = "elreply")
public class ElReply implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "reply")
    private String reply;

    @Column(name = "replied_date")
    private ZonedDateTime repliedDate;

    @ManyToOne
    @JsonIgnoreProperties("elReplies")
    private ElReview elReview;

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

    public ElReply userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReply() {
        return reply;
    }

    public ElReply reply(String reply) {
        this.reply = reply;
        return this;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public ZonedDateTime getRepliedDate() {
        return repliedDate;
    }

    public ElReply repliedDate(ZonedDateTime repliedDate) {
        this.repliedDate = repliedDate;
        return this;
    }

    public void setRepliedDate(ZonedDateTime repliedDate) {
        this.repliedDate = repliedDate;
    }

    public ElReview getElReview() {
        return elReview;
    }

    public ElReply elReview(ElReview elReview) {
        this.elReview = elReview;
        return this;
    }

    public void setElReview(ElReview elReview) {
        this.elReview = elReview;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ElReply)) {
            return false;
        }
        return id != null && id.equals(((ElReply) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ElReply{" +
            "id=" + getId() +
            ", userName='" + getUserName() + "'" +
            ", reply='" + getReply() + "'" +
            ", repliedDate='" + getRepliedDate() + "'" +
            "}";
    }
}
*/