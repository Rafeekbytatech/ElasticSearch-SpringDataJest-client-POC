package com.diviso.graeshoppe.domain.search;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A ElStoreSettings.
 */
@Document(indexName = "elstoresettings")
public class ElStoreSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_charge")
    private Double deliveryCharge;

    @Column(name = "service_charge")
    private Double serviceCharge;

    @Column(name = "order_accept_type")
    private String orderAcceptType;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDeliveryCharge() {
        return deliveryCharge;
    }

    public ElStoreSettings deliveryCharge(Double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
        return this;
    }

    public void setDeliveryCharge(Double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public ElStoreSettings serviceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
        return this;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getOrderAcceptType() {
        return orderAcceptType;
    }

    public ElStoreSettings orderAcceptType(String orderAcceptType) {
        this.orderAcceptType = orderAcceptType;
        return this;
    }

    public void setOrderAcceptType(String orderAcceptType) {
        this.orderAcceptType = orderAcceptType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ElStoreSettings)) {
            return false;
        }
        return id != null && id.equals(((ElStoreSettings) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ElStoreSettings{" +
            "id=" + getId() +
            ", deliveryCharge=" + getDeliveryCharge() +
            ", serviceCharge=" + getServiceCharge() +
            ", orderAcceptType='" + getOrderAcceptType() + "'" +
            "}";
    }
}
