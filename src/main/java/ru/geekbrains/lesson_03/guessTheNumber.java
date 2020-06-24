package ru.geekbrains.lesson_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 024 24.06.20.
 */
public class guessTheNumber {
    private static int generatedNumber;
    private static int numberOfUser;
    private static int countTry;
    private static boolean check;
    private static boolean replay = true;

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        System.out.print("Здравствуй User. ");
        do {
            check = false;
            countTry = 3;
            generatedNumber = numberGenerator();
            System.out.println("Я загадал число от 0 до 9.\nПопрорбуй угадай. У тебя три попытки");
            while (countTry > 0){
                numberOfUser = readerNumberOfUser();
                System.out.println(comparMethod(generatedNumber, numberOfUser));
                if (check) break;
            }
            if (!check) System.out.println("Ты проиграл.");
            System.out.println("Повторить игру ещё раз? 1 - да / 0 - нет");
            while (true){
                String s = reader.readLine();
                if (s.equals("1")) {
                    replay = true; break;
                }
                else if (s.equals("0")) {
                    replay = false; break;
                }
                else {
                    System.out.println("Тебе нужно ввести либо 1, либо 0");
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
    public static String comparMethod(int genNum, int userNum){
        String str;
        if (genNum == userNum) {
            check = true;
            return str = "Ты угадал.";
        }
        else{
            check = false;
            countTry--;
            return str = genNum > userNum ? "Твоё число меньше. Можешь попробывать ещё " + countTry + " раз(а)"
                    : "Твоё число больше. Можешь попробывать ещё " + countTry + " раз(а)";
        }
    }
}
