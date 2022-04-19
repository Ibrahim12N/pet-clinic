package com.springboot.petclinic.bootstrap;

import com.springboot.petclinic.model.*;
import com.springboot.petclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count==0){
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType dogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType catPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology  = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery  = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry  = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alex");
        owner1.setLastName("Dubi");
        owner1.setAddress("address1");
        owner1.setCity("city1");
        owner1.setTelephone("telephone1");

        Pet owner1Pet = new Pet();
        owner1Pet.setPetType(dogPetType);
        owner1Pet.setName("Rosco");
        owner1Pet.setBirthDate(LocalDate.now());
        owner1Pet.setOwner(owner1);
        owner1.getPets().add(owner1Pet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sam");
        owner2.setLastName("Frank");
        owner2.setAddress("address2");
        owner2.setCity("city2");
        owner2.setTelephone("telephone2");
        ownerService.save(owner2);

        Pet owner2Pet = new Pet();
        owner2Pet.setPetType(catPetType);
        owner2Pet.setName("sjol");
        owner2Pet.setBirthDate(LocalDate.now());
        owner2Pet.setOwner(owner2);
        owner2.getPets().add(owner2Pet);

        Visit catVisit = new Visit();
        catVisit.setPet(owner1Pet);
        catVisit.setDescription("Sneezy kitty");
        catVisit.setDate(LocalDate.now());
        visitService.save(catVisit);

        System.out.println("Loaded owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Mora");
        vet1.setLastName("Daukk");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Voda");
        vet2.setLastName("Gan");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets.....");
    }
}
