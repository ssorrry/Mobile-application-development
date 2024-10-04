package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets;

import java.util.List;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.PetsRepository;

public class GetStaticDataWeight {
    private final PetsRepository petsRepository;

    public GetStaticDataWeight(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public List<Double> execute(int petId) {
        return petsRepository.getStaticDataWeight(petId);
    }
}
