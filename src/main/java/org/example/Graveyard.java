package org.example;

public class Graveyard {
    public static boolean isGraveyardDestroyed = false;

    public static void setIsGraveyardDestroyed(boolean isGraveyardDestroyed) { // сеттер
        Graveyard.isGraveyardDestroyed = isGraveyardDestroyed;
    }

    public static boolean isIsGraveyardDestroyed() { // геттер
        return isGraveyardDestroyed;
    }

    public void destroyGraveyard() {
        isGraveyardDestroyed = true;
        Main.graves.clear();
        System.out.println("Вы разрушили кладбище, эти души свободны, они вас никогда не забудут.");
        additionalActionsOnDestroy();
    }

    private static void additionalActionsOnDestroy() {
        System.out.println("Все ворота кладбища заколочены. Никто не покинет это место.");
        printAdditionalGraveyardHistory();
    }

    public static void printGraveyardHistory() {
        if (!isGraveyardDestroyed) {
            System.out.println("История кладбища: старое кладбище, построенное в 1967 году в Мухосранске. Здесь похоронены люди, " +
                    "которые не смогли сбежать из этого города, и теперь их души навсегда покоются здесь.");
        } else {
            System.out.println("Кладбище было уничтожено. Теперь здесь ничего нет.");
        }
    }

    private static void printAdditionalGraveyardHistory() {
        System.out.println("В давние времена на кладбище происходили странные события...");
    }

    public static void visitGraveyard() {
        if (!isGraveyardDestroyed) {
            System.out.println("Я на территории кладбища. Тут пахнет гнилью и свежей мертвечиной");
            additionalActionsOnVisitGraveyard();
        } else {
            System.out.println("Кладбище разрушено. Посещение невозможно.");
        }
    }

    private static void additionalActionsOnVisitGraveyard() {
        System.out.println("Я почувствовал холод, когда переступил порог кладбища. Мрачная атмосфера окутывает меня.");
    }
}
