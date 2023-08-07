package org.example.moduls;

import java.util.List;

public class Toy {
    private int id;
    private String name;
    private int weight;

    public Toy(Shop shop, String name, int weight) {
        this.id = shop.getIdToys();
        shop.setIdToys();
        this.name = name;
        if (weight > 9 | weight < 1){
            throw new RuntimeException("Частота выпадения должна быть не больше 9 и не меньше 1!");
        }
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return id + " " + weight + " " + name;
    }
}
