package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.usecases.animals;

import java.util.List;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Animal;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.AnimalsRepository;

public class FilterAnimalsByCategory {
    private final AnimalsRepository animalsRepository;

    public FilterAnimalsByCategory(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    public List<Animal> execute(String category) {
        return animalsRepository.filterAnimalsByCategory(category);
    }
}
