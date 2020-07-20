package ru.geekbrains.lesson_06;

import java.util.Random;

/**
 * Created by User on 018 18.07.20.
 */
public class Tset {
    public static void main(String[] args) throws InterruptedException {
        Action[] animals = new Action[]{
                new Cat("Tom", 10, 0.5),
                new Dog("Bobik", 50, 4, 0.3),
                new Cat("Barsik", 5, 0.4),
                new Dog("Flash", 10, 2, 0.2),
        };

        for (Action animal : animals) {
            if (animal instanceof Cat){
                animal.run(Cat.MAX_RANGE_TO_RUN + (int) (Math.random() * -21 + 10));//расброс в беге для котов +-10
                animal.swim(Cat.MAX_RANGE_TO_SWIM);//расброс в плавании для котов не принципиален, кот не поплывёт
                animal.jump(Cat.MAX_RANGE_TO_JUMP + (Math.random() * -1.1 + 0.5));//расброс в плавании для собак +-0.5

            }
            if (animal instanceof Dog){
                animal.run(Dog.MAX_RANGE_TO_RUN + (int) (Math.random() * -101 + 50));//расброс в беге для собак +-50
                animal.swim(Dog.MAX_RANGE_TO_SWIM + (int) (Math.random() * -3 + 1));//расброс в плавании для собак +-1
                animal.jump(Dog.MAX_RANGE_TO_JUMP + (Math.random() * -0.5 + 0.2));//расброс в плавании для собак +-0.2
            }
            Thread.sleep(500);
        }
        System.out.println("В соревнованиях участвовали: " +
                "\n- коты в количестве " + Cat.getCountCats() +
                "\n- собаки в количестве " + Dog.getCountDogs() +
                "\nВсего было " + Animal.getCountAnimals() + " животных");
    }
}
