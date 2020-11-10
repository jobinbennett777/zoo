package com.zoo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zoo.dto.HappyAnimalsDTO;
import com.zoo.exception.AnimalNotFoundException;
import com.zoo.exception.RoomNotFoundException;
import com.zoo.model.Animal;
import com.zoo.model.Room;
import com.zoo.repository.AnimalRepository;
import com.zoo.repository.FavoriteRepository;
import com.zoo.repository.RoomRepository;
import com.zoo.service.AnimalService;
import com.zoo.service.RoomService;
import com.zoo.service.ZooService;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@Service
public class ZooServiceImpl implements ZooService {
	
	@Autowired
	AnimalService animalService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	FavoriteRepository favoriteRepository;

	@Override
	public Animal assignRoom(Long animalId, Long roomId) throws AnimalNotFoundException, RoomNotFoundException {
		Animal animal =  animalService.getAnimal(animalId);
		Room room = roomService.getRoom(roomId);
		room.setId(roomId);
		animal.setRoom(room);
		return animalRepository.save(animal);
	}

	@Override
	public Animal removeRoom(Long animalId) throws AnimalNotFoundException {
		Animal animal =  animalService.getAnimal(animalId);
		Room room = animal.getRoom();
		room.setId(null);
		return animalRepository.save(animal);
	}

	@Override
	public Animal moveRoom(Long animalId, Long roomId) throws AnimalNotFoundException {
		Animal animal =  animalService.getAnimal(animalId);
		Room room = animal.getRoom();
		room.setId(roomId);
		return animalRepository.save(animal);
	}

	@Override
	public List<Animal> getAnimalsNotInRoom(String property, String sortOrder) {
		return getAnimalsByRoomId(null, property, sortOrder);
	}

	@Override
	public List<Animal> getAnimalsInRoom(Long roomId, String property, String sortOrder) {
		return getAnimalsByRoomId(roomId, property, sortOrder);
	}

	/**
	 * @param roomId
	 * @param property
	 * @param sortOrder
	 * @return
	 */
	private List<Animal> getAnimalsByRoomId(Long roomId, String property, String sortOrder) {
		Direction direction = null;
		if("ASC".equalsIgnoreCase(sortOrder)) {
		 direction = Direction.ASC;
		}
		else {
			direction = Direction.DESC;
		}
		
		return animalRepository.findAllByRoomId(roomId,Sort.by(direction, property));
	}
	
	@Override
	public List<String> getFavoriteRooms(Long animalId) {
		return roomRepository.findAllFavoriteRooms(animalId);
	}

	@Override
	public List<HappyAnimalsDTO> getHappyAnimals() {
		
		List<Tuple> s = roomRepository.findALLHappyAnimals();
		List<HappyAnimalsDTO> dtoList = new ArrayList<>();
		HappyAnimalsDTO dto =  new HappyAnimalsDTO();
		s.forEach(tuple -> {
			Number no_of_happy_animals  = (Number) tuple.get("No_of_happy_animals");
			String room_title  =(String) tuple.get("ROOM_TITLE");
			dto.setNo_of_happy_animals(no_of_happy_animals.longValue());
			dto.setRoom_title(room_title);
			dtoList.add(dto);
		});
		return dtoList;
	}

}
