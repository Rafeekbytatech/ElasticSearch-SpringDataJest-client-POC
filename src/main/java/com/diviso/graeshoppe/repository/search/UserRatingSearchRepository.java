package com.diviso.graeshoppe.repository.search;

import com.diviso.graeshoppe.domain.*;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link ElUserRating} entity.
 */
public interface UserRatingSearchRepository extends ElasticsearchRepository<UserRating, Long> {
}
