import java.util.ArrayList;
import java.util.Scanner;

public class ATMSystem {

    // User details
    static String USER_ID = "Karthiga";
    static String USER_PIN = "1111";

    static double balance = 10000.0;
    static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       WELCOME TO JAVA ATM        ");
        System.out.println("=================================");

        System.out.print("Enter User ID: ");
        String uid = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (!uid.equals(USER_ID) || !pin.equals(USER_PIN)) {
            System.out.println("❌ Invalid User ID or PIN");
            return;
        }

        System.out.println("✅ Login Successful!");

        int choice;
        do {
            System.out.println("\n--------- ATM MENU ---------");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (transactionHistory.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        System.out.println("Transaction History:");
                        for (String t : transactionHistory) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter withdraw amount: ₹");
                    double withdraw = sc.nextDouble();
                    if (withdraw <= balance) {
                        balance -= withdraw;
                        transactionHistory.add("Withdrawn ₹" + withdraw);
                        System.out.println("✅ Withdraw successful");
                        System.out.println("Current Balance: ₹" + balance);
                    } else {
                        System.out.println("❌ Insufficient balance");
                    }
                    break;

                case 3:
                    System.out.print("Enter deposit amount: ₹");
                    double deposit = sc.nextDouble();
                    balance += deposit;
                    transactionHistory.add("Deposited ₹" + deposit);
                    System.out.println("✅ Deposit successful");
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 4:
                    System.out.print("Enter transfer amount: ₹");
                    double transfer = sc.nextDouble();
                    if (transfer <= balance) {
                        balance -= transfer;
                        transactionHistory.add("Transferred ₹" + transfer);
                        System.out.println("✅ Transfer successful");
                        System.out.println("Current Balance: ₹" + balance);
                    } else {
                        System.out.println("❌ Insufficient balance");
                    }
                    break;

                case 5:
                    System.out.println("🙏 Thank you for using Java ATM");
                    break;

                default:
                    System.out.println("❌ Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
