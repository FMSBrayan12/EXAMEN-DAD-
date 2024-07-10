package com.yamunaque.infraccionservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yamunaque.infraccionservice.entity.Infraccion;
import com.yamunaque.infraccionservice.repository.InfraccionRepository;


@Service
public class InfraccionService {
	@Autowired
	private InfraccionRepository repository;
	@Transactional(readOnly = true)
	public List<Infraccion> findAll(Pageable page){
		try {
			return repository.findAll(page).toList();
			
		}catch(Exception e) {
			return null;
		}
	}

}
