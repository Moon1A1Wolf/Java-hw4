import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ICipher aCipher = new ACipher();
            ICipher bCipher = new BCipher();

            System.out.println("Choose encryption method:");
            System.out.println("1. ACipher (shift by one position forward)");
            System.out.println("2. BCipher (mirror alphabet)");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the string to encrypt: ");
            String input = scanner.nextLine();

            ICipher selectedCipher = switch (choice) {
                case 1 -> aCipher;
                case 2 -> bCipher;
                default -> null;
            };

            if (selectedCipher == null) {
                System.out.println("Invalid choice. Exiting program.");
                return;
            }

            String encoded = selectedCipher.encode(input);
            System.out.println("Encoded: " + encoded);
            System.out.println("Decoded: " + selectedCipher.decode(encoded));
        }
    }
}


