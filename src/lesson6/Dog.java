package lesson6;

public class Dog extends Animal{
    private static int countDog = 0;

    public Dog (String name) {
        super(name);
        countDog++;
    }

    public static int getCountDog() {
        return countDog;
    }

    @Override
    public void run (int length) {
        if (length <= 500) {

            System.out.println(name + " пробежал " + length + " м");
        } else {
            System.out.println(name + " пробежал 500 м из " + length + " м и сейчас отдыхает =)");        }

    }


    @Override
    public void swim (int length) {
        if (length <= 10) {

            System.out.println(name + " проплыл " + length + " м");
        } else {
            System.out.println(name + " проплыл 10 м из " + length + " м и сейчас отдыхает =)");        }

    }
}
