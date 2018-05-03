package com.gallerin.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.gallerin.domain.Bird;
import com.gallerin.domain.Hen;
import com.gallerin.domain.Rooster;

public interface BirdRepository extends Neo4jRepository<Bird, Long> {
	
	@Query("MATCH (b:Bird),(u:User),(b)-[:OWNER]->(u) WHERE u.username={username} RETURN b SKIP {skip} LIMIT {limit}")
	List<Bird> findAllBirdByUserOwner(@Param("username") String username, @Param("skip") int skip, @Param("limit") int limit);

	@Query("match (b:Bird) where bird.birdId={id} delete b return b")
	Bird deleteBird(@Param("id") String birdId);
	
	@Query("match (b:Bird)-[r:OWNER]->(u:User) where u.username={username} and b.alias={alias} return b")
	Optional<Bird> findBirdByAlias(@Param("username") String username, @Param("alias") String alias);
	
	@Query("match (b:Bird:Rooster)-[r:OWNER]->(u:User) where u.username={username} and b.birdId={birdId} return b")
	Optional<Rooster> findFatherByBirdId(@Param("username") String username, @Param("birdId") String birdId);
	
	@Query("match (b:Bird:Hen)-[r:OWNER]->(u:User) where u.username={username} and b.birdId={birdId} return b")
	Optional<Hen> findMotherByBirdId(@Param("username") String username, @Param("birdId") String birdId);
}
