import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.print("Введіть кількість банкоматів для ініціалізації: ");
        int atmCount = validateIntegerInput(scanner);
        bank.initializeATMs(atmCount, 50, 100);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Завантажити гроші в банкомат");
            System.out.println("2. Зняти гроші з банкомату");
            System.out.println("3. Показати загальну суму грошей у мережі");
            System.out.println("4. Вийти");
            System.out.print("Оберіть опцію: ");
            int choice = validateIntegerInput(scanner);

            switch (choice) {
                case 1 -> {
                    System.out.print("Введіть індекс банкомату для завантаження: ");
                    int atmIndex = validateIntegerInput(scanner)-1;

                    Map<Integer, Integer> deposit = new HashMap<>();
                    System.out.print("Введіть кількість номіналів для завантаження: ");
                    int denominations = validateIntegerInput(scanner);

                    for (int i = 0; i < denominations; i++) {
                        System.out.print("Введіть номінал банкнот: ");
                        int denom = validateIntegerInput(scanner);
                        System.out.print("Введіть кількість банкнот: ");
                        int count = validateIntegerInput(scanner);
                        deposit.put(denom, count);
                    }

                    try {
                        bank.loadATM(atmIndex, deposit);
                        System.out.println("Гроші успішно завантажені.");
                    } catch (Exception e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Введіть індекс банкомату для зняття грошей: ");
                    int atmIndex = validateIntegerInput(scanner)-1;
                    System.out.print("Введіть суму для зняття: ");
                    int amount = validateIntegerInput(scanner);

                    try {
                        Map<Integer, Integer> withdrawal = bank.getATM(atmIndex).withdrawMoney(amount);
                        System.out.println("Зняття успішне. Видані купюри:");
                        withdrawal.forEach((denom, count) ->
                                System.out.println("Номінал: " + denom + ", Кількість: " + count));
                    } catch (Exception e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Загальна сума грошей у мережі: " + bank.getTotalMoneyInNetwork());
                }
                case 4 -> {
                    System.out.println("Вихід...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static int validateIntegerInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Некоректна опція. Введіть 1-4: ");
            }
        }
    }
}