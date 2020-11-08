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
import com.zoo.service.AnimalService;
import com.zoo.testdata.DataSet;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@WebMvcTest(controllers = AnimalController.class)
public class AnimalControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AnimalService service;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void testCreateAnimal() throws Exception {
		mockMvc.perform(post("/animal/")
				.contentType("application/json")
		        .content(objectMapper.writeValueAsString(DataSet.getAnimalRequest())))
		        .andExpect(status().isOk());
	}
	
	@Test
	void testUpdateAnimal() throws Exception {
		mockMvc.perform(put("/animal/{id}",1)
				.contentType("application/json")
		        .content(objectMapper.writeValueAsString(DataSet.getAnimalRequest())))
		        .andExpect(status().isOk());
	}
	
	@Test
	void testGetAnimalById() throws Exception {
		mockMvc.perform(get("/animal/{id}",1)
		        .contentType("application/json"))
		        .andExpect(status().isOk());
	}
	
	@Test
	void testDeleteAnimalById() throws Exception {
		mockMvc.perform(delete("/animal/{id}",1)
		        .contentType("application/json"))
		        .andExpect(status().isOk());
	}

}
