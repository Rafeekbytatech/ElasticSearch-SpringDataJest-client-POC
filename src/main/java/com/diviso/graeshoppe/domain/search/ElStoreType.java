/*package com.diviso.graeshoppe.domain.search;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

import java.io.Serializable;

*//**
 * A ElStoreType.
 *//*
@Document(indexName = "elstoretype")
public class ElStoreType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JsonIgnoreProperties("elStoreTypes")
    private ElStore elStore;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ElStoreType name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ElStore getElStore() {
        return elStore;
    }

    public ElStoreType elStore(ElStore elStore) {
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
        if (!(o instanceof ElStoreType)) {
            return false;
        }
        return id != null && id.equals(((ElStoreType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ElStoreType{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
*/