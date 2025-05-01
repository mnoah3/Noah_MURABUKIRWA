package taxenfmansys;

import java.time.LocalDate;

public class PAYEDeclaration extends TaxDeclaration {
    private final double grossSalary;

    public PAYEDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double grossSalary, boolean isPaid) {
        super(declarationId, taxpayerName, taxpayerTIN, declarationDate, 0, isPaid);
        this.grossSalary = grossSalary;
        validateDeclaration();
        this.taxAmount = calculateTax();
    }

    @Override
    public double calculateTax() {
        if (grossSalary <= 30000) return grossSalary * 0.1;
        else if (grossSalary <= 100000) return grossSalary * 0.2;
        else return grossSalary * 0.3;
    }

    @Override
    public void validateDeclaration() {
        if (grossSalary <= 0) {
            throw new IllegalArgumentException("Gross salary must be positive.");
        }
    }
    @Override
    public void generateReceipt() {
        System.out.println("=== PAYE Tax Receipt ===");
        System.out.println("Taxpayer: " + taxpayerName);
        System.out.println("TIN: " + taxpayerTIN);
        System.out.println("Amount Due: " + taxAmount);
        System.out.println("Paid: " + (isPaid ? "Yes" : "No"));
    }
    @Override
    public void enforceCompliance() {
        if (!isPaid && declarationDate.plusMonths(1).withDayOfMonth(15).isBefore(LocalDate.now())) {
            taxAmount += taxAmount * 0.05; // 5% penalty
            System.out.println("5% Penalty added for late payment!");
        }
    }
}
