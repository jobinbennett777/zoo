package com.zoo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.dto.RoomRequestDTO;
import com.zoo.model.Room;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@RestController
public class RoomController {
	
	@PostMapping("/room")
	public ResponseEntity<Room> createRoom(@RequestBody RoomRequestDTO request) {
		Room room = null;
		return new ResponseEntity<>(room, HttpStatus.OK);
	}
	
	@PutMapping("/room/{id}")
	public ResponseEntity<Room> udateRoom(@PathVariable long id, @RequestBody RoomRequestDTO request) {
		Room room = null;
		return new ResponseEntity<>(room, HttpStatus.OK);
	}
	
	@GetMapping("/room/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable long id) {
		Room room = null;
		return new ResponseEntity<>(room, HttpStatus.OK);
	}
	
	@DeleteMapping("/room/{id}")
	public ResponseEntity<Room> deleteRoomById(@PathVariable long id) {
		Room room = null;
		return new ResponseEntity<>(room, HttpStatus.OK);
	}

}
