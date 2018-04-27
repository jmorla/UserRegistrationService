package com.gallerin.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.gallerin.domain.Bird;

public interface BirdRepository extends Neo4jRepository<Bird, Long> {
	
	@Query("MATCH (b:Bird)-[r:OWNER]->(u:User) WHERE u.username={username} return b")
	Page<Bird> findAllBirdByUserOwner(@Param("username") String username, Pageable page);

	@Query("")
	void deleteBird(String birdId);
}
