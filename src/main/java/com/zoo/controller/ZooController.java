package com.zoo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.dto.AnimalRequestDTO;
import com.zoo.model.Animal;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/zoo")
public class ZooController {
	@PostMapping("/animal/allocate")
	public ResponseEntity<Animal> allocateAnimal(@RequestBody AnimalRequestDTO request) {
		Animal animal = null;
		return new ResponseEntity<>(animal, HttpStatus.OK);
	}
	
	@PostMapping("/animal/release")
	public ResponseEntity<Animal> ReleaseAnimal(@RequestBody AnimalRequestDTO request) {
		Animal animal = null;
		return new ResponseEntity<>(animal, HttpStatus.OK);
	}
}
