package com.gallerin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.gallerin.domain.Hen;

public interface HenRepository extends Neo4jRepository<Hen, Long> {

	@Query("MATCH (loggedUser:User)<-[:OWNER]-(hen:Hen) WHERE"
			+ " loggedUser.username={username} RETURN hen")
	Page<Hen> findHenByUserOwnerName(@Param("username") String name, Pageable page);
}
