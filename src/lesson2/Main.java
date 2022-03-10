package lesson2;

public class Main {

    public static void main(String[] args) {

        System.out.println(SumBetween10And20 (10, 3));
        isPositiveOrNegative (10);
        System.out.println(isNegative (-5));
        writeNStrings ("Hello", 5);
        System.out.println(isLeapYear (1900));
    }

    public static boolean SumBetween10And20(int a, int b) {

        return (a + b >= 10) && (a + b <= 20);
    }


    public static void isPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isNegative (int a) {
        return a < 0;
    }

    public static void writeNStrings (String s, int n) {

        for (int i = 0; i < n; i++) {
            System.out.println(s);
        }
    }

    public static boolean isLeapYear (int year) {

        if ((year % 4 == 0) && (year % 100 != 0)) {
            return true;
        } else {
            return year % 400 == 0;
        }
    }
}

