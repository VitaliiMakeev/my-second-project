package org.example;


import org.example.controller.Controller;
import org.example.moduls.Shop;
import org.example.moduls.Toy;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Toy toy1 = new Toy(shop, "конструктор", 2);
        Toy toy2 = new Toy(shop, "робот", 2);
        Toy toy3 = new Toy(shop, "кукла", 6);
        List<Toy> toys = new ArrayList<>(Arrays.asList(toy1, toy2, toy3));
        System.out.println(toys);
         Controller controller = new Controller(toys);
         controller.printQueue(controller.get(10));


        /*
        int[] number = new int[]{1, 2, 3};
        int[] chanse = new int[]{60, 20, 20};
        int count = IntStream.of(chanse).sum();


        Random random = new Random();
        for (int randomNumsCount = 0; randomNumsCount < 10; randomNumsCount++) {

            int index = random.nextInt(count); // Выбираем случайный индекс из воображаемого массива

            for (int i = 0; i < chanse.length; i++) { // Ищем элемент, которому принадлежит этот индекс
                index -= chanse[i];
                if (index < 0) {
                    System.out.println("Случайное число: " + number[i]);
                    break;

                }
            }
        }

         */
        /*
        Queue<Toy> toyQueue = new PriorityQueue<>(10, idToy);
        for (int i = 0; i < toys.size(); i++) {
            toyQueue.add(toys.get(i));
        }
        System.out.println(toyQueue);

         */

    }
    public static Comparator<Toy> idToy = new Comparator<Toy>() {
        @Override
        public int compare(Toy o1, Toy o2) {
            return 0; // (int) (o1.getId() - o2.getId());
        }
    };
}