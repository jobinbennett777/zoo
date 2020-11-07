package com.zoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoo.model.Favorite;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
