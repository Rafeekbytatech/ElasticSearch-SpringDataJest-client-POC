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
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.*;

import io.searchbox.client.JestClient;
import io.searchbox.core.SearchResult;
import io.searchbox.core.search.aggregation.TermsAggregation;
import io.searchbox.core.search.aggregation.TermsAggregation.*;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.slf4j.Logger;

import com.diviso.graeshoppe.domain.HeaderSearch;
import com.diviso.graeshoppe.domain.StoreType;
//import com.diviso.graeshoppe.domain.Store;
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

	@Autowired
	ElasticsearchOperations elasticsearchOperations;
	
	public List<Entry> getStoreByRegAggregation(Pageable pageable) {
		List<String> carList = new ArrayList<String>();
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery())
				
				.addAggregation(AggregationBuilders.terms("regsss").field("regNo.keyword")).build();
//		log.info(searchQuery.toString() + "*********************************************************");

		AggregatedPage<Store> result = elasticsearchTemplate.queryForPage(searchQuery, Store.class);
		TermsAggregation colourtAgg = result.getAggregation("regsss", TermsAggregation.class);
		return colourtAgg.getBuckets();

	}
	
	
	public Page<Store> headerSearch(String searchTerm, Pageable pageable) {
		System.out.println("************Storestart*****************");
		Set<Store> storeSet = new HashSet<Store>();
		Set<HeaderSearch> values = new HashSet<HeaderSearch>();

		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("name", searchTerm)).build();

		elasticsearchTemplate.query(searchQuery, new JestResultsExtractor<Set<HeaderSearch>>() {

			@Override
			public Set<HeaderSearch> extract(SearchResult response) {

				for (SearchResult.Hit<JsonObject, Void> searchHit : response.getHits(JsonObject.class)) {
					HeaderSearch result = new HeaderSearch();
					System.out.println("************Storesloop*****************");
					if (searchHit.index.equals("store")) {
						result.setStoreNo(searchHit.source.get("regNo").getAsString());
						System.out.println("************Store*****************" + result.getStoreNo());
					} else {
						result.setStoreNo(searchHit.source.get("iDPcode").getAsString());
						System.out.println("************Store########################" + result.getStoreNo());
					}

					values.add(result);

				}
				return values;
			}
		});

		for (HeaderSearch r : values) {
			StringQuery stringQuery = new StringQuery(termQuery("regNo.keyword", r.getStoreNo()).toString());
			storeSet.add(elasticsearchOperations.queryForObject(stringQuery, Store.class));
		}
		List<Store> storeList = new ArrayList<>();
		storeList.addAll(storeSet);

		return new PageImpl(storeList);

	}


	@Override
	public Page<Store> facetSearch(List<String> searchTerm, Pageable pageable) {
		System.out.println("************ENTRRRRRRRRStore###############");
		Set<Store> storeSet = new HashSet<>();
		  FetchSourceFilterBuilder sourceFilter = new FetchSourceFilterBuilder();
		 sourceFilter.withExcludes("storetype", "storesettings","storeaddress");
		  
		  SearchQuery searchQuery = new NativeSearchQueryBuilder()
		  .withQuery(QueryBuilders.termQuery("name.keyword","arabi" ))
		  .withIndices("storetype").withTypes("storetype").withSourceFilter(
		  sourceFilter.build()).build();
		  
		  List<StoreType> storeTypeList =
		  elasticsearchOperations.queryForList(searchQuery, StoreType.class);
		  System.out.println("************Store###########"+storeTypeList.size());
		  for(StoreType storeType : storeTypeList)
		  {
				System.out.println("************Store###############"+storeType);
	      convertToElasticStore(storeType.getStore());
		  storeSet.add(convertToElasticStore(storeType.getStore()));
		  } 
		  return new PageImpl(new ArrayList<Store>(storeSet));
		
	}
	public Store convertToElasticStore( com.diviso.graeshoppe.domain.Store store) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!entering storedetails"+store);
		com.diviso.graeshoppe.domain.search.Store elStore=new com.diviso.graeshoppe.domain.search.Store();

		elStore.setId(store.getId());

		elStore.setRegNo(store.getRegNo());

		elStore.setName(store.getName());

		elStore.setImage(store.getImage());

		elStore.setImageContentType(store.getImageContentType());

		elStore.setTotalRating(store.getTotalRating());

		elStore.setLocation(store.getLocation());

		elStore.setLocationName(store.getLocationName());

		elStore.setContactNo(store.getContactNo());

		elStore.setOpeningTime(Date.from(store.getOpeningTime()));

		elStore.setEmail(store.getEmail());

		elStore.setClosingTime(Date.from(store.getClosingTime()));

		elStore.setInfo(store.getInfo());

		elStore.setMinAmount(store.getMinAmount());

		elStore.setMaxDeliveryTime(Date.from(store.getMaxDeliveryTime()));
		elStore.setPropreitor(store.getPropreitor());
		elStore.setStoreAddress(store.getStoreAddress());
		elStore.setStoreSettings(store.getStoreSettings());
		
	return elStore;
	}
}
