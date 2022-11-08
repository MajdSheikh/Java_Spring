package com.example.demo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.mvc.models.Ninjas;
import com.example.demo.mvc.repositories.NinjasRepository;



@Service
public class NinjasService {
	
	private final NinjasRepository ninjasRepository;

    public NinjasService(NinjasRepository ninjasRepository) {
        this.ninjasRepository = ninjasRepository;
    }
    

    public List<Ninjas> allNinjas() {
        return ninjasRepository.findAll();
    }
    

    public Ninjas createNinjas(Ninjas b) {
        return ninjasRepository.save(b);
    }
    
    

    public Ninjas findNinjas(Long id) {
        Optional<Ninjas> optionalNinjas = ninjasRepository.findById(id);
        if(optionalNinjas.isPresent()) {
            return optionalNinjas.get();
        } else {
            return null;
        }
    }
    

   public Ninjas updateNinjas(Long id, Ninjas ninjas) {
   	Ninjas updated = findNinjas(id);
    	updated.setFirstname(ninjas.getFirstname());
   	updated.setLastname(ninjas.getLastname());
   	updated.setAge(ninjas.getAge());
   	ninjasRepository.save(updated);
   		return null;
  	}
   

    public void deleteNinjas(Long id) {
    	ninjasRepository.deleteById(id);
    }
    
    

}
