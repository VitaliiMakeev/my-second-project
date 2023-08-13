package org.example.moduls;

import java.util.List;

public class Toy {
    private int id;
    private String name;
    private int weight;
    private int count;
    public Toy(Shop shop, String name, int weight, Integer count) {
        if (weight > 100 | weight < 1){
            throw new RuntimeException("Частота выпадения должна быть не больше 100 и не меньше 1!");
        }
        // if (count < 0 | count != weight){
            // throw new RuntimeException("Частота выпадения должна ровняться количеству игрушек!");
        // }
        this.id = shop.getIdToys();
        shop.setIdToys();
        this.name = name;
        this.weight = weight;
        this.count = count;
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

    public int getCount(){
        return this.count;
    }

    public void setCount(int n){
        this.count = n;
    }

    @Override
    public String toString() {
        return id + " " + weight + " " + name + " " + count;
    }
}
