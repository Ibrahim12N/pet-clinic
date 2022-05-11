package com.springboot.petclinic.repositories;

import com.springboot.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName (String lastName);
    List<Owner> findAllByLastNameLike (String lastName);

}
