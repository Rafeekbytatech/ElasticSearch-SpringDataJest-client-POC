package com.diviso.graeshoppe.repository.search;

import com.diviso.graeshoppe.domain.*;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link ElReview} entity.
 */
public interface ReviewSearchRepository extends ElasticsearchRepository<Review, Long> {
}
