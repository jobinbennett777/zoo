package com.zoo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.zoo.model.Animal;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@Repository
public interface AnimalRepository extends PagingAndSortingRepository<Animal, Long> {
}
