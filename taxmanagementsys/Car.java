package taxmanagementsys;

class Car extends Vehicle {
    private final boolean isElectric;

    public Car(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, boolean isElectric) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, "Car");
        this.isElectric = isElectric;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate;
        int age = java.time.Year.now().getValue() - yearOfFabrication;
        if (age > 10) {
            tax *= 0.9;
        }
        if (isElectric) {
            tax *= 0.8;
        }
        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println(this);
        System.out.println("Tax Amount: $" + calculateTax());
    }
}

