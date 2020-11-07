package com.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zoo.model.Room;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	@Query(value="select title from room rm left join favorite fav on rm.id = fav.room_id WHERE fav.animal_id=?", nativeQuery = true)
	List<String> findAllFavoriteRooms(Long animalId);
}
