package ru.geekbrains.lesson_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 016 16.06.20.
 */
public class FirstApp {
        //2
    byte aByte = 8;
    static short aShort = Short.MAX_VALUE;
    private static int e = 6, f = 10, g = -2;
    long aLong = 100000000L;
    private static float a = 4.5f, b = 6.7f, c = 10.2f, d = 5.9f;
    double aDouble = 124.436;
    char aChar = 'g';
    private static boolean isChenge = false;

    private static String name = "myName";
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("пункт 1. " + aShort);
        //3
        System.out.println("пункт 3. " + arithmeticMethod(a, b, c, d));

        //4
        System.out.println("пункт 4. " + logicMethod01(e, f));

        //5
        System.out.println("пункт 5. " + logicMethod02(e));

        //6
        System.out.println("пункт 6. " + logicMethod03(g));

        //7
        System.out.print("пункт 7. ");
        while (true){
            System.out.println("Введите ваше имя");
            name = reader.readLine();
            if (!(name.isEmpty())) {
                methodForName(name);
                break;
            }
            else System.out.println("Вы не ввели имя");
        }

        //8
        System.out.print("пункт 8. ");
        while (true){
            System.out.println("Введите год");
            String year = reader.readLine();
            if (!(year.isEmpty())) {
                try {
                    methodForYear(Integer.parseInt(year));
                    break;
                } catch (NumberFormatException e1) {
                    System.out.println("вы ввели не год");
                }
            }
            else System.out.println("Вы не ввели год!!!");
        }
    }

    //3
    public static float arithmeticMethod (float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    //4
    public static boolean logicMethod01 (int a, int b){
        return (a + b) >= 10 && (a + b) <= 20;
    }

    //5
    public static String logicMethod02 (int a){
        if (a >= 0) return "Positive";
        else return "Negative";
    }

    //6
    public static boolean logicMethod03 (int a){
        return a < 0;
    }

    //7
    public static void methodForName (String name){
        System.out.println("Привет, " + name);
    }

    //8
    private static void methodForYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) System.out.println(year + " - высокосный год");
        else System.out.println(year + " - невысокосный год");
    }

}
