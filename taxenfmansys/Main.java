package taxenfmansys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<TaxDeclaration> declarations = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Welcome to the RRA Tax Enforcement Management System!");

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Declare PAYE");
            System.out.println("2. Declare VAT");
            System.out.println("3. Declare Withholding Tax");
            System.out.println("4. View Compliance Report");
            System.out.println("5. View Unpaid Taxes Summary");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    declarePAYE();
                    break;
                case 2:
                    declareVAT();
                    break;
                case 3:
                    declareWithholding();
                    break;
                case 4:
                    generateComplianceReport();
                    break;
                case 5:
                    viewUnpaidTaxesSummary();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void declarePAYE() {
        System.out.print("Enter Declaration ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Taxpayer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Taxpayer TIN (9 digits): ");
        String tin = scanner.nextLine();
        System.out.print("Enter Gross Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Has it been paid? (true/false): ");
        boolean paid = scanner.nextBoolean();
        scanner.nextLine(); // consume newline

        TaxDeclaration paye = new PAYEDeclaration(id, name, tin, LocalDate.now(), salary, paid);
        declarations.add(paye);
        System.out.println("PAYE Declaration recorded successfully.");
        paye.generateReceipt();
    }

    private static void declareVAT() {
        System.out.print("Enter Declaration ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Taxpayer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Taxpayer TIN (9 digits): ");
        String tin = scanner.nextLine();
        System.out.print("Enter Sales Amount: ");
        double sales = scanner.nextDouble();
        System.out.print("Enter Purchases Amount: ");
        double purchases = scanner.nextDouble();
        System.out.print("Has it been paid? (true/false): ");
        boolean paid = scanner.nextBoolean();
        scanner.nextLine(); // consume newline

        TaxDeclaration vat = new VATDeclaration(id, name, tin, LocalDate.now(), sales, purchases, paid);
        declarations.add(vat);
        System.out.println("VAT Declaration recorded successfully.");
        vat.generateReceipt();
    }

    private static void declareWithholding() {
        System.out.print("Enter Declaration ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Taxpayer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Taxpayer TIN (9 digits): ");
        String tin = scanner.nextLine();
        System.out.print("Enter Category (rent/dividends/services): ");
        String category = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Has it been paid? (true/false): ");
        boolean paid = scanner.nextBoolean();
        scanner.nextLine(); // consume newline

        TaxDeclaration withhold = new WithholdingTaxDeclaration(id, name, tin, LocalDate.now(), category, amount, paid);
        declarations.add(withhold);
        System.out.println("Withholding Tax Declaration recorded successfully.");
        withhold.generateReceipt();
    }

    private static void generateComplianceReport() {
        System.out.print("Enter Taxpayer TIN to view report: ");
        String tin = scanner.nextLine();
        System.out.println("\n=== Compliance Report ===");
        for (TaxDeclaration decl : declarations) {
            if (decl.getTaxpayerTIN().equals(tin)) {
                System.out.println("Declaration ID: " + decl.getDeclarationId());
                System.out.println("Tax Type: " + decl.getClass().getSimpleName());
                System.out.println("Amount: " + decl.getTaxAmount());
                System.out.println("Paid: " + (decl.isPaid() ? "Yes" : "No"));
                System.out.println("------------------------------");
            }
        }
    }

    private static void viewUnpaidTaxesSummary() {
        System.out.println("\n=== Unpaid Taxes Summary ===");
        for (TaxDeclaration decl : declarations) {
            if (!decl.isPaid()) {
                System.out.println(decl.getTaxpayerName() + " - " + decl.getTaxpayerTIN() + " - Amount Due: " + decl.getTaxAmount());
            }
        }
    }
}

