package ru.geekbrains.Lesson_05;

/**
 * Created by User on 018 18.07.20.
 */
public class Employee {
    private String FIO;
    private int age;
    private String Position;
    private String Email;
    private String Phone;
    private int salary;

    public Employee(String position, String FIO, int age, String email, String Phone, int salary) {
        this.Position = position;
        this.FIO = FIO;
        this.age = age;
        this.Email = email;
        this.Phone = Phone;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void printInfo(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                "FIO = " + FIO +
                ", age = " + age +
                ", Position = " + Position +
                ", Email = " + Email +
                ", phone = " + Phone +
                ", salary = " + salary;
    }
}
