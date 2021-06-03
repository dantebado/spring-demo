package com.dantebado.springsampledds.repositories;

import com.dantebado.springsampledds.model.pets.dogs.Dog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends PagingAndSortingRepository<Dog, String> {

}
