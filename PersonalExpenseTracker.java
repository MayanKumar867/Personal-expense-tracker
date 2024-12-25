import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String description;
    double amount;
    String category;

    // Constructor
    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    // Method to display expense details
    @Override
    public String toString() {
        return "Description: " + description + ", Amount: " + amount + ", Category: " + category;
    }
}

public class PersonalExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Personal Expense Tracker!");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. View Total Expenses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    deleteExpense(scanner);
                    break;
                case 4:
                    viewTotalExpenses();
                    break;
                case 5:
                    System.out.println("Exiting the Expense Tracker. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    //  add a new expense
    private static void addExpense(Scanner scanner) {
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Clear the newline left by nextDouble()
        System.out.print("Enter category (e.g., Food, Transport, Shopping): ");
        String category = scanner.nextLine();
    
        Expense newExpense = new Expense(description, amount, category);
        expenses.add(newExpense);
        System.out.println("Expense added successfully!");
    }
    

    // view all expenses
    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("Here are your recorded expenses:");
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i));
            }
        }
    }

    // delete an expense
    private static void deleteExpense(Scanner scanner) {
        viewExpenses();
        if (!expenses.isEmpty()) {
            System.out.print("Enter the number of the expense to delete: ");
            int index = scanner.nextInt() - 1;

            if (index >= 0 && index < expenses.size()) {
                expenses.remove(index);
                System.out.println("Expense deleted successfully!");
            } else {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    // calculate and view total expenses
    private static void viewTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.amount;
        }
        System.out.println("Your total expenses are: " + total);
    }
}
