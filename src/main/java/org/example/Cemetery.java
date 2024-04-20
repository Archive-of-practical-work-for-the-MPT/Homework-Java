package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static java.sql.DriverManager.println;

public class Cemetery {
    public static ArrayList<String[]> graves = new ArrayList<>();
    public static double calculate_burial_cost(String graveType, Boolean isEmergency, Boolean isFlowers)
    {
        double baseCost = switch (graveType) {
            case "Стандарт" -> 45;
            case "Премиум" -> 95;
            case "Эсклюзив" -> 250;
            default -> 0;
        };

        if (isEmergency)
            baseCost += 25;
        if (isFlowers)
            baseCost += 2;

        return baseCost;
    }

    public static void print_grave()
    {
        for (String[] grave : graves) {
            System.out.println(Arrays.toString(grave));
        }
    }

    public static String get_grave_location_info(String surname, String address, String location)
    {
        return surname + " находится в " + location + " с адрессом " + address + ".";
    }

    public static String to_bring_gifts(String surname, String gift) {
        return surname + " принесли в дар " + gift + ".";
    }

    public static String to_bring_gifts_peasant(String surname, String gift) {
        return surname + " принесли в дар " + gift + ".";
        // логика будет переделана когда будет ООП
    }

    public static String to_bring_gifts_king(String surname, String gift) {
        return surname + " принесли в дар " + gift + ".";
        // логика будет переделана когда будет ООП
    }

    public void bury(String name, String surname, String d_birth, String d_dead) {
        String[] grave = new String[] {name, surname, d_birth, d_dead};
        graves.add(grave);
    }

    public void bury_the_peasant(String name, String surname, String d_birth, String d_dead) {
        String[] grave = new String[] {name, surname, d_birth, d_dead};
        graves.add(grave); // логика будет переделана когда будет ООП
    }

    public void bury_the_king(String name, String surname, String d_birth, String d_dead) {
        String[] grave = new String[] {name, surname, d_birth, d_dead};
        graves.add(grave); // логика будет переделана когда будет ООП
    }

    public void update_grave(int index, String name, String surname, String d_birth, String d_dead) {
        String[] grave = new String[] {name, surname, d_birth, d_dead};
        graves.set(index, grave);
    }

    public void del_grave(int index) {
        graves.remove(index);
    }
}
