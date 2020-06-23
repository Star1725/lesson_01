package ru.geekbrains.lesson_02;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by User on 021 21.06.20.
 */
public class MainClass {
    //5
    private static int[] arr5Var1 = {4, 2, 9, 12, 5, 7, 19, 2, 19};
    private static int[] arr5Var2 = {264, 12, -45, 347, -1, 78, 189};

    //6
    private static int[] arr6Var1 = {1, 1, 2, 1, 3, 2};
    private static int[] arr6Var2 = {1, 5, 2, -3, 3, 2};

    //7
    private static int[] arr7Var1 = {0, 1, 2, 3, 4, 5, 6, 7, 9};
    private static int n1 = -6;
    private static int[] arr7Var2 = {0, 1, 2, 3, 4, 5, 6, 8};
    private static int n2 = 4;

    public static void main(String[] args) {
        //5
        System.out.println("пункт 5.");
        System.out.println("для массива " + Arrays.toString(arr5Var1));
        int[] arrMinMax = getMinMaxOfArray(arr5Var1);
        System.out.println("min = " + arrMinMax[0] + ", max = " + arrMinMax[1]);
        System.out.println("для массива " + Arrays.toString(arr5Var2));
        arrMinMax = getMinMaxOfArray(arr5Var2);
        System.out.println("min = " + arrMinMax[0] + ", max = " + arrMinMax[1]);
        System.out.println();

        //6
        System.out.println("пункт 6.");
        System.out.println("для массива " + Arrays.toString(arr6Var1) + " balance is " + getEqualityOfSums(arr6Var1));
        System.out.println("для массива " + Arrays.toString(arr6Var2) + " balance is " + getEqualityOfSums(arr6Var2));
        System.out.println();

        //7
        System.out.println("пункт 7. ");
        System.out.println("" + Arrays.toString(arr7Var1) + " сместить на " + n1);
        System.out.println("" + Arrays.toString(slipMethod(arr7Var1, n1)));
        System.out.println("" + Arrays.toString(arr7Var2) + " сместить на " + n2);
        System.out.println("" + Arrays.toString(slipMethod(arr7Var2, n2)));
    }

    //5
    public static int[] getMinMaxOfArray (int[] arr){
        for (int j = 0; j < arr.length - 1; j++){
            for (int i = 0; i < arr.length - 1 - j; i++){
                int buf;
                if (arr[i] > arr[i + 1]){
                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
            }
        }
        return new int[]{arr[0], arr[arr.length - 1]};
    }

    //6
    public static boolean getEqualityOfSums (int[] arr){
        boolean balance = false;
        int num = 1;
        while (num <= arr.length - 1){
            int sumLeft, sumRight;
            sumLeft = sumRight = 0;
            //вычисляем sumLeft
            for (int i = 0; i < num; i++){
                sumLeft = sumLeft + arr[i];
            }
            //вычисляем sumRight
            for (int i = arr.length - 1; i >= num; i--){
                sumRight= sumRight + arr[i];
            }
            if (sumLeft == sumRight) {
                balance = true;
                break;
            }
            num++;
        }
        return balance;
    }

    //7
    //метод для сдвига массива
    public static int[] slipMethod (int [] arr, int n){
        int buf;
        int moveIndex = 0;
        int startIndex;

        for (int j = 0; j < gcd(arr.length, n); j++){//вычесляем НОД, чтобы узнать на сколько непересекающихся последовательностей можно разложить массив
                                                     //если НОД = 1, то startIndex = 0 и проходим по всем элементам массива
                                                     //если НОД = 2, то по массиву нужно будет пройти два раза для startIndex = 0 и startIndex = 1, и
            while (true){
                //вычесляем индекс для переноса
                moveIndex = moveIndex + Math.abs(n);
                //если индекс переноса больше длинны массива, вычисляем его с учётом перехода в начало (конец) массива
                if (moveIndex >= arr.length) moveIndex = moveIndex % arr.length;
                if (n >= 0){//"жанглируем" вправо
                    //вычичляем стартовый индекс, в который в итоге должны вернуться
                    startIndex = j;
                    if (moveIndex + j == startIndex) break; //если индекс перемещения равен стартовому, мы завершили цикл "жанглирования"
                    //чтобы не потерять, запомним элемент индекса переноса
                    buf = arr[moveIndex + j];
                    //перенесим 1-й элемент для переноса в индекс для переноса
                    arr[moveIndex + j] = arr[startIndex];
                    //сохраняем в стартовый индекс следующий элемент для переноса
                    arr[startIndex] = buf;
                } else {//"жанглируем" влево
                    //стартовые индексы начинаем брать с конца массива
                    startIndex = arr.length - 1 - j;
                    //далее всё зеркально
                    if (arr.length - 1 - moveIndex - j == startIndex) break;
                    buf = arr[arr.length - 1 - moveIndex - j];
                    arr[arr.length - 1 - moveIndex - j] = arr[startIndex];
                    arr[startIndex] = buf;
                }
            }
        }
        return arr;
    }

    //метод для вычисления наибольшего общего делителя (НОД)
    static int gcd(int a, int b){
        while (b != 0) {
            int buf = b;
            b = a % b;
            a = buf;
        }
        return Math.abs(a);
    }
}
