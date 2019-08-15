package com.diviso.graeshoppe.repository.search;

import com.diviso.graeshoppe.domain.*;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link ElReply} entity.
 */
public interface ReplySearchRepository extends ElasticsearchRepository<Reply, Long> {
}
