package com.zoo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoo.service.FavoriteRoomService;
import com.zoo.service.ZooService;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@WebMvcTest(ZooController.class)
public class ZooControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FavoriteRoomService favoriteService;
	
	@MockBean
	private ZooService zooService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void testApiGetAnimalsNotInRoom() throws Exception {
		mockMvc.perform(get("/zoo/animals")
				.queryParam("sort", "title")
				.queryParam("order", "ASC")
		        .contentType("application/json"))
		        .andExpect(status().isOk());
	}
	
	@Test
	void testApiGetAnimalsInRoom() throws Exception {
		mockMvc.perform(get("/zoo/animals/{id}",1)
				.queryParam("sort", "title")
				.queryParam("order", "ASC")
		        .contentType("application/json"))
		        .andExpect(status().isOk());
	}
	
	@Test
	void testAssignRoomForAnimals() throws Exception {
		mockMvc.perform(patch("/zoo/room")
				.queryParam("animalId", "1")
				.queryParam("roomId", "1")
		        .contentType("application/json"))
		        .andExpect(status().isOk());
	}
	
	@Test
	void testAssignFavoriteRoom() throws Exception {
		mockMvc.perform(post("/zoo/room/favorite")
				.queryParam("animalId", "1")
				.queryParam("roomId", "1")
		        .contentType("application/json"))
		        .andExpect(status().isOk());
	}
	
	@Test
	void testReleaseFavoriteRoom() throws Exception {
		mockMvc.perform(delete("/zoo/room/favorite/{id}",1)
		        .contentType("application/json"))
		        .andExpect(status().isOk());
	}
	
	@Test
	void testGetFavoriteRoom() throws Exception {
		mockMvc.perform(get("/zoo/room/favorite/{animalId}",1)
		        .contentType("application/json"))
		        .andExpect(status().isOk());
	}

}
