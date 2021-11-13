package machine;

import java.util.Scanner;

public class Machine {
    static Scanner scanner = new Scanner(System.in);
    private static int waterQuantity;
    private static int milkQuantity;
    private static int coffeeBeansQuantity;
    private static int cupsQuantity;
    private static int money;

    Machine() {
        waterQuantity = 400;
        milkQuantity = 540;
        coffeeBeansQuantity = 120;
        cupsQuantity = 9;
        money = 550;
    }

    public void run() {
        int chosenItem = selectFromMenu();
        while (chosenItem != 0) {
            if (chosenItem == 1) {
                buy();
            } else if (chosenItem == 2) {
                fill();
            } else if (chosenItem == 3) {
                take();
            } else if (chosenItem == 4) {
                printCurrentStatus();
            } else {
                System.out.println("Wrong item Selected!!!");
            }
            chosenItem = selectFromMenu();
        }
    }

    private void take() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }

    private void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        int addWater = scanner.nextInt();
        waterQuantity += addWater;
        int addMilk = scanner.nextInt();
        milkQuantity += addMilk;
        int addCoffeeBeans = scanner.nextInt();
        coffeeBeansQuantity += addCoffeeBeans;
        int addCups = scanner.nextInt();
        cupsQuantity += addCups;
        scanner.nextLine();
    }



    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String input = scanner.nextLine();
        if ("back".contains(input)) {
            return;
        }
        int choice = Integer.parseInt(input);
        if (choice == 1) {
            buyEspresso();
        } else if (choice == 2) {
            buyLatte();
        } else if (choice == 3) {
            buyCappuccino();
        } else {
            System.out.println("Enter a valid Coffee number.");
        }
    }

    private void buyCappuccino() {
        if (waterQuantity < 200) {
            System.out.println("Sorry, not enough water!");
            return;
        } else if (milkQuantity < 100) {
            System.out.println("Sorry, not enough milk!");
            return;
        } else if (coffeeBeansQuantity < 12) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        } else if (cupsQuantity < 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        waterQuantity -= 200;
        milkQuantity -= 100;
        coffeeBeansQuantity -= 12;
        money += 6;
        cupsQuantity -= 1;
    }

    private void buyLatte() {
        if (waterQuantity < 350) {
            System.out.println("Sorry, not enough water!");
            return;
        } else if (milkQuantity < 75) {
            System.out.println("Sorry, not enough milk!");
            return;
        } else if (coffeeBeansQuantity < 20) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        } else if (cupsQuantity < 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        waterQuantity -= 350;
        milkQuantity -= 75;
        coffeeBeansQuantity -= 20;
        money += 7;
        cupsQuantity -= 1;
    }

    private void buyEspresso() {
        if (waterQuantity < 250) {
            System.out.println("Sorry, not enough water!");
            return;
        } else if (coffeeBeansQuantity < 16) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        } else if (cupsQuantity < 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        waterQuantity -= 250;
        coffeeBeansQuantity -= 16;
        money += 4;
        cupsQuantity -= 1;
    }

    private int selectFromMenu() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");

        String task = scanner.nextLine();
        if ("buy".contains(task)) {
            return 1;
        } else if ("fill".contains(task)) {
            return 2;
        } else if ("take".contains(task)) {
            return 3;
        } else if ("remaining".contains(task)) {
            return 4;
        } else if ("exit".contains(task)) {
            return 0;
        }
        return -1;
    }
    public static void printCurrentStatus() {
        System.out.printf("\nThe coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n", waterQuantity, milkQuantity, coffeeBeansQuantity, cupsQuantity, money
                );
    }
}
