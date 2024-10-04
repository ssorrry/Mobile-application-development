package ru.mirea.shiaynevskaya.a.g.pawtrack.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Pet;
import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository.PetsRepository;

public class PetsRepositoryImpl implements PetsRepository {
    private final Map<Integer, Pet> petsDatabase = new HashMap<>();
    private final Map<Integer, List<String>> activityData = new HashMap<>();
    private final Map<Integer, List<Double>> weightData = new HashMap<>();
    private int currentPetId = 1;

    @Override
    public void addPetProfile(Pet pet) {
        pet = new Pet(currentPetId++, pet.getName(), pet.getAge(), pet.getBreed(), pet.getCategory(), pet.getPictureUrl());
        petsDatabase.put(pet.getId(), pet);
        System.out.println("Pet profile added for: " + pet.getName());
    }

    @Override
    public void editPetProfile(int petId, Pet updatedPet) {
        if (petsDatabase.containsKey(petId)) {
            petsDatabase.put(petId, updatedPet);
            System.out.println("Pet profile updated for ID: " + petId);
        } else {
            System.out.println("Pet ID not found: " + petId);
        }
    }

    @Override
    public void deletePetProfile(int petId) {
        if (petsDatabase.remove(petId) != null) {
            System.out.println("Pet profile deleted for ID: " + petId);
        } else {
            System.out.println("Pet ID not found: " + petId);
        }
    }

    @Override
    public List<Pet> getAllStaticData() {
        return new ArrayList<>(petsDatabase.values());
    }

    @Override
    public void addActivity(int petId, String activity) {
        activityData.computeIfAbsent(petId, k -> new ArrayList<>()).add(activity);
        System.out.println("Activity added for pet ID: " + petId);
    }

    @Override
    public List<String> getStaticDataActivity(int petId) {
        return activityData.getOrDefault(petId, new ArrayList<>());
    }

    @Override
    public void addWeight(int petId, double weight) {
        weightData.computeIfAbsent(petId, k -> new ArrayList<>()).add(weight);
        System.out.println("Weight added for pet ID: " + petId);
    }

    @Override
    public List<Double> getStaticDataWeight(int petId) {
        return weightData.getOrDefault(petId, new ArrayList<>());
    }
}
