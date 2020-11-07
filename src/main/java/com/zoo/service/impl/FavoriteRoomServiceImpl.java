package com.zoo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.exception.AnimalNotFoundException;
import com.zoo.exception.RoomNotFoundException;
import com.zoo.model.Favorite;
import com.zoo.repository.FavoriteRepository;
import com.zoo.service.AnimalService;
import com.zoo.service.FavoriteRoomService;
import com.zoo.service.RoomService;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@Service
public class FavoriteRoomServiceImpl implements FavoriteRoomService {
	@Autowired
	FavoriteRepository favoriteRepository;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	AnimalService animalService;
	
	@Override
	public void assignFavoriteRoom(Long roomId, Long animalId) throws RoomNotFoundException, AnimalNotFoundException {
		valdateExistence(roomId, animalId);
		Favorite favoriteRoom = new Favorite();
		favoriteRoom.setRoomId(roomId);
		favoriteRoom.setAnimalId(animalId);
		favoriteRepository.save(favoriteRoom);
		
	}

	/**
	 * @param roomId
	 * @param animalId
	 * @throws RoomNotFoundException if Room does not exist in database
	 * @throws AnimalNotFoundException if Animal does not exist in database
	 */
	private void valdateExistence(Long roomId, Long animalId) throws RoomNotFoundException, AnimalNotFoundException {
		roomService.getRoom(roomId);
		animalService.getAnimal(animalId);
	}

	@Override
	public void releaseFavoriteRoom(Long id) {
		favoriteRepository.deleteById(id);
	}

}
