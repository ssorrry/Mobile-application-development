package ru.mirea.shiaynevskaya.a.g.pawtrack.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Animal;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.AnimalsRepository;

public class AnimalsRepositoryImpl implements AnimalsRepository {
    private final List<Animal> animalsDatabase = new ArrayList<>();

    public AnimalsRepositoryImpl() {
        // Добавляем тестовые данные
        animalsDatabase.add(new Animal(1, "Русская борзая", "Dog", "http://example.com/charlie.jpg"));
        animalsDatabase.add(new Animal(2, "Сиамская", "Cat", "http://example.com/bella.jpg"));
        animalsDatabase.add(new Animal(3, "Доберман", "Dog", "http://example.com/max.jpg"));
        animalsDatabase.add(new Animal(4, "Сфинкс", "Cat", "http://example.com/luna.jpg"));
    }

    @Override
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animalsDatabase);
    }

    @Override
    public List<Animal> sortAnimalsByNameAsc() {
        return animalsDatabase.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Animal> sortAnimalsByNameDesc() {
        return animalsDatabase.stream()
                .sorted(Comparator.comparing(Animal::getName).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Animal> searchAnimalByName(String name) {
        return animalsDatabase.stream()
                .filter(animal -> animal.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Animal> searchAnimalByPicture(String pictureUrl) {
        return animalsDatabase.stream()
                .filter(animal -> animal.getPictureUrl().equals(pictureUrl))
                .collect(Collectors.toList());
    }

    @Override
    public List<Animal> filterAnimalsByCategory(String category) {
        return animalsDatabase.stream()
                .filter(animal -> animal.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
}
