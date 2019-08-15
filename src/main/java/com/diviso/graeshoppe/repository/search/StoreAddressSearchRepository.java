package com.diviso.graeshoppe.repository.search;

import com.diviso.graeshoppe.domain.search.*;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link ElStoreAddress} entity.
 */
public interface StoreAddressSearchRepository extends ElasticsearchRepository<ElStoreAddress, Long> {
}
