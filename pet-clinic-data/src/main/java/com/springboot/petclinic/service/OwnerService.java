package com.springboot.petclinic.service;

import com.springboot.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName (String lastName);

}
