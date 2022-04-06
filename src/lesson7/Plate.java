package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void addFood(int extraFood) {
        food += extraFood;
    }

    public void plateInfo () {
        System.out.println("Еды в тарелке: " + food);
    }
}
