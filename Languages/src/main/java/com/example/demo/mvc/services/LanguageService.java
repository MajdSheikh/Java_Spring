package com.example.demo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.mvc.models.Language;
import com.example.demo.mvc.repositories.LanguageRepository;


@Service
public class LanguageService {
	
	 private final LanguageRepository languageRepository;
	    //repository interface as a dependency
	    public LanguageService(LanguageRepository languageRepository) {
	        this.languageRepository = languageRepository;
	    }
	    
	    // returns all the Languages
	    public List<Language> allLanguages() {
	        return languageRepository.findAll();
	    }
	    
	    // creates a Language
	    public Language createLanguage(Language b) {
	        return languageRepository.save(b);
	    }
	    
	    // retrieves a Language
	    public Language findLanguage(Long id) {
	        Optional<Language> optionalLanguage = languageRepository.findById(id);
	        if(optionalLanguage.isPresent()) {
	            return optionalLanguage.get();
	        } else {
	            return null;
	        }
	    }
	    
	    
	    //update a certain Language (that we get by its id), it takes 
	    public Language updateLanguage(Long id,Language expense) {
	    	Language updated =findLanguage(id);
	    	updated.setName(expense.getName());
	    	updated.setCreator(expense.getCreator());
	    	updated.setVersion(expense.getVersion());
	    	languageRepository.save(updated);
	    		return null;
	    	}
	    	
	    
	    
	    // delete Language by its id
	    public void deleteLanguage(Long id) {
	    	languageRepository.deleteById(id);
	    }
}
