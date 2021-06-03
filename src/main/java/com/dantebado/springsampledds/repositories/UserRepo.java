package com.dantebado.springsampledds.repositories;

import com.dantebado.springsampledds.model.pets.Pet;
import com.dantebado.springsampledds.model.users.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, String> {
}
