package com.diviso.graeshoppe.service.impl;
import com.diviso.graeshoppe.service.*;
import com.github.vanroy.springdata.jest.JestElasticsearchTemplate;
import com.github.vanroy.springdata.jest.aggregation.AggregatedPage;
import com.github.vanroy.springdata.jest.mapper.JestResultsExtractor;
import com.github.vanroy.springdata.jest.mapper.JestSearchResultMapper;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.ScriptField;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.elasticsearch.index.query.QueryBuilders.*;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.*;

import io.searchbox.client.JestClient;
import io.searchbox.core.search.aggregation.TermsAggregation;
import io.searchbox.core.search.aggregation.TermsAggregation.*;

import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.slf4j.Logger;
import com.diviso.graeshoppe.domain.search.*;

@Service
@Transactional
public class QueryServiceImpl implements QueryService {
	private final JestClient jestClient;
	private final JestElasticsearchTemplate elasticsearchTemplate;

	public QueryServiceImpl(JestClient jestClient) {
		this.jestClient = jestClient;
		this.elasticsearchTemplate = new JestElasticsearchTemplate(this.jestClient);
	}

	public List<Entry> getStoreByRegAggregation(Pageable pageable) {
		List<String> carList = new ArrayList<String>();
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery())
				
				.addAggregation(AggregationBuilders.terms("regsss").field("regNo.keyword")).build();
//		log.info(searchQuery.toString() + "*********************************************************");

		AggregatedPage<Store> result = elasticsearchTemplate.queryForPage(searchQuery, Store.class);
		TermsAggregation colourtAgg = result.getAggregation("regsss", TermsAggregation.class);
		return colourtAgg.getBuckets();

	}
}
