package lesson6;

public class Cat extends Animal {
    private static int countCat = 0;

    public Cat (String name) {
        super(name);
        countCat++;

    }
    public static int getCountCat () {
        return countCat;
    }

    @Override
    public void run (int length) {
        if (length <= 200) {

            System.out.println(name + " пробежал " + length + " м");
        } else {
            System.out.println(name + " пробежал 200 м из " + length + " м и сейчас отдыхает =)");
        }
    }
    @Override
    public void swim (int length) {
        System.out.println("Котики не умеют плавать =(");

    }

}
