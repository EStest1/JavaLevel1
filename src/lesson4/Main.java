package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] board = gameBoard(3);
        printArr(board);

        while (true) {
            playerTurn(board);
            printArr(board);
            if (isWinner(board, "x") == true || isDraw(board) == true) {
                break;
            }
            computerTurn(board);
            printArr(board);
            if (isWinner(board, "0") == true || isDraw(board) == true) {
                break;
            }
        }
    }

    // игровое поле
    public static String[][] gameBoard (int length) {
        String[][] arr = new String[length][length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = "*";
            }
        }
        return arr;
    }

    //Ход игрока
    public static void playerTurn (String[][] arr) {
        System.out.println("Ход игрока:");
        Scanner sc = new Scanner(System.in);
        int x, y;
        boolean validXY = true;
        while (validXY) {
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
                System.out.println("Вы вышли за пределы игрового поля");
            } else if (arr[x][y].equals("*")) {
                arr[x][y] = "x";
                validXY = false;
            } else {
                System.out.println("Ячейка занята");
            }
        }
    }
    /*Ход компьютера с ИИ, хотела его упростить, так как в части анализа количества х и 0 код повторяется, но при выноси этой части
    в отдельный метод компьютер начинал ходить несколько раз подряд, так как не получилось подобрать условие что бы рандом не срабатывал,
    возможно нужно использавть другой тип метода, ниже в комментах он есть
    ИИ реализван на осове подсчета кол-ва 0 или Х в столбцах/строке/диагоналях
    */
    public static void computerTurn (String[][] arr) {
        System.out.println("Ход компьютера:");
        Random rand = new Random();
        int x, y;
        int gX, vX, dX1=0, dX2=0;
        int g0, v0, d01=0, d02=0;
        boolean validXY = true;


        for (int i = 0; i < arr.length; i++) {
            gX = 0;
            vX = 0;
            g0 = 0;
            v0 = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].equals("x")) {
                    gX++;
                }
                if (arr[j][i].equals("x")) {
                    vX++;
                }
                if (i == j && arr[i][j].equals("x")) {
                    dX1++;
                }
                if (i + j == arr.length - 1 && arr[i][j].equals("x")) {
                    dX2++;
                }
                if (arr[i][j].equals("0")) {
                    g0++;
                }
                if (arr[j][i].equals("0")) {
                    v0++;
                }
                if (i == j && arr[i][j].equals("0")) {
                    d01++;
                }
                if (i + j == arr.length - 1 && arr[i][j].equals("0")) {
                    d02++;
                }
            }

            if (g0 == 2 && validXY) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j].equals("*")) {
                        arr[i][j] = "0";
                        validXY = false;
                        break;
                    }
                }
            }
            if (v0 == 2 && validXY) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j][i].equals("*")) {
                        arr[j][i] = "0";
                        validXY = false;
                        break;
                    }
                }
            }
            if (gX == 2 && validXY) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j].equals("*")) {
                        arr[i][j] = "0";
                        validXY = false;
                        break;
                    }
                }
            }
            if (vX == 2 && validXY) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j][i].equals("*")) {
                        arr[j][i] = "0";
                        validXY = false;
                        break;
                    }
                }
            }
        }

        if (d01 == 2 && validXY) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (i == j && arr[i][j].equals("*")) {
                        arr[i][j] = "0";
                        validXY = false;
                        break;
                    }
                }
            }
        }

        if (d02 == 2 && validXY) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (i + j == arr.length - 1 && arr[i][j].equals("*")) {
                        arr[i][j] = "0";
                        validXY = false;
                        break;
                    }
                }
            }
        }

        if (dX1 == 2 && validXY) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (i == j && arr[i][j].equals("*")) {
                        arr[i][j] = "0";
                        validXY = false;
                        break;
                    }
                }
            }
        }

        if (dX2 == 2 && validXY) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (i + j == arr.length - 1 && arr[i][j].equals("*")) {
                        arr[i][j] = "0";
                        validXY = false;
                        break;
                    }
                }
            }
        }

        while (validXY) {
            x = rand.nextInt(arr.length);
            y = rand.nextInt(arr[0].length);
            if (arr[x][y].equals("*") ) {
                arr[x][y] = "0";
                validXY = false;

            }


        }
    }


    /* вспомогательный метод для искуственного интелекта, который применить не удалось
    public static String[][] isAI (String[][] arr1, String mark) {
        int g, v, d1 = 0, d2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            g = 0;
            v = 0;
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j].equals(mark)) {
                    g++;
                }
                if (arr1[j][i].equals(mark)) {
                    v++;
                }
                if (i == j && arr1[i][j].equals(mark)) {
                    d1++;
                }
                if (i + j == arr1.length - 1 && arr1[i][j].equals(mark)) {
                    d2++;
                }
            }
            if (g == 2) {
                for (int j = 0; j < arr1.length; j++) {
                    if (arr1[i][j].equals("*")) {
                        arr1[i][j] = "0";
                        return arr1;
                    }
                }
            }
            if (v == 2) {
                for (int j = 0; j < arr1.length; j++) {
                    if (arr1[j][i].equals("*")) {
                        arr1[j][i] = "0";
                        return arr1;
                    }
                }
            }
        }

        if (d1 == 2) {
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[i].length; j++) {
                    if (i == j && arr1[i][j].equals("*")) {
                        arr1[i][j] = "0";
                        return arr1;
                    }
                }
            }
        }

        if (d2 == 2) {
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[i].length; j++) {
                    if (i + j == arr1.length - 1 && arr1[i][j].equals("*")) {
                        arr1[i][j] = "0";
                        return arr1;
                    }
                }
            }
        }

        return arr1;
    }*/


    //Победа 3*3, 3 фишки
    public static boolean isWinner (String[][] arr, String mark) {
        int g, v, d1 = 0, d2 = 0;
        for (int i=0; i < arr.length; i++) {
            g = 0;
            v = 0;
            for (int j=0; j < arr[0].length; j++) {
                if (arr[i][j].equals(mark)) {
                    g++;
                }
                if (arr[j][i].equals(mark)) {
                    v++;
                }
                if (i == j && arr[i][j].equals(mark)) {
                    d1++;
                }
                if (i + j == arr.length - 1 && arr[i][j].equals(mark)) {
                    d2++;
                }
            }
            if (g == 3 || v == 3 ) {
                System.out.println("Победил " + mark);
                return true;
            }
        }
        if (d1 == 3 || d2 == 3 ) {
            System.out.println("Победил " + mark);
            return true;
        }

        return false;
    }

    /*Победа 5*5, 4 фишки
    public static boolean isWinner4 (String[][] arr, String mark) {
        int g, v, d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0;
        for (int i=0; i < arr.length; i++) {
            g = 0;
            v = 0;
            for (int j=0; j < arr[0].length; j++) {
                if (arr[i][j].equals(mark)) {
                    g++;
                }
                if (arr[j][i].equals(mark)) {
                    v++;
                }
                if (i == j && arr[i][j].equals(mark)) {
                    d1++;
                }
                if (i + j == arr.length - 1 && arr[i][j].equals(mark)) {
                    d2++;
                }
                if (i + j == arr.length - 2 && arr[i][j].equals(mark)) {
                    d3++;
                }
                if (i + j == arr.length && arr[i][j].equals(mark)) {
                    d4++;
                }
                if (i - j == 1 && arr[i][j].equals(mark)) {
                    d5++;
                }
                if (j - i == 1 && arr[i][j].equals(mark)) {
                    d6++;
                }
            }
            if (g == 4 || v == 4 ) {
                System.out.println("Победил " + mark);
                return true;
            }
        }
        if (d1 == 4 || d2 == 4 || d3 == 4 || d4 == 4 || d5 == 4 || d6 == 4 ) {
            System.out.println("Победил " + mark);
            return true;
        }

        return false;
    } */

    //Проверка на ничью
    public static boolean isDraw(String[][] arr) {
        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[0].length; j++) {
                if (arr[i][j].equals("*")) {
                    return false;
                }
            }
        }
        System.out.println("Ничья =(");
        return true;
    }

    //вывод массива в консоль
    public static void printArr (String[][] arr) {
        System.out.print("  ");
        for (int i=0; i < arr.length; i++) {
            System.out.print(i+1 + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < arr[i].length; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
