package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.model.pets.dogs.Dog;
import com.dantebado.springsampledds.model.pets.dogs.DogCDTO;
import com.dantebado.springsampledds.model.users.User;
import com.dantebado.springsampledds.repositories.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogSvc {

    @Autowired
    DogRepo dogRepo;

    @Autowired
    AuthSvc authSvc;

    public Dog save(Dog dog) {
        return dogRepo.save(dog);
    }

    public Dog create(DogCDTO body) {
        User owner = authSvc.getCurrentUser();
        Dog dog = new Dog(body, owner);

        return save(dog);
    }

}
