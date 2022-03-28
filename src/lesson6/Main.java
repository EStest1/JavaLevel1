package lesson6;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Марсик");
        cat1.run(150);
        cat1.swim(120);
        Cat cat2 = new Cat("Бублик");
        cat2.run(20);
        cat2.swim(100);
        Dog dog1 = new Dog("Шарик");
        dog1.run(600);
        dog1.swim(100);

        System.out.println(Dog.getCountDog() + " собачек");
        System.out.println(Cat.getCountCat() + " котиков");
        System.out.println(Animal.getCount() + " животных");


    }
}
