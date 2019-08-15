package com.diviso.graeshoppe.service.impl;

import com.diviso.graeshoppe.service.StoreService;
import com.diviso.graeshoppe.domain.Store;
import com.diviso.graeshoppe.repository.StoreRepository;
import com.diviso.graeshoppe.repository.search.*;
import com.diviso.graeshoppe.service.dto.StoreDTO;
import com.diviso.graeshoppe.service.mapper.StoreMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Id;
import javax.persistence.Lob;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Store.
 */
@Service
@Transactional
public class StoreServiceImpl implements StoreService {

	private final Logger log = LoggerFactory.getLogger(StoreServiceImpl.class);

	private final StoreRepository storeRepository;

	private final StoreMapper storeMapper;

	private final StoreSearchRepository storeSearchRepository;

	public StoreServiceImpl(StoreRepository storeRepository, StoreMapper storeMapper,
			StoreSearchRepository storeSearchRepository) {
		this.storeRepository = storeRepository;
		this.storeMapper = storeMapper;
		this.storeSearchRepository = storeSearchRepository;
	}

	/**
	 * Save a store.
	 *
	 * @param storeDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public StoreDTO save(StoreDTO storeDTO) {
		log.debug("Request to save Store : {}", storeDTO);
		Store store = storeMapper.toEntity(storeDTO);
		store = storeRepository.save(store);
		System.out.println("#############################################"+store);
		StoreDTO resultDTO = storeMapper.toDto(store);
		setStoreDetails( store );
		//storeSearchRepository.save(store);
		return resultDTO;
	}
	@Override
	public void saveData(Store store) {
	//	com.diviso.graeshoppe.repository.search.Store s =new com.diviso.graeshoppe.repository.search.Store()
		storeRepository.save(store);
		//storeSearchRepository.save(store);
	
	}
	
	
	
	public void setStoreDetails(Store result) {
		com.diviso.graeshoppe.domain.search.Store s=new com.diviso.graeshoppe.domain.search.Store();

		s.setId(result.getId());

		s.setRegNo(result.getRegNo());

		s.setName(result.getName());

		s.setImage(result.getImage());

		s.setImageContentType(result.getImageContentType());

		s.setTotalRating(result.getTotalRating());

		s.setLocation(result.getLocation());

		s.setLocationName(result.getLocationName());

		s.setContactNo(result.getContactNo());

	s.setOpeningTime(Date.from(result.getOpeningTime()));

		s.setEmail(result.getEmail());

		s.setClosingTime(Date.from(result.getClosingTime()));

		s.setInfo(result.getInfo());

		s.setMinAmount(result.getMinAmount());

		s.setMaxDeliveryTime(Date.from(result.getMaxDeliveryTime()));
		s.setPropreitor(result.getPropreitor());
		s.setStoreAddress(result.getStoreAddress());
		s.setStoreSettings(result.getStoreSettings());
		storeSearchRepository.save(s);
		
	}

	/**
	 * Get all the stores.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<StoreDTO> findAll(Pageable pageable) {
		log.debug("Request to get all Stores");
		return storeRepository.findAll(pageable).map(storeMapper::toDto);
	}

	/**
	 * Get one store by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<StoreDTO> findOne(Long id) {
		log.debug("Request to get Store : {}", id);
		return storeRepository.findById(id).map(storeMapper::toDto);
	}

	/**
	 * Delete the store by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Store : {}", id);
		storeRepository.deleteById(id);
		storeSearchRepository.deleteById(id);
	}

	/**
	 * Search for the store corresponding to the query.
	 *
	 * @param query
	 *            the query of the search
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	/*@Override
	@Transactional(readOnly = true)
	public Page<StoreDTO> search(String query, Pageable pageable) {
		log.debug("Request to search for a page of Stores for query {}", query);
		return storeSearchRepository.search(queryStringQuery(query), pageable).map(storeMapper::toDto);
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.diviso.graeshoppe.service.StoreService#saveStore(com.diviso.
	 * graeshoppe.domain.Store)
	 */
	@Override
	public Store saveStore(Store store) {
		log.debug("Request to save StoreDenormalized : {}", store);
	//	storeSearchRepository.save(store);
		return storeRepository.save(store);

	}
}
