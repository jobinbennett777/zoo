package com.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.exception.AnimalNotFoundException;
import com.zoo.exception.RoomNotFoundException;
import com.zoo.model.Animal;
import com.zoo.service.FavoriteRoomService;
import com.zoo.service.ZooService;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/zoo")
public class ZooController {

	@Autowired
	FavoriteRoomService favoriteService;

	@Autowired
	ZooService zooService;
	
	/**
	 * Get all animals in zoo but not in rooms
	 * 
	 * @param property
	 * @param order
	 * @return
	 * @throws AnimalNotFoundException
	 */
	@GetMapping("/animals")
	public ResponseEntity<List<Animal>> getRoomlessAnimals(@RequestParam(name = "sort", required = true) String property,
			@RequestParam(name = "order", required = true) String order) throws AnimalNotFoundException {
		return new ResponseEntity<>(zooService.getAnimalsNotInRoom(property, order), HttpStatus.OK);
	}
	
	/**
	 * Get all animals in the give room
	 * 
	 * @param roomId
	 * @param property
	 * @param order
	 * @return
	 * @throws AnimalNotFoundException
	 */
	@GetMapping("/animals/{roomId}")
	public ResponseEntity<List<Animal>> getAnimalsInRoom(@PathVariable Long roomId, @RequestParam(name = "sort", required = true) String property,
			@RequestParam(name = "order", required = true) String order) throws AnimalNotFoundException {
		return new ResponseEntity<>(zooService.getAnimalsInRoom(roomId, property, order), HttpStatus.OK);
	}
	
	
	/**
	 * Place Animal in a room
	 * 
	 * @param roomId
	 * @param animalId
	 * @return
	 * @throws AnimalNotFoundException
	 * @throws RoomNotFoundException
	 */
	@PatchMapping("/room")
	public ResponseEntity<String> assignRoomForAnimal(@RequestParam(name = "roomId", required = true) Long roomId,
			@RequestParam(name = "animalId", required = true) Long animalId) throws AnimalNotFoundException, RoomNotFoundException {
		zooService.assignRoom(animalId, roomId);
		return new ResponseEntity<>(String.format("Succesfully allocated room for animal id : %d", animalId), HttpStatus.OK);
	} 
	
	/**
	 * Assign favorite room
	 * 
	 * @param roomId
	 * @param animalId
	 * @return
	 * @throws RoomNotFoundException
	 * @throws AnimalNotFoundException
	 */
	@PostMapping("/room/favorite")
	public ResponseEntity<String> assignFavoriteRoom(@RequestParam(name = "roomId", required = true) Long roomId,
			@RequestParam(name = "animalId", required = true) Long animalId) throws RoomNotFoundException, AnimalNotFoundException {
		favoriteService.assignFavoriteRoom(roomId, animalId);
		return new ResponseEntity<>(String.format("Succesfully allocated favorite room for animal id : %d", animalId), HttpStatus.OK);
	}

	/**
	 * Delete favorite room by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/room/favorite/{id}")
	public ResponseEntity<String> releaseFavoriteRoom(@PathVariable Long id) {
		favoriteService.releaseFavoriteRoom(id);
		return new ResponseEntity<>(String.format("Succesfully released favorite room"), HttpStatus.OK);
	}
	
	/**
	 * Get Favorite rooms for the given animal
	 * 
	 * @param animalId
	 * @return
	 * @throws AnimalNotFoundException
	 */
	@GetMapping("/room/favorite/{animalId}")
	public ResponseEntity<List<String>> getFavoriteRooms(@PathVariable Long animalId) throws AnimalNotFoundException {
		return new ResponseEntity<>(zooService.getFavoriteRooms(animalId), HttpStatus.OK);
	}
}
