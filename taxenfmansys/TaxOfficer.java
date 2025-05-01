package taxenfmansys;

import java.util.ArrayList;
import java.util.List;

public class TaxOfficer {
    private final String officerId;
    private final String fullName;
    private final String assignedRegion;
    private final List<TaxDeclaration> auditsConducted = new ArrayList<>();

    public TaxOfficer(String officerId, String fullName, String assignedRegion) {
        this.officerId = officerId;
        this.fullName = fullName;
        this.assignedRegion = assignedRegion;
    }

    public void auditDeclaration(TaxDeclaration declaration) {
        auditsConducted.add(declaration);
        declaration.enforceCompliance();
    }

    public void generateAuditSummary() {
        System.out.println("=== Audit Summary ===");
        for (TaxDeclaration decl : auditsConducted) {
            System.out.println(decl.getTaxpayerName() + " (" + decl.getTaxpayerTIN() + ") - Amount: " + decl.getTaxAmount() + " - Paid: " + decl.isPaid());
        }
    }
}


