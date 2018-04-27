package com.gallerin.repository;

import java.util.Optional;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.gallerin.domain.User;

public interface UserRepository extends Neo4jRepository<User, Long> {

	@Query("MATCH (u:User) WHERE u.username={username} RETURN u")
	Optional<User> findByUsername(@Param("username") String username);
}
