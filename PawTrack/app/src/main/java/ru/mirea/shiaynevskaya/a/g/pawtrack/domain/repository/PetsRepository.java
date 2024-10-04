package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.repository;

import java.util.List;

import ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models.Pet;

public interface PetsRepository {
    void addPetProfile(Pet pet);
    void editPetProfile(int petId, Pet updatedPet);
    void deletePetProfile(int petId);
    List<Pet> getAllStaticData();
    void addActivity(int petId, String activity);
    List<String> getStaticDataActivity(int petId);
    void addWeight(int petId, double weight);
    List<Double> getStaticDataWeight(int petId);
}
