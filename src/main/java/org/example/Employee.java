package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Employee extends People {
    @Override
    public void display() {
        System.out.println("Сотрудники на кладбище:");
        for (String[] employee : Main.graves) {
            if (!employee[1].isEmpty()) {
                System.out.println("Имя: " + employee[0] + ", Должность: " + employee[1]);
            }
        }
    }
    @Override
    public void resurrect() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя сотрудника для воскрешения: ");
        String nameToResurrect = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < Main.graves.size(); i++) {
            if (Objects.equals(Main.graves.get(i)[0], nameToResurrect) &&
                    Objects.equals(Main.graves.get(i)[2], "КРЕМИРОВАН") && !Main.graves.get(i)[1].isEmpty()) {

                System.out.println("Сотрудник " + Main.graves.get(i)[0] + " был воскрешен.");
                Main.graves.get(i)[1] = Main.graves.get(i)[0];
                Main.graves.get(i)[2] = "ПРИЗРАК";

                found = true;
                break;
            }
            else if (Main.graves.get(i)[1].isEmpty()) {
                System.out.println("Вы пытаетесь воскресить не сотрудника это делается другой командой");
            }
        }

        if (!found) {
            System.out.println("Невозможно воскресить умершего сотрудника с именем " + nameToResurrect + ".");
        }
    }
    @Override
    public void cremate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя сотрудника для кремации: ");
        String nameToCremate = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < Main.graves.size(); i++) {
            if (nameToCremate.equalsIgnoreCase(Main.graves.get(i)[0])) {
                if (!Main.graves.get(i)[1].isEmpty()) {
                    System.out.println("Сотрудник " + Main.graves.get(i)[0] + " был сожжён заживо. Пусть упокоится.");
                    // Удаляем похороненного из массива
                    Main.graves.get(i)[2] = "КРЕМИРОВАН";
                    found = true;
                } else { System.out.println("Вы пытаетесь кремировать не сотрудника. Это делается другой командой."); }
                break;
            }
        }

        if (!found) { System.out.println("Рабочий с именем " + nameToCremate + " не найден."); }
    }
}

