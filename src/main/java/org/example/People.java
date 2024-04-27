package org.example;

import java.util.Objects;
import java.util.Scanner;

public class People {
    public void display() {
        System.out.println("Люди на кладбище:");
        for (String[] person : Main.graves) {
            if (person[1].isEmpty()) {
                System.out.println("Имя: " + person[0]);
            }
        }
    }

    public void resurrect() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя человека для воскрешения: ");
        String nameToResurrect = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < Main.graves.size(); i++) {
            if (Objects.equals(Main.graves.get(i)[0], nameToResurrect) &&
                    Objects.equals(Main.graves.get(i)[2], "КРЕМИРОВАН") && Main.graves.get(i)[1].isEmpty()) {

                System.out.println("Похороненный " + Main.graves.get(i)[0] + " был воскрешен.");
                Main.graves.get(i)[1] = Main.graves.get(i)[0];
                Main.graves.get(i)[2] = "ПРИЗРАК";

                found = true;
                break;
            }
            else if (Main.graves.get(i)[1].isEmpty()) {
                System.out.println("Вы пытаетесь воскресить сотрудника это делается другой командой");
            }
        }

        if (!found) {
            System.out.println("Невозможно воскресить умершего человека с именем " + nameToResurrect + ".");
        }
    }

    public void cremate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя человека для кремации: ");
        String nameToCremate = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < Main.graves.size(); i++) {
            if (nameToCremate.equalsIgnoreCase(Main.graves.get(i)[0])) {
                if (Main.graves.get(i)[1].isEmpty()) {
                    System.out.println("Человек " + Main.graves.get(i)[0] + " был сожжён заживо. ХЕХЕХЕ");
                    // Удаляем похороненного из массива
                    Main.graves.get(i)[2] = "КРЕМИРОВАН";
                    found = true;
                } else { System.out.println("Вы пытаетесь кремировать сотрудника. Это делается другой командой."); }
                break;
            }
        }

        if (!found) { System.out.println("Человек с именем " + nameToCremate + " не найден."); }
    }
}
