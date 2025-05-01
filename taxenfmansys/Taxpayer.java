package taxenfmansys;

public class Taxpayer {
    private String tin;
    private final String name;
    private final String type; // Individual or Company
    private int complianceScore;

    public Taxpayer(String tin, String name, String type) {
        setTin(tin);
        this.name = name;
        this.type = type;
        this.complianceScore = 100;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        if (tin.length() != 9) {
            throw new IllegalArgumentException("TIN must be exactly 9 digits.");
        }
        this.tin = tin;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getComplianceScore() {
        return complianceScore;
    }

    public void reduceCompliance(int points) {
        this.complianceScore -= points;
    }
}
