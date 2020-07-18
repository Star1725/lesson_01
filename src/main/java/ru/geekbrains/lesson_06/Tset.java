package ru.geekbrains.lesson_06;

import java.util.Random;

/**
 * Created by User on 018 18.07.20.
 */
public class Tset {
    public static void main(String[] args) throws InterruptedException {
        Action[] animals = new Action[]{
                new Cat("Tom"),
                new Dog("Bobik"),
                new Cat("Barsik"),
                new Dog("Flash"),
                new Dog("Barbos"),
                new Cat("Fred"),
                new Dog("Killer")
        };

        for (Action animal : animals) {
            if (animal instanceof Cat){
                animal.run(200 + (int) (Math.random() * -7 + 3));
                animal.swim(0);
            }
            if (animal instanceof Dog){
                animal.run(500 + (int) (Math.random() * -21 + 10));
                animal.swim(10 + (int) (Math.random() * -3 + 1));
            }
            Thread.sleep(500);
        }
        System.out.println("В соревнованиях участвовал коты в количестве " + Cat.getCountCats() +
                ", собаки в количестве " + Dog.getCountDogs() + ". Всего было " + Animal.getCountAnimals() + " животных");
    }
}
