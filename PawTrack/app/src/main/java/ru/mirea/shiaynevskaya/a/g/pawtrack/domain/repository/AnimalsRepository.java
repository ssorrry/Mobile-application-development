package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository;

import java.util.List;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Animal;

public interface AnimalsRepository {
    List<Animal> getAllAnimals();
    List<Animal> sortAnimalsByNameAsc();
    List<Animal> sortAnimalsByNameDesc();
    List<Animal> searchAnimalByName(String name);
    List<Animal> searchAnimalByPicture(String pictureUrl);
    List<Animal> filterAnimalsByCategory(String category);
}
