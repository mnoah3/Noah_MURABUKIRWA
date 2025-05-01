package taxmanagementsys;

class SUV extends Vehicle {
    private final boolean fourWheelDrive;

    public SUV(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, boolean fourWheelDrive) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, "SUV");
        this.fourWheelDrive = fourWheelDrive;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate;
        if (fourWheelDrive) {
            tax *= 1.1;
        }
        int age = java.time.Year.now().getValue() - yearOfFabrication;
        if (age > 10) {
            tax *= 0.95;
        }
        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println(this);
        System.out.println("Tax Amount: $" + calculateTax());
    }
}

