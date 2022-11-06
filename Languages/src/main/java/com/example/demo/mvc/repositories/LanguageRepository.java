package com.example.demo.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.mvc.models.Language;



public interface LanguageRepository extends CrudRepository<Language, Long>{

	
    List<Language> findAll();
    List<Language> findBynameContaining(String search);

}
