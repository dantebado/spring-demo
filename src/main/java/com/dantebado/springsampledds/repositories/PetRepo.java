package com.dantebado.springsampledds.repositories;

import com.dantebado.springsampledds.model.pets.Pet;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends PagingAndSortingRepository<Pet, String> {
}
