package ru.geekbrains.lesson_02;

/**
 * Created by User on 021 21.06.20.
 */
public class MainClass {
    private static int[] arr5 = {4, 2, 9, 12, 5, 7, 19, 2, 19};
    private static int[] arr6 = {1, 1, 2, 1, 3, 2};
    private static int[] arr7 = {0, 1, 2, 3, 4, 5, 6, 7, 9};
    private static int n = -6;
    public static void main(String[] args) {
        //5
        System.out.println("пункт 5. для массива {4, 2, 9, 12, 5, 7, 19, 2, 19}");
        int[] arrMinMax = getMinMaxOfArray(arr5);
        System.out.println("min = " + arrMinMax[0] + ", max = " + arrMinMax[1]);
        System.out.println();

        //6
        System.out.println("пункт 6. для массива {1, 1, 2, 1, 3, 2}");
        System.out.println("Balance is " + getEqualityOfSums(arr6));
        System.out.println();

        //7
        System.out.println("пункт 7. ");
        //отобразить исходный массив
        for (int x: arr7){
            System.out.print(x + " ");
        }
        System.out.println(", сместить на " + n);
        //отобразить сдвинутый массив
        for (int x: slipMethod(arr7, n)) {
            System.out.print(x + " ");
        }
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
