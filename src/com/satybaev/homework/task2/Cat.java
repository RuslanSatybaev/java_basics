package com.satybaev.homework.task2;

public class Cat {
    private String name;
    private int age;
    private int weight;
    private int strength;

//    private boolean fight(Cat anotherCat){
//        cat
//    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "Sharik";
        cat1.age = 1;
        cat1.weight = 12;
        cat1.strength = 5;

        Cat cat2 = new Cat();
        cat2.name = "Vaska";
        cat2.age = 2;
        cat2.weight = 22;
        cat2.strength = 3;

        Cat cat3 = new Cat();
        cat3.name = "Mursik";
        cat3.age = 3;
        cat3.weight = 32;
        cat3.strength = 7;
    }
}
