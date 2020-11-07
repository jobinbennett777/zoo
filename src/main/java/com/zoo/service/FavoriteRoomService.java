package com.zoo.service;

import com.zoo.exception.AnimalNotFoundException;
import com.zoo.exception.RoomNotFoundException;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
public interface FavoriteRoomService {
	/**
	 * Assign Favorite rooms
	 * 
	 * @param roomId
	 * @param animalId
	 * @throws RoomNotFoundException
	 * @throws AnimalNotFoundException
	 */
	public void assignFavoriteRoom(Long roomId, Long animalId) throws RoomNotFoundException, AnimalNotFoundException;
	
	/**
	 * Release favourite room by id
	 * 
	 * @param id
	 */
	public void releaseFavoriteRoom(Long id);
}
