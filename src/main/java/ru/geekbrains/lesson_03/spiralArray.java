package ru.geekbrains.lesson_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by User on 030 30.06.20.
 */
public class SpiralArray {
    private static int[][] arr;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int height = 0;
        int weight = 0;
        System.out.println("Чтобы вывести спиральный массив введите его размеры - ");
        System.out.println("Высота:");
        try {
            height = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ширена:");
        try {
            weight = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


        drawSpiral(height, weight);
    }
//     0  1  2  3
//  0  01 12 11 10
//  1  02 13 16 09
//  2  03 14 15 08
//  3  04 05 06 07

    public static void drawSpiral(int height, int weight){
        arr = new int[height][weight];
        //вычеслим кол-во разрядов для чисел массива
        int digits = Integer.toString(height * weight).length();
        int countElementArr = height * weight;
        int start = 1;
        boolean strokeRevert = false;
        boolean columnRevert = false;
        int j = 0;
        int i = 0;
        int maxIndexForI = height - 1;
        int maxIndexForJ = weight - 1;
        int minIndexForI = 0;
        int minIndexForJ = 0;
        height = maxIndexForI;
        weight = maxIndexForJ;
        int cyrcle = 0;
        System.out.println();
        System.out.println(" Начинаем цикл:");
        System.out.println("minIndexForI = " + minIndexForI);
        System.out.println("minIndexForJ = " + minIndexForJ);
        System.out.println("maxIndexForI = " + maxIndexForI);
        System.out.println("maxIndexForJ = " + maxIndexForJ);
        System.out.println();
        while (start <= countElementArr){

            if (cyrcle%4 == 0 && cyrcle != 0){

                maxIndexForI = height - 1;
                minIndexForI++;
                height = maxIndexForI;
                i = minIndexForI;

                maxIndexForJ = weight - 1;
                minIndexForJ++;
                weight = maxIndexForJ;
                j = minIndexForJ;

                System.out.println("Начинаем новый цикл:");
                System.out.println("minIndexForI = " + minIndexForI);
                System.out.println("minIndexForJ = " + minIndexForJ);
                System.out.println("maxIndexForI = " + maxIndexForI);
                System.out.println("maxIndexForJ = " + maxIndexForJ);
                System.out.println();
            }

            if (start == countElementArr){
                arr[maxIndexForI][maxIndexForJ] = countElementArr;
                break;
            }

            //заполняем столбец
            System.out.println("заполняем столбец");
            if (columnRevert){
                for (; i > minIndexForI; i--){
                    System.out.println(i + " : " + j + " <- " + start);
                    arr[i][j] = start++;
                    for (int[] ints: arr){
                        System.out.println(Arrays.toString(ints));
                    }
                    System.out.println();
                }
                //maxIndexForI--;
            }
            else {
                for (; i < maxIndexForI; i++){
                    System.out.println(i + " : " + j + " <- " + start);
                    arr[i][j] = start++;
                    for (int[] ints: arr){
                        System.out.println(Arrays.toString(ints));
                    }
                    System.out.println();
                }
            }
            columnRevert = columnRevert == false ? true : false;
            cyrcle++;


            System.out.println();
            System.out.println("i = " + i + ", j = " + j + ", height = " + height + ", columnRevert = " + columnRevert + ", strokeRevert = " + strokeRevert  + ", cyrcle = " + cyrcle);
            System.out.println();

            if (start > countElementArr){
                break;
            }

            //заполняем строку
            System.out.println("заполняем строку");
            if (strokeRevert){
                for (; j > minIndexForJ; j--){
                    System.out.println(i + " : " + j + " <- " + start);
                    arr[i][j] = start++;
                    for (int[] ints: arr){
                        System.out.println(Arrays.toString(ints));
                    }
                    System.out.println();
                }
                //maxIndexForJ--;
            }
            else {
                for (; j < maxIndexForJ; j++){
                    System.out.println(i + " : " + j + " <- " + start);
                    arr[i][j] = start++;
                    for (int[] ints: arr){
                        System.out.println(Arrays.toString(ints));
                    }
                    System.out.println();
                }
            }

            strokeRevert = strokeRevert == false ? true : false;
            cyrcle++;
            System.out.println();
            System.out.println("i = " + i + ", j = " + j + ", weight = " + weight + ", columnRevert = " + columnRevert + ", strokeRevert = " + strokeRevert + ", cyrcle = " + cyrcle);
            System.out.println();
        }

        //итог
        System.out.println(" Итоговая таблица - ");
        for (int[] ints: arr){
            for (int n: ints) {
                System.out.printf("%" + (digits + 1) + "d", n);
            }
            System.out.println();
        }
    }
}
