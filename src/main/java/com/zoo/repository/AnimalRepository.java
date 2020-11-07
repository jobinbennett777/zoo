package com.zoo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoo.model.Animal;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
	List<Animal>findAllByRoomId(Long roomID,Sort sort);
}
