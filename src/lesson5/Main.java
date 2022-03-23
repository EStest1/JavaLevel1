package lesson5;

public class Main {

    public static void main(String[] args) {

        Employee[] employeeArr = new Employee[5];
        employeeArr[0] = new Employee("Иванов И.И.", "руководитель", "Ivanov@ya.ru", "89998882233", 50000, 35);
        employeeArr[1] = new Employee("Сидоров С.С.", "инженер", "Sidorov@ya.ru", "89998887788", 30000, 41);
        employeeArr[2] = new Employee("Петров П.П.", "менеджер", "Petrov@ya.ru", "89998881122", 25000, 25);
        employeeArr[3] = new Employee("Смирнов П.П.", "менеджер", "Smirnov@ya.ru", "89998881245", 25000, 45);
        employeeArr[4] = new Employee("Кузнецов К.К.", "младший менеджер", "Kyznecov@ya.ru", "89998889874", 20000, 21);

        for (int i=0; i < employeeArr.length; i++) {
            if (employeeArr[i].getAge() > 40) {
                employeeArr[i].fullInfo();
                System.out.println();
            }
        }



    }



}
