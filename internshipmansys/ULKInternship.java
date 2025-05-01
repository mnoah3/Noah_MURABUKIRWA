package internshipmansys;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class ULKInternship extends Internship {

    public ULKInternship(String internshipId, Student student, String companyName, Supervisor supervisor,
                         LocalDate startDate, LocalDate endDate, String status) {
        super(internshipId, student, companyName, supervisor, startDate, endDate, status);
    }

    @Override
    public void assignSupervisor() {
        if (supervisor.getQualification().equals("Masters") ||
                supervisor.getQualification().equals("PhD")) {
            System.out.println("Supervisor assigned successfully.");
        } else {
            System.out.println("Supervisor must have a Master's degree or higher.");
        }
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking progress for ULK internship.");
    }

    @Override
    public void generateReport() {
        System.out.println("Generating report for ULK internship:");
        System.out.println("Student Name: " + student.getFullName());
        System.out.println("Company: " + companyName);
        System.out.println("Supervisor: " + supervisor.getFullName());
        System.out.println("Duration: " + startDate + " to " + endDate);
    }

    @Override
    public void validateInternship() {
        if (endDate.isBefore(startDate)) {
            System.out.println("End date must be after start date.");
        } else if (endDate.minusWeeks(1).isBefore(startDate)) {
            System.out.println("Internship must last at least 6 weeks.");
        } else {
            System.out.println("Internship validated successfully.");
        }
    }
}