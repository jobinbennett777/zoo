package com.zoo.testdata;

import java.util.ArrayList;
import java.util.List;

import com.zoo.dto.AnimalRequestDTO;
import com.zoo.dto.RoomRequestDTO;
import com.zoo.model.Animal;
import com.zoo.model.Room;

public class DataSet {
	public static List<Animal> getAnimals() {
		List<Animal> animals = new ArrayList<>();
		animals.add(getAnimal());

		return animals;
	}
	
	public static List<Room> getRooms() {
		List<Room> rooms = new ArrayList<>();
		rooms.add(getRoom());

		return rooms;
	}

	/**
	 * @return
	 */
	public static Room getRoom() {
		Room room = new Room();
		room.setId(10L);
		room.setSize(100L);
		room.setTitle("GREEN");
		return room;
	}

	/**
	 * @param animals
	 */
	public static Animal getAnimal() {
		Animal animal = new Animal();
		animal.setId(1L);
		animal.setTitle("ELEPHANT");
		animal.setType(">=");
		animal.setPreference(10L);
		return animal;
	}
	
	public static AnimalRequestDTO getAnimalRequest() {
		AnimalRequestDTO dto = new AnimalRequestDTO();
		dto.setTitle("CAT");
		dto.setType(">=");
		dto.setPreference(10L);
		return dto;
	}
	
	public static RoomRequestDTO getRoomRequest() {
		RoomRequestDTO dto = new RoomRequestDTO();
		dto.setTitle("GREEN");
		dto.setSize(100L);
		return dto;
	}
	
	
}
