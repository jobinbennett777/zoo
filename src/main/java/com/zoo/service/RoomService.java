package com.zoo.service;

import com.zoo.dto.RoomRequestDTO;
import com.zoo.exception.RoomNotFoundException;
import com.zoo.model.Room;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
public interface RoomService {
	
	/**
	 * Create Room
	 * 
	 * @param requestDTO
	 * @return
	 */
	public Room createRoom(RoomRequestDTO requestDTO);
	
	/**
	 * Get Room By Id
	 * 
	 * @param id
	 * @return
	 * @throws RoomNotFoundException 
	 */
	public Room getRoom(Long id) throws RoomNotFoundException;
	
	/**
	 * Update Room for the given room id
	 * 
	 * @param requestDTO
	 * @param id
	 * @return
	 */
	public Room updateRoom(RoomRequestDTO requestDTO, Long id);
	
	/**
	 * Delete Room By Id
	 * 
	 * @param id
	 */
	public void deleteRoom(Long id);

}
