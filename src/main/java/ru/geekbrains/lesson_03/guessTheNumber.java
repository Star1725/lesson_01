package ru.geekbrains.lesson_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 024 24.06.20.
 */
public class guessTheNumber {
    private static int countTry;
    private static boolean check;

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        System.out.print("Здравствуй User. ");//Приветствие. выбодится только при запуске игры
        boolean replay;//переменная для повторения игры
        do {
            //начальные условия
            countTry = 3;//количество попыток = 3
            check = false;//мы пока не угадали
            int generatedNumber = numberGenerator(); //программа загадала число
            System.out.println("Я загадал число от 0 до 9.\nПопробуй угадай. У тебя есть три попытки");

            while (countTry >= 1){//контролируем количество попыток
                int numberOfUser = readerNumberOfUser();//считываем число пользователя
                countTry--;//отнимаем одну попытку
                System.out.println(compareMethod(generatedNumber, numberOfUser));//выводим результат котроля попыток и сравнения чисел
                if (check) break;//если числа совпали, User выиграл
            }

            System.out.println("Повторить игру ещё раз? 1 - да / 0 - нет");
            label:
            while (true) {
                String s = reader.readLine();
                switch (s) {
                    case "1":
                        replay = true;
                        break label;
                    case "0":
                        replay = false;
                        break label;
                    default:
                        System.out.println("Тебе нужно ввести либо 1, либо 0");
                        break;
                }
            }
        } while (replay);
    }

    //метод генерации случайного числа от 0 до 9
    public static int numberGenerator(){
        return (int)(Math.random() * 10);
    }

    //метод чтения пользоательского ввода числа
    public static int readerNumberOfUser() throws IOException{
        int number;
        while (true){
            String n = reader.readLine();
            if (!(n.isEmpty())) {
                try {
                     number = Integer.parseInt(n);
                    break;
                } catch (NumberFormatException e1) {
                    System.out.println("вы ввели не число!");
                }
            }
            else System.out.println("Вы не ввели число!");
        }
        return number;
    }

    //метод сравнения чисел
    public static String compareMethod(int genNum, int userNum){
        //если User ввёл число за пределами диапаазона выводим предупреждение и либо просим снова ввести число,
        //либо заканчиваем игру за неимением попыток
        if (userNum < 0 || userNum > 9) return "Я же сказал от 0 до 9!  " + (countTry == 0 ? "Попытки кончились." : "Минус одна попытка.");
        //если User угадал выводим сообщение и передаём true в переменной check для выхода из цыкла
        else if (genNum == userNum){
            check = true;
            return "Ты угадал.";
        }
        //если попытки закончились, то выводим сообщение о конце игры
        else if(countTry == 0)return "Попытки кончились. GAME OVER!!! Я загадал - " + genNum;
        //если число больше/меньше выводим соответствующее сообщение с количеством оставшихся попыток
        else{
            return genNum > userNum ? "Твоё число меньше. Можешь попробывать ещё " + countTry + " раз(а)"
                    : "Твоё число больше. Можешь попробывать ещё " + countTry + " раз(а)";
        }
    }
}
