package org.jmorla.repository;

import java.util.Optional;

import org.jmorla.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends Neo4jRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
