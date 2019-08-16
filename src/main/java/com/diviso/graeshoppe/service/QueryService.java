package com.diviso.graeshoppe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diviso.graeshoppe.domain.Store;

import io.searchbox.core.search.aggregation.TermsAggregation.Entry;

import java.util.*;

public interface QueryService {
	public List<Entry> getStoreByRegAggregation(Pageable pageable) ;
	public Page<Store> headerSearch(String searchTerm, Pageable pageable) ;
}