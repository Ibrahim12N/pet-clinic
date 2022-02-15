package com.springboot.petclinic.service;

import com.springboot.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById (Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
