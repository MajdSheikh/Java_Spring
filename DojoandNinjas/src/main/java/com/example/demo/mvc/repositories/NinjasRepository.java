package com.example.demo.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.mvc.models.Ninjas;


public interface NinjasRepository extends CrudRepository<Ninjas, Long> {
	
    List<Ninjas> findAll();


}
