package com.zoo.repository;

import java.util.List;

import javax.persistence.Tuple;

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

	@Query(value = "select title from room rm left join favorite fav on rm.id = fav.room_id WHERE fav.animal_id=?", nativeQuery = true)
	List<String> findAllFavoriteRooms(Long animalId);

	@Query(value = "select title as room_title, count(title) as no_of_happy_animals from (select room.title,room.size from room  join animal on animal.Type='<=' and room.size <= animal.preference and room.id=animal.room_id or animal.type ='>=' and room.size >= animal.preference and room.id=animal.room_id)t1 group by title", nativeQuery = true)
	List<Tuple> findALLHappyAnimals();
}
