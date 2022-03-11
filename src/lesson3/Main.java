package lesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 0,};
        changeArr1for0(arr);
        newArr100();
        changeArr();
        diagonalArr1();
        diagonalArr2();
        System.out.println(Arrays.toString(initialValueArr(5,15)));
        searchMinMaxArr();

        int[] arr1 = {1, 1, 1, 2, 1};
        System.out.println(checkBalance(arr1));

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(moveForN(arr2,-2)));
    }


    //Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0
    public static void changeArr1for0(int[] arr) {
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    public static void newArr100() {
        int[] arr = new int[100];
        for (int i=0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void changeArr() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i=0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //Создать квадратный двумерный целочисленный массив, и с помощью цикла(-ов) заполнить его диагональные элементы единицами .
    public static void diagonalArr1() {
        int[][] arr = new int[5][5];
        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr.length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
                if (i + j == 4) {
                    arr[i][j] = 1;
                }
            }
        }
        //как вывести двумерный массив красиво, нашла в гугле
        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
    }

    public static void diagonalArr2() {
        int[][] arr = new int[5][5];
        for (int i=0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][4-i] = 1;
        }
        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
    }

    //Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue
    public static int[] initialValueArr(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i=0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    //Задать одномерный массив и найти в нем минимальный и максимальный элементы
    public static void searchMinMaxArr() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max = arr[0];
        int min = arr[0];

        for (int i=1; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("min=" + min);
        System.out.println("max=" + max);
    }

    //Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    public static boolean checkBalance(int[] arr) {
        boolean result = false;
        int sum = 0;
        int sum1 = 0;
        for (int i=0; i < arr.length; i++) {
            sum += arr[i];
        }
        for (int i=0; i < arr.length; i++) {
            sum1 += arr [i];
            if (sum1 == sum/2) {
                result = true;
                break;
            }
        }
        return result;
    }

    //Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    //Задачу решила с использованием доп.массива и при условии что n меньше длины массива
    public static int[] moveForN(int[] arr, int n){
        int[] result = new int[arr.length];
       if (n > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (i + n < arr.length) {
                    result[i + n] = arr[i];
                } else {
                    result[i - n] = arr[i];
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i + n >= 0) {
                    result[i + n] = arr[i];
                } else {
                    result[i - n] = arr[i];
                }
            }
        }
        return result;

    }
}
