package taxenfmansys;

import java.time.LocalDate;

public class VATDeclaration extends TaxDeclaration {
    private final double sales;
    private final double purchases;

    public VATDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double sales, double purchases, boolean isPaid) {
        super(declarationId, taxpayerName, taxpayerTIN, declarationDate, 0, isPaid);
        this.sales = sales;
        this.purchases = purchases;
        validateDeclaration();
        this.taxAmount = calculateTax();
    }

    @Override
    public double calculateTax() {
        return (sales - purchases) * 0.18;
    }

    @Override
    public void validateDeclaration() {
        if (sales <= purchases) {
            throw new IllegalArgumentException("Sales must be greater than purchases.");
        }
    }

    @Override
    public void generateReceipt() {
        System.out.println("=== VAT Tax Receipt ===");
        System.out.println("Taxpayer: " + taxpayerName);
        System.out.println("TIN: " + taxpayerTIN);
        System.out.println("Amount Due: " + taxAmount);
        System.out.println("Paid: " + (isPaid ? "Yes" : "No"));
    }

    @Override
    public void enforceCompliance() {
        if (!isPaid) {
            taxAmount += taxAmount * 0.1; // 10% penalty
            System.out.println("10% Penalty added for unpaid VAT!");
        }
    }
}
