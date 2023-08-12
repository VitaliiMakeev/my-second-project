package org.example.controller;

import org.example.moduls.Toy;

import java.util.*;

public class Controller2 implements IController2{
    List<Toy> result;
    List<Toy> toyList;
    int count;
    Queue<Toy> toyQueue;

    public Controller2(List<Toy> toyList) {
        if (toyList.size() < 3){
            throw new RuntimeException("Необходимо минимум 3 игрушки!");
        }
        this.toyQueue = new PriorityQueue<>(idToy);
        this.result = new ArrayList<>();
        this.toyList = toyList;
        this.createQueue();
    }

    /**
     * Этот метод создает список игрушек с количеством шанса выпадения
     */
    private void createQueue(){
        for (int i = 0; i < this.toyList.size(); i++) {
            for (int j = 0; j < this.toyList.get(i).getWeight(); j++) {
                this.result.add(this.toyList.get(i));
            }
        }
        this.count = result.size();
    }

    /**
     * Метод для рандомной выдачи игрушки из списка
     * @return
     */
    @Override
    public Toy get(){
        Random random = new Random();
        int n = random.nextInt(0, this.count);
        Toy toy = this.result.get(n);
        this.count--;
        this.result.remove(toy);
        this.toyQueue.add(toy);
        return toy;

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
     * Местод необходим для сохранения в файл
     * @return очередь
     */
    @Override
    public Queue<Toy> getToyQueue(){
        return this.toyQueue;
    }
}
