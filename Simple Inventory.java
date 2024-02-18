import java.util.Scanner;
import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> inventory = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add new item\n2. Update quantity\n3. Generate report\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    updateQuantity(scanner);
                    break;
                case 3:
                    generateReport();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addItem(Scanner scanner) {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        inventory.put(itemName, quantity);
        System.out.println("Item added successfully.");
    }

    static void updateQuantity(Scanner scanner) {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        if (inventory.containsKey(itemName)) {
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            inventory.put(itemName, newQuantity);
            System.out.println("Quantity updated successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    static void generateReport() {
        System.out.println("Inventory Report:");
        for (String item : inventory.keySet()) {
            System.out.println(item + ": " + inventory.get(item));
        }
    }
}
