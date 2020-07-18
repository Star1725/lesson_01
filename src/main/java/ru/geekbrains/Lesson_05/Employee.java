package ru.geekbrains.Lesson_05;

/**
 * Created by User on 018 18.07.20.
 */
public class Employee {
    private String FIO;
    private int age;
    private String Position;
    private String Email;
    private int phone;
    private int salary;

    public Employee(String position, String FIO, int age, String email, int phone, int salary) {
        Position = position;
        this.FIO = FIO;
        this.age = age;
        Email = email;
        this.phone = phone;
        this.salary = salary;
    }

    public void printInfo(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "FIO='" + FIO + '\'' +
                ", age=" + age +
                ", Position='" + Position + '\'' +
                ", Email='" + Email + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                '}';
    }
}
