package ru.geekbrains.lesson_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by User on 002 02.07.20.
 */
public class NumbersOfPhibonachi {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        System.out.println(" Для расчёта суммы периодов квадратов, заданных числовой последователиностью Фибоначчи");
        System.out.println(" введите количество квадратов:");
        int n = 0;
        BigInteger sum = BigInteger.valueOf(0);
        try {
             n = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        BigInteger[] arr = new BigInteger[n + 1];

        for (int i = 0; i < arr.length; i++) {
            if (i <= 1) arr[i] = BigInteger.valueOf(1);
            else {
                arr[i] = arr[i - 1].add(arr[i - 2]);
            }
            //оганичение для int не более 46 квадратов
            sum = sum.add(arr[i]);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(" Сумма периметров " + n + " + 1 квадратов = " + (sum.multiply(BigInteger.valueOf(4))));
    }
}
