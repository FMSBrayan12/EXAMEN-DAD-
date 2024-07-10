package com.yamunaque.infraccionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yamunaque.infraccionservice.entity.Infraccion;

public interface InfraccionRepository extends JpaRepository<Infraccion, Integer>{

}
