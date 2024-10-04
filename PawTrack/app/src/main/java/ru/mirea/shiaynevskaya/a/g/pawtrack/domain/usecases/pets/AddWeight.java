package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.PetsRepository;

public class AddWeight {
    private final PetsRepository petsRepository;

    public AddWeight(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public void execute(int petId, double weight) {
        petsRepository.addWeight(petId, weight);
    }
}
