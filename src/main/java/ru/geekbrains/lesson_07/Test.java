package ru.geekbrains.lesson_07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) throws Exception {

        ArrayList<Plate> plateList = getPlates();
        HashSet<Cat> catCollection = getCats();
        Master master = new Master("Bob", plateList, catCollection, 80);

        //подписка хозяина только на третью миску
        plateList.get(2).addMaster(master);
        //подписка котов на хозяина
        for (Cat c: catCollection) {
            master.addCats(c);
        }

        showInfoForPlates(plateList);
        System.out.println();
        catsGoToEat(plateList, catCollection);
        System.out.println();
        showInfoForPlates(plateList);
        System.out.println();
        Thread.sleep(1500);
        catsAreHungry(catCollection);
        System.out.println();
        /*здесь коты доедают еду. Миска №3 оповещает хозяина, что миски пусты. Хозяин наполняет миски едой и оповещает котов,
        что миски полные. Коты идут есть.
         */
        catsGoToEat(plateList, catCollection);
        System.out.println();
        showInfoForPlates(plateList);

    }

    private static void catsAreHungry(HashSet<Cat> catCollection) throws InterruptedException {
        for (Cat cat : catCollection) {
            cat.setSatiety(false);
            Thread.sleep(500);
        }
    }

    private static void catsGoToEat(ArrayList<Plate> plateList, Collection<Cat> catCollection) throws InterruptedException {
        for (Cat cat : catCollection) {
            cat.eat(plateList);
        }
    }

    private static void showInfoForPlates(ArrayList<Plate> plateList) {
        for (Plate plate: plateList){
            plate.printInfo();
        }
    }

    public static HashSet<Cat> getCats(){
        HashSet<Cat> catShelter = new HashSet<>();
        catShelter.add(new Cat("Tom", 15));
        catShelter.add(new Cat("Martin", 18));
        catShelter.add( new Cat("Barsic", 20));

        return catShelter;
    }

    public static ArrayList<Plate> getPlates(){
        ArrayList<Plate> plates = new ArrayList<>();
        try {
            plates.add(new Plate(1));
            plates.add(new Plate(2));
            plates.add(new Plate(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plates;
    }
}
