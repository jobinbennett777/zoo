package com.zoo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.dto.AnimalRequestDTO;
import com.zoo.model.Animal;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@RestController
public class AnimalController {
	
	@PostMapping("/animal")
	public ResponseEntity<Animal> createAnimal(@RequestBody AnimalRequestDTO request) {
		Animal animal = null;
		return new ResponseEntity<>(animal, HttpStatus.OK);
	}
	
	@PutMapping("/animal/{id}")
	public ResponseEntity<Animal> udateAnimal(@PathVariable long id, @RequestBody AnimalRequestDTO request) {
		Animal animal = null;
		return new ResponseEntity<>(animal, HttpStatus.OK);
	}
	
	@GetMapping("/animal/{id}")
	public ResponseEntity<Animal> getAnimalById(@PathVariable long id) {
		Animal animal = null;
		return new ResponseEntity<>(animal, HttpStatus.OK);
	}
	
	@DeleteMapping("/animal/{id}")
	public ResponseEntity<Animal> deleteAnimalById(@PathVariable long id) {
		Animal animal = null;
		return new ResponseEntity<>(animal, HttpStatus.OK);
	}

}
