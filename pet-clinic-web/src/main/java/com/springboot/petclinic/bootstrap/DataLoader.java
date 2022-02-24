package com.springboot.petclinic.bootstrap;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.model.Vet;
import com.springboot.petclinic.service.OwnerService;
import com.springboot.petclinic.service.VetService;
import com.springboot.petclinic.service.map.OwnerServiceMap;
import com.springboot.petclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Alex");
        owner1.setLastName("Dubi");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Sam");
        owner2.setLastName("Frank");

        ownerService.save(owner2);

        System.out.println("Loaded owners.....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Mora");
        vet1.setLastName("Daukk");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Voda");
        vet2.setLastName("Gan");

        vetService.save(vet2);

        System.out.println("Loaded vets.....");

    }
}
