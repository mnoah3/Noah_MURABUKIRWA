package internshipmansys;

public class Supervisor {

    private String supervisorId;
    private String fullName;
    private String qualification;
    private String email;

    public Supervisor(String supervisorId, String fullName, String qualification, String email) {
        setSupervisorId(supervisorId);
        setFullName(fullName);
        setQualification(qualification);
        setEmail(email);
    }

    // Validating supervisor attributes
    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setQualification(String qualification) {
        if (qualification.equals("Bachelors") || qualification.equals("Masters") || qualification.equals("PhD")) {
            this.qualification = qualification;
        } else {
            System.out.println("Invalid qualification. Must be Bachelors, Masters, or PhD.");
        }
    }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email format.");
        }
    }

    // Getters
    public String getSupervisorId() {
        return supervisorId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getQualification() {
        return qualification;
    }

    public String getEmail() {
        return email;
    }
}


