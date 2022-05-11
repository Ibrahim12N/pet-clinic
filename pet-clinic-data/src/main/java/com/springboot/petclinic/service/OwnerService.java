package com.springboot.petclinic.service;

import com.springboot.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName (String lastName);
    List<Owner> findAllByLastNameLike (String lastName);

}
