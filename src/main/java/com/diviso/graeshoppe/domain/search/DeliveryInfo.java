package com.diviso.graeshoppe.domain.search;
import com.diviso.graeshoppe.domain.Type;
import com.diviso.graeshoppe.domain.search.Store;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

import java.io.Serializable;
import java.util.*;

/**
 * A DeliveryInfo.
 */
@Document(indexName = "deliveryinfo")
public class DeliveryInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "starting_time")
    private Date startingTime;

    @Column(name = "end_time")
    private Date endTime;

    @ManyToOne
    @JsonIgnoreProperties("DeliveryInfos")
    private Store Store;

    @ManyToOne
    @JsonIgnoreProperties("DeliveryInfos")
    private Type Type;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public DeliveryInfo startingTime(Date startingTime) {
        this.startingTime = startingTime;
        return this;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public DeliveryInfo endTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

/*    public Store getStore() {
        return store;
    }

    public DeliveryInfo Store(Store store) {
        this.store = store;
        return this;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Type getType() {
        return type;
    }

    public DeliveryInfo Type(Type type) {
        this.type = type;
        return this;
    }

    public void setType(Type type) {
        this.type = type;
    }*/
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeliveryInfo)) {
            return false;
        }
        return id != null && id.equals(((DeliveryInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DeliveryInfo{" +
            "id=" + getId() +
            ", startingTime='" + getStartingTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            "}";
    }
}
