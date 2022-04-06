package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;

    }

    public void eat (Plate plate) {


        if ((plate.getFood() - appetite) < 0) {
            System.out.println("В тарелке мало еды для кота");
        } else {
            plate.setFood(plate.getFood() - appetite);
            satiety = true;
        }

    }

    public void satietyInfo () {
        if (satiety) {
            System.out.println(name + " : сыт");
        } else {
            System.out.println(name + " : голоден");
        }


    }



}
