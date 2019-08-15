package com.diviso.graeshoppe.repository.search;

import com.diviso.graeshoppe.domain.*;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link ElStoreType} entity.
 */
public interface StoreTypeSearchRepository extends ElasticsearchRepository<StoreType, Long> {
}
