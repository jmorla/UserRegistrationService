package com.gallerin.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.gallerin.domain.Bird;

public interface BirdRepository extends Neo4jRepository<Bird, Long> {
	
	@Query("MATCH (loggedUser:User)<-[:OWNER]-(birds:Bird) WHERE"
			+ " loggedUser.username={username} RETURN birds")
	Page<Bird> findBirdByUserOwnerName(@Param("username") String name, Pageable page);
}
