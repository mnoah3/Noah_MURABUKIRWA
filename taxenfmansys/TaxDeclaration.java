package taxenfmansys;

import java.time.LocalDate;

public abstract class TaxDeclaration implements TaxOperations {
    protected String declarationId;
    protected String taxpayerName;
    protected String taxpayerTIN;
    protected LocalDate declarationDate;
    protected double taxAmount;
    protected boolean isPaid;

    public TaxDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double taxAmount, boolean isPaid) {
        this.declarationId = declarationId;
        this.taxpayerName = taxpayerName;
        this.taxpayerTIN = taxpayerTIN;
        if (declarationDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Declaration date cannot be in the future.");
        }
        this.declarationDate = declarationDate;
        this.taxAmount = taxAmount;
        this.isPaid = isPaid;
    }

    public abstract void validateDeclaration();
    public abstract void enforceCompliance();

    // Common methods
    public String getDeclarationId() {
        return declarationId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public String getTaxpayerTIN() {
        return taxpayerTIN;
    }

    public String getTaxpayerName() {
        return taxpayerName;
    }
}
