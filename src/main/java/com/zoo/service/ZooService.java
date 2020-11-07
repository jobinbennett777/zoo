package com.zoo.service;

import java.util.List;

import com.zoo.exception.AnimalNotFoundException;
import com.zoo.exception.RoomNotFoundException;
import com.zoo.model.Animal;
import com.zoo.model.Room;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
public interface ZooService {
	
	/**
	 * Get all animals in the zoo and not in the room
	 * 
	 * @param property
	 * @param sortOrder
	 * @return
	 */
	public List<Animal> getAnimalsNotInRoom(String property, String sortOrder);
	
	/**
	 * Get all animals in the specified room
	 * 
	 * @param roomId
	 * @param property
	 * @param sortOrder
	 * @return
	 */
	public List<Animal> getAnimalsInRoom(Long roomId, String property, String sortOrder);
	
	/**
	 * Assign room to animal
	 * 
	 * @param animalId
	 * @param roomId
	 * @return
	 * @throws AnimalNotFoundException 
	 * @throws RoomNotFoundException 
	 */
	public Animal assignRoom(Long animalId, Long roomId) throws AnimalNotFoundException, RoomNotFoundException;
	
	/**
	 * Remove animal from room
	 * 
	 * @param animalId
	 * @return
	 * @throws AnimalNotFoundException 
	 */
	public Animal removeRoom(Long animalId) throws AnimalNotFoundException;
	
	/**
	 * Move animal from one room to another room
	 * 
	 * @param animalId
	 * @param roomId
	 * @return
	 * @throws AnimalNotFoundException 
	 */
	public Animal moveRoom(Long animalId, Long roomId) throws AnimalNotFoundException;
	
	/**
	 * Get all favorite rooms for the given animal id
	 * 
	 * @param animalId
	 * @return
	 */
	public List<String> getFavoriteRooms(Long animalId);
}
