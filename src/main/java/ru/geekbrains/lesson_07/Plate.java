package ru.geekbrains.lesson_07;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Plate {

    ///////методы наблюдаемого для миски
    List<Master> masters= new ArrayList<>();

    public void addMaster(Master m){
         masters.add(m);
    }

    public void removeMaster(Master m){
        masters.remove(m);
    }

    private void notifyObservers() throws InterruptedException {
        System.out.println("(сообщение хозяину - добавь еды в миски)");
        for (Master m: masters) {
            m.update();
        }
    }
    /////////

    public int getNumber() {
        return number;
    }

    private int number;
    private static final int MAX_FOOD = 30;
    private int food;

    public int getFood() {
        return food;
    }

    public Plate(int number, int food) throws Exception {
        this.number = number;
        if (food > MAX_FOOD) throw new Exception(" В миске не может быть еды больше " + MAX_FOOD);
        else this.food = food;
    }

    public Plate(int number) throws Exception {
        this(number, MAX_FOOD);
    }

    public int addFood(int food){
        this.food += food;
        if (this.food > MAX_FOOD) {
            int temp = this.food;
            this.food = MAX_FOOD;
            System.out.println(" Миска №" + this.number + " полная!");
            return temp - MAX_FOOD;
        } else {
            System.out.println(" В миску №" + this.number + " не досыпали " + (MAX_FOOD - food) + " еды.");
            return 0;
        }
    }

    public void printInfo(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "В миске " +
                "№ " + number +
                " еда = " + food;
    }

    public void decreaseFood(int foodCount) throws InterruptedException {
        if (this.food > foodCount){
            this.food -= foodCount;
            System.out.println("В миске №" + this.number + " осталось " + this.food + " еды.");
        } else {
            System.out.println("Миска №" + this.number + " пуста!");
            this.food = 0;
            notifyObservers();//оповещаем наблюдателей о том, что миска пуста
        }
    }
}
