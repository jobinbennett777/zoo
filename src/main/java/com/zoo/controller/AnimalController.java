package com.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.dto.AnimalRequestDTO;
import com.zoo.exception.AnimalNotFoundException;
import com.zoo.model.Animal;
import com.zoo.service.AnimalService;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	AnimalService service;
	
	@PostMapping("/")
	public ResponseEntity<Animal> createAnimal(@RequestBody AnimalRequestDTO requestDTO) {
		return new ResponseEntity<>(service.createAnimal(requestDTO), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Animal> updateAnimal(@PathVariable long id, @RequestBody AnimalRequestDTO requestDTO) {
		return new ResponseEntity<>(service.updateAnimal(requestDTO, id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Animal> getAnimalById(@PathVariable long id) throws AnimalNotFoundException {
		return new ResponseEntity<>(service.getAnimal(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAnimalById(@PathVariable long id) {
		service.deleteAnimal(id);
		return new ResponseEntity<>(String.format("Succesfully deleted animal with id: %d", id), HttpStatus.OK);
	}

}
