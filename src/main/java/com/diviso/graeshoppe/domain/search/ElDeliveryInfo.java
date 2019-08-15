/*package com.diviso.graeshoppe.domain.search;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

*//**
 * A ElDeliveryInfo.
 *//*
@Document(indexName = "eldeliveryinfo")
public class ElDeliveryInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "starting_time")
    private Instant startingTime;

    @Column(name = "end_time")
    private Instant endTime;

    @ManyToOne
    @JsonIgnoreProperties("elDeliveryInfos")
    private ElStore elStore;

    @ManyToOne
    @JsonIgnoreProperties("elDeliveryInfos")
    private ElType elType;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartingTime() {
        return startingTime;
    }

    public ElDeliveryInfo startingTime(Instant startingTime) {
        this.startingTime = startingTime;
        return this;
    }

    public void setStartingTime(Instant startingTime) {
        this.startingTime = startingTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public ElDeliveryInfo endTime(Instant endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public ElStore getElStore() {
        return elStore;
    }

    public ElDeliveryInfo elStore(ElStore elStore) {
        this.elStore = elStore;
        return this;
    }

    public void setElStore(ElStore elStore) {
        this.elStore = elStore;
    }

    public ElType getElType() {
        return elType;
    }

    public ElDeliveryInfo elType(ElType elType) {
        this.elType = elType;
        return this;
    }

    public void setElType(ElType elType) {
        this.elType = elType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ElDeliveryInfo)) {
            return false;
        }
        return id != null && id.equals(((ElDeliveryInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ElDeliveryInfo{" +
            "id=" + getId() +
            ", startingTime='" + getStartingTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            "}";
    }
}
*/