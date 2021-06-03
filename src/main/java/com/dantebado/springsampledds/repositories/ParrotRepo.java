package com.dantebado.springsampledds.repositories;

import com.dantebado.springsampledds.model.pets.dogs.Dog;
import com.dantebado.springsampledds.model.pets.parrots.Parrot;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParrotRepo extends PagingAndSortingRepository<Parrot, String> {

}
