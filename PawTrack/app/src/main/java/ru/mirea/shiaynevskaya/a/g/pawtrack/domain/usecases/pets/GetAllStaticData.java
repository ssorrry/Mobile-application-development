package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.pets;

import java.util.List;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Pet;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.PetsRepository;

public class GetAllStaticData {
    private final PetsRepository petsRepository;

    public GetAllStaticData(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public List<Pet> execute() {
        return petsRepository.getAllStaticData();
    }
}
