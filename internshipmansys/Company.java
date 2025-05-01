package internshipmansys;

public class Company {

    private String companyId;
    private String name;
    private String industryType;
    private String location;

    public Company(String companyId, String name, String industryType, String location) {
        setCompanyId(companyId);
        setName(name);
        setIndustryType(industryType);
        setLocation(location);
    }

    // Validating company attributes
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndustryType(String industryType) {
        if (industryType.equals("IT") || industryType.equals("Finance") || industryType.equals("Health") || industryType.equals("Education")) {
            this.industryType = industryType;
        } else {
            System.out.println("Invalid industry type.");
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getters
    public String getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public String getIndustryType() {
        return industryType;
    }

    public String getLocation() {
        return location;
    }
}