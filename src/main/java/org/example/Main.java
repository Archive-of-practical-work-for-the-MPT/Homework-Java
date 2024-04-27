package org.example;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static ArrayList<String[]> graves = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee employee = new Employee();
        People person = new People();
        Graves grave = new Graves();
        Graveyard graveyard = new Graveyard();

        int choice = 0;

        while (choice != 13) {
            System.out.println("Меню:");
            System.out.println("1. Кто есть на кладбище");
            System.out.println("2. Кто есть на кладбище из сотрудников");
            System.out.println("3. История могил");
            System.out.println("4. Добавить могилу на кладбище");
            System.out.println("5. Обновить информацию о могиле");
            System.out.println("6. История кладбища");
            System.out.println("7. Посетить кладбище");
            System.out.println("8. Уничтожить кладбище");
            System.out.println("9. Кремация сотрудника");
            System.out.println("10. Воскрешение сотрудника");
            System.out.println("11. Кремация человека");
            System.out.println("12. Воскрешение человека");
            System.out.println("13. Выход");

            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    person.display(); // 1. Кто есть на кладбище из людей
                    break;
                case 2:
                    employee.display(); // 2. Кто есть на кладбище из сотрудников
                    break;
                case 3:
                    Graves.GraveyardInfo(); // 3. История могил
                    break;
                case 4:
                    grave.addGraveToGraveyard(); // 4. Добавить могилу на кладбище
                    break;
                case 5:
                    grave.updateGraveDetails(); // 5. Обновить информацию о могиле
                    break;
                case 6:
                    Graveyard.printGraveyardHistory(); // 6. История кладбища
                    break;
                case 7:
                    Graveyard.visitGraveyard(); // 7. Посетить кладбище
                    break;
                case 8:
                    graveyard.destroyGraveyard(); // 8. Уничтожить кладбище
                    break;
                case 9:
                    employee.cremate(); // 9. Кремация сотрудника
                    break;
                case 10:
                    employee.resurrect(); // 10. Воскрешение сотрудника
                    break;
                case 11:
                    person.cremate(); // 11. Кремация человека
                    break;
                case 12:
                    person.resurrect(); // 12. Воскрешение человека
                    break;
                case 13:
                    System.out.println("Конец..."); // 13. Выход
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите еще раз.");
                    break;
            }
        }
        scanner.close();
    }
}
