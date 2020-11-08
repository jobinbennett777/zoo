package com.zoo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.zoo.dto.RoomRequestDTO;
import com.zoo.exception.RoomNotFoundException;
import com.zoo.model.Room;
import com.zoo.repository.RoomRepository;
import com.zoo.service.impl.RoomServiceImpl;
import com.zoo.testdata.DataSet;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@SpringBootTest
public class RoomServiceTest {
	
	@InjectMocks
	RoomServiceImpl service;
	
	@Mock
	RoomRepository repository;
	
	
	@Test
	void testCreateRoom() throws Exception {
		RoomRequestDTO request = DataSet.getRoomRequest();
	
		Mockito.when(repository.save(Mockito.any()))
	      .thenReturn(DataSet.getRoom());
		Room result = service.createRoom(request);
		
		assertEquals(request.getSize(), result.getSize());
		
	}
	
	@Test
	void testGetRoom() throws Exception {
		Mockito.when(repository.findById(Mockito.any()))
	      .thenReturn(Optional.of(DataSet.getRoom()));
		service.getRoom(1L);
		
		verify(repository, times(1)).findById(1L);
	}
	
	@Test
	void testRoomNotFoundExceptionIsThrown() throws Exception {
		Mockito.when(repository.findById(Mockito.any()))
		.thenReturn(Optional.empty());

		Assertions.assertThrows(RoomNotFoundException.class, () -> {
			service.getRoom(1L);
		});
	}
	
	@Test
	void testUpdateRoom() throws Exception {
		RoomRequestDTO request = DataSet.getRoomRequest();
	
		Mockito.when(repository.save(Mockito.any()))
	      .thenReturn(DataSet.getRoom());
		service.updateRoom(request,1L);
		
		verify(repository, times(1)).save(Mockito.any(Room.class));
		
	}
	
	@Test
	void testDeleteRoom() throws Exception {
		service.deleteRoom(1L);
		verify(repository, times(1)).deleteById(Mockito.anyLong());
		
	}

}
