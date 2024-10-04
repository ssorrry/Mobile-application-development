package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.animals;

import java.util.List;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Animal;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.AnimalsRepository;

public class SearchAnimalByName {
    private final AnimalsRepository animalsRepository;

    public SearchAnimalByName(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    public List<Animal> execute(String name) {
        return animalsRepository.searchAnimalByName(name);
    }
}
