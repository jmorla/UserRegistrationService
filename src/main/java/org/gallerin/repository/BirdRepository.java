package org.gallerin.repository;


import org.gallerin.domain.Bird;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BirdRepository extends Neo4jRepository<Bird, Long> {

}
