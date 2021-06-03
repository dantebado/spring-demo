package com.dantebado.springsampledds.repositories;

import com.dantebado.springsampledds.model.pets.Pet;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends PagingAndSortingRepository<Pet, String> {

    @Query("SELECT p FROM Pet p WHERE (:query IS NULL OR p.name LIKE %:query% OR p.ownerFullName LIKE %:query%)")
    Page<Pet> findAll(String query, @NotNull Pageable pageable);

}
