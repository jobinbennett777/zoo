package com.zoo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoo.service.RoomService;
import com.zoo.testdata.DataSet;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@WebMvcTest(controllers = RoomController.class)
public class RoomControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RoomService service;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void testCreateRoom() throws Exception {
		mockMvc.perform(post("/room/")
				.contentType("application/json")
		        .content(objectMapper.writeValueAsString(DataSet.getRoomRequest())))
		        .andExpect(status().isOk());
	}
	
	@Test
	void testUpdateRoom() throws Exception {
		mockMvc.perform(put("/room/{id}",1)
				.contentType("application/json")
		        .content(objectMapper.writeValueAsString(DataSet.getRoomRequest())))
		        .andExpect(status().isOk());
	}
	
	@Test
	void testGetRoomById() throws Exception {
		mockMvc.perform(get("/room/{id}",1)
		        .contentType("application/json"))
		        .andExpect(status().isOk());
	}
	
	@Test
	void testDeleteRoomById() throws Exception {
		mockMvc.perform(delete("/room/{id}",1)
		        .contentType("application/json"))
		        .andExpect(status().isOk());
	}

}
