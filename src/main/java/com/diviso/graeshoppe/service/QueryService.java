package com.diviso.graeshoppe.service;

import org.springframework.data.domain.Pageable;

import io.searchbox.core.search.aggregation.TermsAggregation.Entry;

import java.util.*;

public interface QueryService {
	public List<Entry> getStoreByRegAggregation(Pageable pageable) ;
}