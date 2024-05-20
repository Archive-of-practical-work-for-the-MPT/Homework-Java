package org.example;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class People {
    static Log my_log;

    static {
        try{
            my_log = new Log("people.log");
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void display() {
        System.out.println("Люди на кладбище:");
        for (String[] person : Main.graves) {
            if (person[1].isEmpty()) {
                System.out.println("Имя: " + person[0]);
            }
        }
    }

    public void resurrect() {
        try {
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
                    my_log.logger.info("Похороненный был воскрешен с именем " + nameToResurrect);
                    break;
                } else if (Main.graves.get(i)[1].isEmpty()) {
                    System.out.println("Вы пытаетесь воскресить сотрудника это делается другой командой");
                    my_log.logger.info("Попытка воскресить сотрудника не той команды");
                }
            }

            if (!found) {
                System.out.println("Невозможно воскресить умершего человека с именем " + nameToResurrect + ".");
                my_log.logger.info("Невозможно было воскресить умершего человека с именем " + nameToResurrect);
            }
        }
        catch (Exception e) {
            my_log.logger.info("Человек не воскрешен из-за ошибки" + " " + e);
        }
    }

    public void cremate() {
        try {
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
                        my_log.logger.info("Человек был кремирован с именем " + nameToCremate);
                    } else {
                        System.out.println("Вы пытаетесь кремировать сотрудника. Это делается другой командой.");
                        my_log.logger.info("Была попытка кремировать сотрудника. Это делается другой командой");
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("Человек с именем " + nameToCremate + " не найден.");
                my_log.logger.info("Человек не был кремирован, так как не найден с именем " + nameToCremate);
            }
        }
        catch (Exception e) {
            my_log.logger.info("Человек не был кремировна из-за ошибки " + e);
        }
    }
}
