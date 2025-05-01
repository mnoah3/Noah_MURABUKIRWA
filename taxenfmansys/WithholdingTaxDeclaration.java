package taxenfmansys;

import java.time.LocalDate;

public class WithholdingTaxDeclaration extends TaxDeclaration {
    private final String category; // rent, dividends, services

    public WithholdingTaxDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate, String category, double amount, boolean isPaid) {
        super(declarationId, taxpayerName, taxpayerTIN, declarationDate, 0, isPaid);
        this.category = category;
        validateDeclaration();
        this.taxAmount = calculateTax();
    }

    @Override
    public double calculateTax() {
        switch (category.toLowerCase()) {
            case "services": return taxAmount = taxAmount + taxAmount * 0.15;
            case "rent": return taxAmount = taxAmount + taxAmount * 0.10;
            case "dividends": return taxAmount = taxAmount + taxAmount * 0.05;
            default: throw new IllegalArgumentException("Invalid category.");
        }
    }

    @Override
    public void validateDeclaration() {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category must be provided.");
        }
    }

    @Override
    public void generateReceipt() {
        System.out.println("=== Withholding Tax Receipt ===");
        System.out.println("Taxpayer: " + taxpayerName);
        System.out.println("TIN: " + taxpayerTIN);
        System.out.println("Category: " + category);
        System.out.println("Amount Due: " + taxAmount);
        System.out.println("Paid: " + (isPaid ? "Yes" : "No"));
    }

    @Override
    public void enforceCompliance() {
        if (!isPaid) {
            System.out.println("Warning: Payment was made but declaration is missing!");
        }
    }
}
