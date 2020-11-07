package com.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.dto.RoomRequestDTO;
import com.zoo.exception.RoomNotFoundException;
import com.zoo.model.Room;
import com.zoo.service.RoomService;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	RoomService service;
	
	@PostMapping("/")
	public ResponseEntity<Room> createRoom(@RequestBody RoomRequestDTO requestDTO) {
		return new ResponseEntity<>(service.createRoom(requestDTO), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable long id, @RequestBody RoomRequestDTO requestDTO) {
		return new ResponseEntity<>(service.updateRoom(requestDTO, id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable long id) throws RoomNotFoundException {
		return new ResponseEntity<>(service.getRoom(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRoomById(@PathVariable long id) {
		service.deleteRoom(id);
		return new ResponseEntity<>(String.format("Succesfully deleted room with id: %d", id), HttpStatus.OK);
	}

}
