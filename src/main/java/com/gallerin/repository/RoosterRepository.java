package com.gallerin.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.gallerin.domain.Rooster;

public interface RoosterRepository extends Neo4jRepository<Rooster, Long> {
	
	@Query("MATCH (loggedUser:User)<-[:OWNER]-(roosters:Rooster) WHERE"
			+ " loggedUser.username={username} RETURN roosters")
	Page<Rooster> findRoosterByUserOwnerName(@Param("username") String name, Pageable page);
	
	@Query("MATCH (loggedUser:User)<-[:OWNER]-(rooster:Rooster) WHERE"
			+ " loggedUser.username={username} and rooster.birdId={roosterId} RETURN roosters")
	Optional<Rooster> findRoosterById(@Param("username") String username,@Param("roosterID") String roosterId);
}
