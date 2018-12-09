package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 05.09.2018.
 */
public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;
    Horse winner;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {

        for (int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move(){
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).move();
        }

    }

    public void print(){
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    public Horse getWinner(){
        winner = horses.get(0);
        for (int i = 0; i < horses.size(); i++){
            if (horses.get(i).distance > winner.distance) winner = horses.get(i);
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().name + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        Horse h1 = new Horse("Secunda", 3, 0);
        Horse h2 = new Horse("Meteor", 3, 0);
        Horse h3 = new Horse("Ferrari", 3, 0);
        List<Horse> list = new ArrayList<>();
        list.add(h1); list.add(h2); list.add(h3);
        game = new Hippodrome(list);
        game.run();
        game.printWinner();

    }

}
