package com.example.demo.project.repositories;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.project.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{
    Iterable<Task> findAll();

	Task save(org.springframework.scheduling.config.@Valid Task task);
}