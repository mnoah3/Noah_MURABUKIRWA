package taxmanagementsys;

import java.util.*;

public class Main {
    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Vehicle Tax Management System ---");
            System.out.println("1. Register a new vehicle");
            System.out.println("2. View registered vehicles");
            System.out.println("3. Calculate tax for all vehicles");
            System.out.println("4. Generate tax reports");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    registerVehicle();
                    break;
                case 2:
                    viewVehicles();
                    break;
                case 3:
                    calculateTaxes();
                    break;
                case 4:
                    generateReports();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void registerVehicle() {
        System.out.print("Enter vehicle type (Car, Truck, Motorcycle, Bus, SUV): ");
        String type = scanner.nextLine();

        System.out.print("Enter vehicle ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter owner name: ");
        String owner = scanner.nextLine();
        System.out.print("Enter year of fabrication: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter registration number: ");
        String regNum = scanner.nextLine();
        System.out.print("Enter base tax rate: ");
        double baseTax = Double.parseDouble(scanner.nextLine());

        // Check for duplicate ID or regNum
        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(id) || v.getRegistrationNumber().equals(regNum)) {
                System.out.println("Error: Duplicate vehicle ID or registration number.");
                return;
            }
        }

        try {
            switch (type.toLowerCase()) {
                case "car":
                    System.out.print("Is it electric? (true/false): ");
                    boolean isElectric = Boolean.parseBoolean(scanner.nextLine());
                    vehicles.add(new Car(id, owner, year, regNum, baseTax, isElectric));
                    break;
                case "truck":
                    System.out.print("Enter load capacity (tons): ");
                    double load = Double.parseDouble(scanner.nextLine());
                    vehicles.add(new Truck(id, owner, year, regNum, baseTax, load));
                    break;
                case "motorcycle":
                    System.out.print("Enter engine capacity (cc): ");
                    int engine = Integer.parseInt(scanner.nextLine());
                    vehicles.add(new Motorcycle(id, owner, year, regNum, baseTax, engine));
                    break;
                case "bus":
                    System.out.print("Enter passenger capacity: ");
                    int passengers = Integer.parseInt(scanner.nextLine());
                    vehicles.add(new Bus(id, owner, year, regNum, baseTax, passengers));
                    break;
                case "suv":
                    System.out.print("Is it 4WD? (true/false): ");
                    boolean fourWD = Boolean.parseBoolean(scanner.nextLine());
                    vehicles.add(new SUV(id, owner, year, regNum, baseTax, fourWD));
                    break;
                default:
                    System.out.println("Invalid vehicle type.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewVehicles() {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private static void calculateTaxes() {
        for (Vehicle v : vehicles) {
            System.out.println("Vehicle " + v.vehicleId + " Tax: $" + v.calculateTax());
        }
    }

    private static void generateReports() {
        for (Vehicle v : vehicles) {
            v.generateTaxReport();
            System.out.println("-----------------------------");
        }
    }
}

