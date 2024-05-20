package org.example;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Graves {
    static Log my_log;

    static {
        try{
            my_log = new Log("graves.log");
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void addGraveToGraveyard() {
        try {
            if (!Graveyard.isGraveyardDestroyed) {
                System.out.println("Добавление новой могилы на кладбище...");

                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите ФИО похороненного: ");
                String name = scanner.nextLine();
                System.out.print("Введите должность похороненного (если нет введите 'нет'): ");
                String work = scanner.nextLine();
                if (work.equals("нет")) {
                    work = "";
                }
                System.out.print("Введите дату смерти: ");
                String date = scanner.nextLine();
                System.out.print("Введите описание могилы: ");
                String description = scanner.nextLine();

                // "Иван Иванов", "Охранник", "01.01.1950", "Здесь покоится Иван Иванов." - пример
                String[] grave = new String[]{name, work, date, description};

                Main.graves.add(grave);

                System.out.println("Могила успешно добавлена: " + name + ", " + date + ", " + description);
                additionalActionsOnAddGrave();
                my_log.logger.info("Могила успешно добавлена: " + name + ", " + date + ", " + description);
            } else {
                System.out.println("Кладбище разрушено. Добавление могилы невозможно.");
                my_log.logger.info("Кладбище разрущено добавление могилы невозможно");
            }
        }
        catch (Exception e) {
            my_log.logger.info("Кладбище не сломано " + e);
        }
    }

    private static void additionalActionsOnAddGrave() {
        System.out.println("Снова одна душа присоединилась к множеству в этом безжизненном мире.");
    }

    public void updateGraveDetails() {
        try {
            boolean flag = false;
            if (!Graveyard.isGraveyardDestroyed) {
                System.out.println("Обновление информации о могиле на кладбище...");

                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите ФИО похороненного, данные о котором вы хотите обновить: ");
                String name = scanner.nextLine();

                for (int i = 0; i < Main.graves.size(); i++) {
                    String[] graveInfo = Main.graves.get(i);
                    if (Objects.equals(graveInfo[0], name)) {
                        System.out.print("Введите новое описание могилы: ");
                        String newDescription = scanner.nextLine();
                        graveInfo[3] = newDescription;
                        Main.graves.set(i, graveInfo);
                        flag = true;
                    }
                }

                if (flag) {
                    System.out.println("Информация о могиле успешно обновлена: " + name + ".");
                    my_log.logger.info("Информация о могиле обновлена ");
                } else {
                    System.out.println("Могила не найдена: " + name + ".");
                    my_log.logger.info("Информация о могиле не изменена из-за разрушеного кладбища");
                }

            } else {
                System.out.println("Кладбище разрушено. Обновление информации о могиле невозможно.");
                my_log.logger.info("Информация о могиле не изменена из-за разрушеного кладбища");
            }
        }
        catch (Exception e) {
            my_log.logger.info("Информация о могиле завершена с ошикбкой: " + e);
        }
    }

    public static void GraveyardInfo() {
        System.out.println("Информация о могилах:");

        for (int i = 0; i < Main.graves.size(); i++) {
            String[] grave = Main.graves.get(i);
            System.out.println("Могила #" + (i + 1));
            System.out.println("Имя похороненного: " + grave[0]);
            System.out.println("Дата смерти: " + grave[2]);
            System.out.println("Описание: " + grave[3]);
            System.out.println();
        }
    }


}
