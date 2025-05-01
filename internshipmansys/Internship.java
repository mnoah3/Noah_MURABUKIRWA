package internshipmansys;
import java.time.LocalDate;

public abstract class Internship {

    protected String internshipId;
    protected Student student;
    protected String companyName;
    protected Supervisor supervisor;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected String status; // "PENDING", "ONGOING", "COMPLETED"

    public Internship(String internshipId, Student student, String companyName, Supervisor supervisor,
                      LocalDate startDate, LocalDate endDate, String status) {
        this.internshipId = internshipId;
        this.student = student;
        this.companyName = companyName;
        this.supervisor = supervisor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
    // Abstract methods to be implemented by concrete classes
    public abstract void assignSupervisor();

    public abstract void trackProgress();

    public abstract void generateReport();

    public abstract void validateInternship();

    // Getters and Setters
    public String getInternshipId() {
        return internshipId;
    }

    public Student getStudent() {
        return student;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

