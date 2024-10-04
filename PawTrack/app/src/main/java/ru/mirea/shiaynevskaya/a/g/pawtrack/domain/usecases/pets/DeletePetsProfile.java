package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.PetsRepository;

public class DeletePetsProfile {
    private final PetsRepository petsRepository;

    public DeletePetsProfile(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public void execute(int petId) {
        petsRepository.deletePetProfile(petId);
    }
}
