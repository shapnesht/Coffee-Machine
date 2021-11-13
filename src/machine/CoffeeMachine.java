package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.run();
    }

    private static void canThatMuchCoffeeBeMade() {
        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterQuantity = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkQuantity = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeQuantity = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int requiredCoffeeCups = scanner.nextInt();
        int maxCoffeeFromMilk = milkQuantity / 50;
        int maxCoffeeFromWater = waterQuantity / 200;
        int maxCoffeeFromBeans = coffeeQuantity / 15;

        int maxCoffee = Math.min(maxCoffeeFromWater,Math.min(maxCoffeeFromBeans, maxCoffeeFromMilk));

        if (requiredCoffeeCups == maxCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (requiredCoffeeCups > maxCoffee){
            System.out.printf("No, I can make only %d cup(s) of coffee\n", maxCoffee);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", requiredCoffeeCups - maxCoffee);
        }
    }

    private static void calculateCoffee() {
        System.out.println("Write how many cups of coffee you will need: ");
        int numberOfCups = scanner.nextInt();
        System.out.printf("For %d cups of coffee you will need:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n", numberOfCups, 200 * numberOfCups, 50 * numberOfCups, 15 * numberOfCups);
    }

    private static void makeCoffee() {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }
}
