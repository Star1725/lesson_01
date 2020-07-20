package ru.geekbrains.lesson_07;

import java.util.Collection;

public class Cat {

    private String name;
    private int appetite;

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
        System.out.println("Кот " + this.name + " проголодался!");
    }

    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public Cat(String name, int appetite){
        this(name, appetite, false);
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Collection<Plate> plates) throws InterruptedException {
        if (this.satiety) {
        } else {
            for (Plate plate : plates) {
                System.out.print("Кот " + this.name + " попытался поесть из миски №" + plate.getNumber() + ".");
                Thread.sleep(800);
                if (plate.getFood() >= appetite) {
                    this.satiety = true;
                    System.out.println(" Кот сыт.");
                    doEat(plate);
                    break;
                }
                else if (plate.getFood() > 0){
                    System.out.println(" В миске было мало еды. Кот все съел, но остался голоден.");
                    doEat(plate);
                } else {
                    System.out.println(" Миска была пустая. Кот пошёл к другой");
                }
            }
        }
    }

    private void doEat(Plate plate) throws InterruptedException {
        plate.decreaseFood(appetite);
    }
}
