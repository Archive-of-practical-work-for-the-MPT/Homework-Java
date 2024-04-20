package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cemetery cemetery = new Cemetery();
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        while (true)  {
            int choice = in.nextInt();
            switch (choice) {
                case 1: Cemetery.print_grave(); break;
                case 2: cemetery.bury("Колян", "Коленовский", "22.03.123", "22.03.222"); break;
                case 3: cemetery.bury_the_peasant("Колян", "Коленовский", "22.03.123", "22.03.222"); break;
                case 4: cemetery.bury_the_king("Колян", "Коленовский", "22.03.123", "22.03.222"); break;
                case 5: cemetery.update_grave(1, "Васек", "Коленовский", "22.03.123", "22.03.222"); break;
                case 6: cemetery.del_grave(1); break;
                case 7: System.out.println(Cemetery.get_grave_location_info("Коленовский", "Новгород", "место 243")); break;
                case 8: System.out.println(Cemetery.calculate_burial_cost("Стандарт", true, true) + " - цена."); break;
                case 9: System.out.println(Cemetery.to_bring_gifts("Коленовский", "арбуз")); break;
                case 10: System.out.println(Cemetery.to_bring_gifts_peasant("Коленовский", "дыня")); break;
                case 11: System.out.println(Cemetery.to_bring_gifts_king("Коленовский", "картошка")); break;
            }
        }
    }
}

