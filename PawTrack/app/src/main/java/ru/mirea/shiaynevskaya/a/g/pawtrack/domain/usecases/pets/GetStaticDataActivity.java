package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets;

import java.util.List;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.PetsRepository;

public class GetStaticDataActivity {
    private final PetsRepository petsRepository;

    public GetStaticDataActivity(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public List<String> execute(int petId) {
        return petsRepository.getStaticDataActivity(petId);
    }
}
