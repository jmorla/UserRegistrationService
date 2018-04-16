package com.gallerin.repository;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gallerin.domain.User;

public interface UserRepository extends Neo4jRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
