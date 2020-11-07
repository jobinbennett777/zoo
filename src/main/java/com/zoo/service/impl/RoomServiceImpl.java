package com.zoo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.dto.RoomRequestDTO;
import com.zoo.exception.RoomNotFoundException;
import com.zoo.model.Room;
import com.zoo.repository.RoomRepository;
import com.zoo.service.RoomService;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomRepository repository;

	@Override
	public Room createRoom(RoomRequestDTO requestDTO) {
		Room room = new Room();
		room.setSize(requestDTO.getSize());
		room.setTitle(requestDTO.getTitle());
		return repository.save(room);
	}

	@Override
	public Room getRoom(Long id) throws RoomNotFoundException {
		return repository.findById(id).orElseThrow(()-> new RoomNotFoundException(String.format("Room with id %d not found", id)));
	}

	@Override
	public Room updateRoom(RoomRequestDTO requestDTO, Long id) {
		Room room = new Room();
		room.setId(id);
		room.setSize(requestDTO.getSize());
		room.setTitle(requestDTO.getTitle());
		return repository.save(room);
	}

	@Override
	public void deleteRoom(Long id) {
		repository.deleteById(id);
	}

}
