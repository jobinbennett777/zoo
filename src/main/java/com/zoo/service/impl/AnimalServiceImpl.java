package com.zoo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.dto.AnimalRequestDTO;
import com.zoo.exception.AnimalNotFoundException;
import com.zoo.model.Animal;
import com.zoo.repository.AnimalRepository;
import com.zoo.service.AnimalService;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@Service
public class AnimalServiceImpl implements AnimalService {
	
	@Autowired
	AnimalRepository repository;

	@Override
	public Animal createAnimal(AnimalRequestDTO requestDTO) {
		Animal animal = new Animal();
		animal.setTitle(requestDTO.getTitle());
		animal.setType(requestDTO.getType());
		animal.setPreference(requestDTO.getPreference());
		return repository.save(animal);
	}

	@Override
	public Animal getAnimal(Long id) throws AnimalNotFoundException {
		return repository.findById(id).orElseThrow(()-> new AnimalNotFoundException(String.format("Animal with id %d not found", id)));
	}

	@Override
	public Animal updateAnimal(AnimalRequestDTO requestDTO, Long id) {
		Animal animal = new Animal();
		animal.setId(id);
		animal.setTitle(requestDTO.getTitle());
		animal.setType(requestDTO.getType());
		animal.setPreference(requestDTO.getPreference());
		return repository.save(animal);
	}

	@Override
	public void deleteAnimal(Long id) {
		repository.deleteById(id);
	}

}
