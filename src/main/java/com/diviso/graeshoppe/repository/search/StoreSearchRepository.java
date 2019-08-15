package com.diviso.graeshoppe.repository.search;

import com.diviso.graeshoppe.domain.*;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link ElStore} entity.
 */
public interface StoreSearchRepository extends ElasticsearchRepository<Store, Long> {
}
