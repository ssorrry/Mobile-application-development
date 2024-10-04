package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.PetsRepository;

public class AddActivity {
    private final PetsRepository petsRepository;

    public AddActivity(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public void execute(int petId, String activity) {
        petsRepository.addActivity(petId, activity);
    }
}
