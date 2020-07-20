package ru.geekbrains.lesson_07;

import java.util.*;

public class Master {
    private String name;
    private ArrayList<Plate> plateList;

    private int mastersFood;

    public Master(String name, ArrayList<Plate> plateList, HashSet<Cat> catHashSet, int mastersFood) {
        this.name = name;
        this.plateList = plateList;
        this.catHashSet = catHashSet;
        this.mastersFood = mastersFood;
    }

    public void update() throws InterruptedException {
        System.out.println();
        System.out.println("Хозяин " + this.name + " распределил по мискам " + this.mastersFood + " еды.");
        for (Plate plate : plateList) {
            this.mastersFood = plate.addFood(this.mastersFood);
        }
        System.out.print("У хозяина осталось " + this.mastersFood + " еды.");
        notifyObservers();
    }

    //////наблюдаемый
    private HashSet<Cat> catHashSet;

    public void addCats(Cat с){
        catHashSet.add(с);
    }

    public void removeCats(Cat с){
        catHashSet.remove(с);
    }

    private void notifyObservers() throws InterruptedException {
        System.out.println("(сообщение котам - можно кушать)");
        System.out.println();
        for (Cat с: catHashSet) {
            с.eat(plateList);
        }
    }
    ////////
}
