package ru.geekbrains.lesson_04;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by User on 010 10.07.20.
 */
public class TicTacToe_3_3 {
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_HUMAN = 'X';
    public static final char DOT_AI = 'O';
    public static final String EMPTY = " ";
    public static final String FIRST_EMPTY_CHAR = "  ";

    public static char [][] map = new char[SIZE][SIZE];
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        turnGame();
    }

    private static void turnGame() {
        initMap();

        printMap();

        playGame();
    }

    private static void playGame() {
        while (true){
            humanTurn();
            printMap();

            //проверка на победу или ничью
            if (checkEnd(DOT_HUMAN, "Вы выиграли!")) System.exit(0);
            //ход АИ
            aiTurn();

            printMap();
            //проверка на победу или ничью
            if (checkEnd(DOT_AI, " Вы проиграли :( ")) System.exit(0);
        }
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHeader();

        printMapRows();
    }

    private static void printMapHeader() {
        System.out.print(FIRST_EMPTY_CHAR);
        for (int i = 0; i < SIZE; i++) {
            printNumber(i);
        }
        System.out.println();
    }

    private static void printNumber(int i) {
        System.out.print(i+1 + EMPTY);
    }

    private static void printMapRows() {
        for (int i = 0; i < SIZE; i++) {
            printNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn() {
        int rowNum, colNum;
        do {
            System.out.println("Ход пользователя. Введите номер строки и столбца");
            System.out.print("Строка = ");
            rowNum = scanner.nextInt();
            System.out.print("Столбец = ");
            colNum = scanner.nextInt();
        } while (!isCellValid(rowNum, colNum, DOT_HUMAN));
        map[rowNum - 1][colNum - 1] = DOT_HUMAN;
    }

    private static boolean isCellValid(int rowNum, int colNum, char symbol) {

        boolean isHuman = symbol == DOT_HUMAN;

        if ((rowNum < 1 || rowNum > SIZE) || (colNum < 1 || colNum > SIZE)){
            if (isHuman)
            System.out.println("\nПроверте значение строки и столбца! ");
            return false;
        }

        if (map[rowNum - 1][colNum - 1] != DOT_EMPTY){
            if (isHuman)
            System.out.println("\nВы выбрали занятую ячейку! ");
            return false;
        }
        return true;
    }

    private static void aiTurn() {
        //если checkAITurnOfHuman() возвращает true, блокировать хон человека не надо
        //если checkAITurnOfHuman() возвращает false, в сомом методе checkAITurnOfHuman() AI заблокирует ход человека
        while (checkAITurnOfHuman()){
            int rowNum, colNum;
            do {
                rowNum = random.nextInt(SIZE) + 1;
                colNum = random.nextInt(SIZE) + 1;
            } while (!isCellValid(rowNum, colNum, DOT_AI));
            //если свободна центральная ячейка или угловые ячейки центрального массива, AI ходит туда
            if (map[(SIZE - 1)/2][(SIZE - 1)/2] == DOT_EMPTY){
                map[(SIZE - 1)/2][(SIZE - 1)/2] = DOT_AI;
            }
            else if(map[SIZE - DOTS_TO_WIN][SIZE - DOTS_TO_WIN] == DOT_EMPTY) map[SIZE - DOTS_TO_WIN][SIZE - DOTS_TO_WIN] = DOT_AI;
            else if(map[SIZE - DOTS_TO_WIN][DOTS_TO_WIN] == DOT_EMPTY) map[SIZE - DOTS_TO_WIN][DOTS_TO_WIN] = DOT_AI;
            else if(map[DOTS_TO_WIN][DOTS_TO_WIN] == DOT_EMPTY) map[DOTS_TO_WIN][DOTS_TO_WIN] = DOT_AI;
            else if(map[DOTS_TO_WIN][SIZE - DOTS_TO_WIN] == DOT_EMPTY) map[DOTS_TO_WIN][SIZE - DOTS_TO_WIN] = DOT_AI;
            else map[rowNum - 1][colNum - 1] = DOT_AI;
            break;
        }
    }

    private static boolean checkAITurnOfHuman() {
        int checkMainDiagonal = 0;
        int checkReverseDiagonal = 0;
        //проверяем внутренний массив
        for (int i = SIZE - DOTS_TO_WIN; i < DOTS_TO_WIN; i++) {
            //проверяем строку
            if (checkAIRowsAndColumns(i, 0)) return false;
            //проверяем столбец
            if (checkAIRowsAndColumns(i, 1)) return false;

            //проверяем главную диагональ
            if (map[i][i] == DOT_HUMAN) checkMainDiagonal++;
            if (checkMainDiagonal == DOTS_TO_WIN/2){
                for (i = SIZE - DOTS_TO_WIN; i < DOTS_TO_WIN; i++){
                    if (map[i][i] == DOT_EMPTY ){
                        map[i][i] = DOT_AI;
                        return false;
                    }
                }
            }
            //проверяем обратную диагональ
            if (map[i][DOTS_TO_WIN - i] == DOT_HUMAN) checkReverseDiagonal++;
            if (checkReverseDiagonal == DOTS_TO_WIN/2){
                for (i = SIZE - DOTS_TO_WIN; i < DOTS_TO_WIN; i++){
                    if (map[i][DOTS_TO_WIN - i] == DOT_EMPTY ){
                        map[i][DOTS_TO_WIN - i] = DOT_AI;
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean checkAIRowsAndColumns(int i,  int flag) {
        int checkHuman = 0;
        for (int j = SIZE - DOTS_TO_WIN; j < DOTS_TO_WIN; j++) {
            //flag = 0 - проверяем строку, flag = 1 - проверяем столбец
            if (flag == 0){
                if (map[i][j] == DOT_HUMAN) checkHuman++;
            } else {
                if (map[j][i] == DOT_HUMAN) checkHuman++;
            }
        }
        //если в строке или столбце два крестика то в третью ячейку ставим ноль(блокируем ход человека)
        if (checkHuman == 2) {
            for (int j = SIZE - DOTS_TO_WIN; j < DOTS_TO_WIN; j++) {
                //flag = 0 - вставляем в строку, flag = 1 - вставляем в столбец
                if (flag == 0){
                    if (map[i][j] == DOT_EMPTY){
                        map[i][j] = DOT_AI;
                        return true;
                    }
                } else {
                    if (map[j][i] == DOT_EMPTY){
                        map[j][i] = DOT_AI;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkEnd(char symbol, String winMessage) {
        if (checkWin(symbol)){
            System.out.println(winMessage);
            return true;
        }

        if (isMapFull()){
            System.out.println(" Ничья! ");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char symbol) {
        int countIsCheck0 = 0;
        int countIsCheck2 = 0;

        for (int i = 0; i < SIZE; i++) {
            //проверка строк(0) и столбцов(1)
            if (checkRowsOrColumns(i, symbol, 0)) return true;
            if (checkRowsOrColumns(i, symbol, 1)) return true;

            //проверка главной диагонали
            if (map[i][i] == symbol) countIsCheck0++;
            if (map[i][i+1] == symbol)

            //проверка обратной диагонали
            if (map[i][SIZE - 1 - i] == symbol) countIsCheck2++;

            if (countIsCheck0 == DOTS_TO_WIN || countIsCheck2 == DOTS_TO_WIN){
                return true;
            }
        }

        int startIndex = 0;
        int endIndex = DOTS_TO_WIN - 1;

        while (endIndex <= SIZE){

            for(; startIndex <= endIndex; startIndex++ ){
                if (map[startIndex][startIndex] == symbol) countIsCheck0++;
            }
        }

        return false;
    }

    private static boolean checkRowsOrColumns(int i, char symbol, int flag) {
        int countIsCheck = 0;
        //в зависимости от флага проверяем или строку или колонку
        for (int j = 0; j < SIZE; j++) {
            if (flag == 0){
                if (map[i][j] != symbol) break;
                else countIsCheck++;
            } else {
                if (map[j][i] != symbol) break;
                else countIsCheck++;
            }
        }

        if (countIsCheck == DOTS_TO_WIN){
            return true;
        }
        return false;
    }

    private static boolean isMapFull() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}
