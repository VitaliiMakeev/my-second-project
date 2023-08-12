package org.example.controller;

import org.example.moduls.Toy;

import java.util.Queue;

public interface IController2 {
    Toy get();
    Queue<Toy> getToyQueue();
}
