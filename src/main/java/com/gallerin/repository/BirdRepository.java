package com.gallerin.repository;


import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.gallerin.domain.Bird;

public interface BirdRepository extends Neo4jRepository<Bird, Long> {
	
	@Query("MATCH (b:Bird)-[r:OWNER]->(u:User) WHERE u.username={username} RETURN b SKIP {skip} LIMIT {limit}")
	List<Bird> findAllBirdByUserOwner(@Param("username") String username, @Param("skip") int skip, @Param("skip") int limit);

	@Query("match (b:Bird) where bird.birdId={id} delete b return b")
	Bird deleteBird(@Param("id") String birdId);
}
