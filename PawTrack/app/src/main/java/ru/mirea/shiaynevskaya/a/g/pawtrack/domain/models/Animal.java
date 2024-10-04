package ru.mirea.shiaynevskaya.a.g.pawtrack.domain.models;

public class Animal {
    private int id;
    private String name; //подразумевается название породы
    private String category;
    private String pictureUrl;

    public Animal(int id, String name, String category, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.pictureUrl = pictureUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

}
