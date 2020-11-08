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

import com.zoo.dto.AnimalRequestDTO;
import com.zoo.exception.AnimalNotFoundException;
import com.zoo.model.Animal;
import com.zoo.repository.AnimalRepository;
import com.zoo.service.impl.AnimalServiceImpl;
import com.zoo.testdata.DataSet;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@SpringBootTest
public class AnimalServiceTest {
	
	@InjectMocks
	AnimalServiceImpl service;
	
	@Mock
	AnimalRepository repository;
	
	
	@Test
	void testCreateAnimal() throws Exception {
		AnimalRequestDTO request = DataSet.getAnimalRequest();
	
		Mockito.when(repository.save(Mockito.any()))
	      .thenReturn(DataSet.getAnimal());
		Animal result = service.createAnimal(request);
		
		assertEquals(request.getPreference(), result.getPreference());
		
	}
	
	@Test
	void testGetAnimal() throws Exception {
		Mockito.when(repository.findById(Mockito.any()))
	      .thenReturn(Optional.of(DataSet.getAnimal()));
		service.getAnimal(1L);
		
		verify(repository, times(1)).findById(1L);
	}
	
	@Test
	void testAnimalNotFoundExceptionIsThrown() throws Exception {
		Mockito.when(repository.findById(Mockito.any()))
		.thenReturn(Optional.empty());

		Assertions.assertThrows(AnimalNotFoundException.class, () -> {
			service.getAnimal(1L);
		});
	}
	
	@Test
	void testUpdateAnimal() throws Exception {
		AnimalRequestDTO request = DataSet.getAnimalRequest();
	
		Mockito.when(repository.save(Mockito.any()))
	      .thenReturn(DataSet.getAnimal());
		service.updateAnimal(request,1L);
		
		verify(repository, times(1)).save(Mockito.any(Animal.class));
		
	}
	
	@Test
	void testDeleteAnimal() throws Exception {
		service.deleteAnimal(1L);
		verify(repository, times(1)).deleteById(Mockito.anyLong());
		
	}

}
