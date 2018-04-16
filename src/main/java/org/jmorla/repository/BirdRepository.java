package org.jmorla.repository;


import org.jmorla.domain.Bird;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BirdRepository extends Neo4jRepository<Bird, Long> {

}
