package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Pet;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.PetsRepository;

public class AddPetsProfile {
    private final PetsRepository petsRepository;

    public AddPetsProfile(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public void execute(Pet pet) {
        petsRepository.addPetProfile(pet);
    }
}
