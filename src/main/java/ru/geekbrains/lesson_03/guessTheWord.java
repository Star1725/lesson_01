package ru.geekbrains.lesson_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 024 24.06.20.
 */
public class guessTheWord {
    private static String hiddenWord;
    private static int countTry;
    private static boolean check;
    private static int i = 0;
    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.print("Здравствуй User. ");
        hiddenWord = wordsGenerator();//генерация слова
        //hiddenWord = "pea"; //для тестирования случая, когда заканчивается длинна слова
        System.out.println("Я загадал одно из этих слов:");

        for (String word: words) {
            System.out.printf(" %s ", word);
            i++;
            if (i == 8 || i == 16) System.out.println();
        }
        System.out.println();
        System.out.println("Попрорбуй угадай.");

        do {
            String usersWord = readerWordOfUser();
            System.out.println(compareMethod(hiddenWord, usersWord));
        } while (!check);
    }

    //метод генерации случайного слова из массива с индексами от 0 до 24
    public static String wordsGenerator(){
        return words[(int)(Math.random() * 25)];
    }

    //метод чтения пользоательского ввода слова
    public static String readerWordOfUser() throws IOException{
        String word;
        while (true){
            word = reader.readLine();
            if (word.isEmpty()) System.out.println("Вы не ввели слово!");
            else break;
            }
        return word.trim();
    }

    //метод сравнения слов
    public static String compareMethod(String genWord, String userWord){
        if (genWord.equals(userWord)) {
            check = true;
            return "Ты угадал. Количество попыток: " + ++countTry;
        }
        else {
            check = false;
            return "Не угадал. " + giveHint(countTry++);

        }
    }

    //метод выводящий подсказку
    public static String giveHint (int countTry){
        String hint = "";
        for (int i = 0; i <= countTry; i++){
            try {
                hint += hiddenWord.charAt(i);
            } catch (StringIndexOutOfBoundsException e) {
                //e.printStackTrace();
                return "Извини, попыток больше нет, буквы кончились. Я загадал слово - " + hiddenWord;
            }
        }
        return "Вот подсказка - " + hint + "?????????????";
    }
}
