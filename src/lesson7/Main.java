package lesson7;

public class Main {
    public static void main(String[] args) {

        Cat[] catArr = new Cat[5];
        catArr[0] = new Cat("Марсик", 15);
        catArr[1] = new Cat("Нептун", 20);
        catArr[2] = new Cat("Юпитер", 50);
        catArr[3] = new Cat("Луна", 30);
        catArr[4] = new Cat("Венера", 25);


        Plate plate = new Plate(100);

        for (int i=0; i<catArr.length; i++) {
            catArr[i].eat(plate);
            catArr[i].satietyInfo();

        }
        plate.addFood(100);
        plate.plateInfo();





    }
}
