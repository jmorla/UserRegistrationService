package com.gallerin.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.gallerin.domain.Bird;

public interface BirdRepository extends Neo4jRepository<Bird, Long> {

}
