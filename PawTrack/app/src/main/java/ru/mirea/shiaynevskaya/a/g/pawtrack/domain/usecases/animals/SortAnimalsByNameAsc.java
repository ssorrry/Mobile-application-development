package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.animals;

import java.util.List;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Animal;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.AnimalsRepository;

public class SortAnimalsByNameAsc {
    private final AnimalsRepository animalsRepository;

    public SortAnimalsByNameAsc(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    public List<Animal> execute() {
        return animalsRepository.sortAnimalsByNameAsc();
    }
}
