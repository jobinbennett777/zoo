package com.zoo.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.zoo.model.Animal;
import com.zoo.repository.AnimalRepository;
import com.zoo.repository.FavoriteRepository;
import com.zoo.repository.RoomRepository;
import com.zoo.service.impl.ZooServiceImpl;
import com.zoo.testdata.DataSet;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@SpringBootTest
public class ZooServiceTest {

	@InjectMocks
	ZooServiceImpl service;
	@Mock
	AnimalService animalService;
	@Mock
	RoomService roomService;
	@Mock
	RoomRepository repository;
	@Mock
	AnimalRepository animalRepository;
	@Mock
	RoomRepository roomRepository;
	@Mock
	FavoriteRepository favoriteRepository;

	@Test
	void testAssignRoom() throws Exception {
		Mockito.when(animalService.getAnimal(1L)).thenReturn(DataSet.getAnimal());
		Mockito.when(roomService.getRoom(1L)).thenReturn(DataSet.getRoom());
		service.assignRoom(1L, 1L);

		verify(animalRepository, times(1)).save(Mockito.any(Animal.class));

	}

	@Test
	void testRemoveRoom() throws Exception {
		Animal animal = DataSet.getAnimal();
		animal.setRoom(DataSet.getRoom());
		Mockito.when(animalService.getAnimal(1L)).thenReturn(animal);
		service.removeRoom(1L);

		verify(animalRepository, times(1)).save(Mockito.any(Animal.class));

	}

	@Test
	void testMoveRoom() throws Exception {
		Animal animal = DataSet.getAnimal();
		animal.setRoom(DataSet.getRoom());
		Mockito.when(animalService.getAnimal(1L)).thenReturn(animal);
		service.moveRoom(1L, 1L);

		verify(animalRepository, times(1)).save(Mockito.any(Animal.class));

	}

	@Test
	void testGetAnimalsNotInRoom() throws Exception {
		Mockito.when(animalRepository.findAllByRoomId(Mockito.anyLong(), Mockito.any(Sort.class)))
				.thenReturn(DataSet.getAnimals());
		service.getAnimalsNotInRoom("title", "ASC");

		verify(animalRepository, times(1)).findAllByRoomId(null, Sort.by(Direction.ASC, "title"));

	}

	@Test
	void testGetAnimalsInRoom() throws Exception {
		Mockito.when(animalRepository.findAllByRoomId(Mockito.anyLong(), Mockito.any(Sort.class)))
				.thenReturn(DataSet.getAnimals());
		service.getAnimalsInRoom(1L, "title", "ASC");

		verify(animalRepository, times(1)).findAllByRoomId(1L, Sort.by(Direction.ASC, "title"));

	}

	@Test
	void testGetFavoriteRooms() throws Exception {
		List<String> favoriteRooms =  new ArrayList<>();
		favoriteRooms.add("GREEN");	
		Mockito.when(roomRepository.findAllFavoriteRooms(Mockito.anyLong()))
		.thenReturn(favoriteRooms);
		service.getFavoriteRooms(1L);

		verify(roomRepository, times(1)).findAllFavoriteRooms(1L);

	}

}
