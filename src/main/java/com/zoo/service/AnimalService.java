package com.zoo.service;

import com.zoo.dto.AnimalRequestDTO;
import com.zoo.exception.AnimalNotFoundException;
import com.zoo.model.Animal;

public interface AnimalService {
	
	/**
	 * Create Animal
	 * 
	 * @param requestDTO
	 * @return
	 */
	public Animal createAnimal(AnimalRequestDTO requestDTO);
	
	/**
	 * Get Animal By Id
	 * 
	 * @param id
	 * @return
	 * @throws AnimalNotFoundException 
	 */
	public Animal getAnimal(Long id) throws AnimalNotFoundException;
	
	/**
	 * Update Animal
	 * 
	 * @param requestDTO
	 * @param id
	 * @return
	 */
	public Animal updateAnimal(AnimalRequestDTO requestDTO, Long id);
	
	/**
	 * Delete Animal
	 * 
	 * @param id
	 */
	public void deleteAnimal(Long id);

}
