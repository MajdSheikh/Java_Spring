package com.example.demo.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.project.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long>{
	public List<Idea> findAll();
}