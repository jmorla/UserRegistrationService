package org.jmorla.repository;

import java.util.Optional;

import org.jmorla.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
