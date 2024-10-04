package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models;

public class Pet {
    private int id;
    private String name;
    private int age;
    private String breed;
    private String category;
    private String pictureUrl;

    public Pet(int id, String name, int age, String breed, String category, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.category = category;
        this.pictureUrl = pictureUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String getCategory() {
        return category;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
