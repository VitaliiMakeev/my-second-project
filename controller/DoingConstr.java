package org.example.controller;

import org.example.moduls.Toy;

import java.util.Queue;

public interface DoingConstr {
    Queue<Toy> get(int n);
    int getChance();
    void printQueue(Queue<Toy> queue);
}
