package org.example.controller;

import org.example.moduls.Toy;

import java.util.*;
import java.util.stream.IntStream;

public class Controller implements DoingConstr{
    private List<Toy> toys;
    private int[] arrId;
    private int[] arrWiht;


    public Controller(List<Toy> toys) {
        if (toys.size() < 3) {
            throw new RuntimeException("Необходимо минимум 3 игрушки!");
        }
        this.toys = toys;
        this.arrId = new int[toys.size()];
        this.arrWiht = new int[toys.size()];
        for (int i = 0; i < toys.size(); i++) {
            arrId[i] = toys.get(i).getId();
            arrWiht[i] = toys.get(i).getWeight() * 10;
        }

    }

    /**
     * Метод для вывода в консоль очереди на выпадение игрушек
     * @param queue очередь
     */
    @Override
    public void printQueue(Queue<Toy> queue){
        for (Toy toy : queue) {
            System.out.println(toy);
        }
    }

    /**
     * Возвращает очередь из игрушек
     * @param n количество игрушек в очереди
     * @return очередь
     */
    @Override
    public Queue<Toy> get(int n){
        Queue<Toy> toyQueue = new PriorityQueue<>(n, idToy);
        for (int i = 0; i < n; i++) {
            int tmp = this.getChance();
            for (int j = 0; j < toys.size(); j++) {
                if (toys.get(j).getId() == tmp){
                    toyQueue.add(toys.get(j));
                }
            }
        }
        return toyQueue;
    }

    /**
     * Компоратор для очереди
     */
    private static Comparator<Toy> idToy = new Comparator<Toy>() {
        @Override
        public int compare(Toy o1, Toy o2) {
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };

    /**
     * Метод для генерации id игрушки исходя из параметров ее шансов
     * @return id игрушки
     */
    @Override
    public int getChance() {
        int[] arrIdSort = this.sortArr(arrId);
        int[] arrWihtSort = this.sortArr(arrWiht);
        int result = 0;
        int count = IntStream.of(arrWihtSort).sum();
        Random random = new Random();
        int index = random.nextInt(count);
        for (int i = 0; i < arrWihtSort.length; i++) {
            index -= arrWihtSort[i];
            if (index < 0) {
                result =  arrIdSort[i];
                break;
            }
        }
        return result;
    }

    /**
     * Сортировка массива (вспомогательный метод)
     * @param array массив чисел
     * @return отсортированный массив чисел
     */
    private int[] sortArr(int[] array){
        boolean flag = true;
        while (flag){
            int tmp = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]){
                    int tmp2 = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp2;
                    tmp++;
                }
            }
            if (tmp == 0){
                flag = false;
            }
        }
        return array;
    }

}
