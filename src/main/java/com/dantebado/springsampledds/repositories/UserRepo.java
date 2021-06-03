package com.dantebado.springsampledds.repositories;

import com.dantebado.springsampledds.model.users.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, String> {

    Optional<User> findByEmail(String email);

}
