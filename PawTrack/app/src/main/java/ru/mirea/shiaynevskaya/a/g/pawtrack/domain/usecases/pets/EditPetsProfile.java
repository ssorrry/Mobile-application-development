package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Pet;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.PetsRepository;

public class EditPetsProfile {
    private final PetsRepository petsRepository;

    public EditPetsProfile(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public void execute(int petId, Pet updatedPet) {
        petsRepository.editPetProfile(petId, updatedPet);
    }
}
