package com.example.demo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.mvc.models.Dojo;
import com.example.demo.mvc.repositories.DojoRepository;


@Service
public class DojoService {

	
	 private final DojoRepository dojoRepository;

	    public DojoService(DojoRepository dojoRepository) {
	        this.dojoRepository = dojoRepository;
	    }
	    

	    public List<Dojo> allDojos() {
	        return dojoRepository.findAll();
	    }
	    

	    public Dojo createDojo(Dojo b) {
	        return dojoRepository.save(b);
	    }
	    

	    public Dojo findDojo(Long id) {
	        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
	    }
	    
	    

    public Dojo updateDojo(Long id,Dojo dojo) {
	    	Dojo updated = findDojo(id);
    	updated.setName(dojo.getName());
    	dojoRepository.save(updated);
    		return null;
    	}
	    	
	    

	    public void deleteDojo(Long id) {
	    	dojoRepository.deleteById(id);
	    }
}
