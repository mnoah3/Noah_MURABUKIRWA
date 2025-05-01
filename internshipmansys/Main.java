package internshipmansys;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    private static final List<Student> students = new ArrayList<>();
    private static final List<Supervisor> supervisors = new ArrayList<>();
    private static final List<Internship> internships = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("\nWelcome to the Internship Management System");
        System.out.println("-------------------------------------------'\n");
        while (true) {
            System.out.println("1. Register Student");
            System.out.println("2. Register Supervisor");
            System.out.println("3. Assign Internship");
            System.out.println("4. Generate Internship Report");
            System.out.println("5. Track Internship Progress");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerStudent(scanner);
                    break;
                case 2:
                    registerSupervisor(scanner);
                    break;
                case 3:
                    assignInternship(scanner);
                    break;
                case 4:
                    generateInternshipReport(scanner);
                    break;
                case 5:
                    trackInternshipProgress(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Register a new student
    private static void registerStudent(Scanner scanner) {
        System.out.println("Enter Student Details:");
        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("University (ULK, UR, AUCA, UK): ");
        String university = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Student student = new Student(studentId, fullName, university, email);
        students.add(student);
        System.out.println("Student registered successfully!");
    }

    // Register a new supervisor
    private static void registerSupervisor(Scanner scanner) {
        System.out.println("Enter Supervisor Details:");
        System.out.print("Supervisor ID: ");
        String supervisorId = scanner.nextLine();
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Qualification (Bachelors, Masters, PhD): ");
        String qualification = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Supervisor supervisor = new Supervisor(supervisorId, fullName, qualification, email);
        supervisors.add(supervisor);
        System.out.println("Supervisor registered successfully!");
    }

    // Assign an internship based on user choice
    private static void assignInternship(Scanner scanner) {
        System.out.println("Select Internship Type:");
        System.out.println("1. ULK Internship");
        System.out.println("2. UR Internship");
        System.out.println("3. AUCA Internship");
        System.out.println("4. UK Internship");
        System.out.println("5. Remote Internship");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Internship ID: ");
        String internshipId = scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Supervisor ID: ");
        String supervisorId = scanner.nextLine();
        System.out.print("Enter Company Name: ");
        String companyName = scanner.nextLine();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDateStr = scanner.nextLine();
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String endDateStr = scanner.nextLine();

        // Find student and supervisor by ID
        Student student = findStudentById(studentId);
        Supervisor supervisor = findSupervisorById(supervisorId);

        if (student == null || supervisor == null) {
            System.out.println("Student or Supervisor not found!");
            return;
        }

        // Convert strings to LocalDate
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        // Create and assign internship based on type
        Internship internship = null;

        switch (type) {
            case 1:
                internship = new ULKInternship(internshipId, student, companyName, supervisor, startDate, endDate, "PENDING");
                break;
            case 2:
                internship = new URInternship(internshipId, student, companyName, supervisor, startDate, endDate, "PENDING");
                break;
            case 3:
                internship = new AUCAInternship(internshipId, student, companyName, supervisor, startDate, endDate, "PENDING");
                break;
            case 4:
                internship = new UKInternship(internshipId, student, companyName, supervisor, startDate, endDate, "PENDING");
                break;
            case 5:
                internship = new RemoteInternship(internshipId, student, companyName, supervisor, startDate, endDate, "PENDING");
                break;
            default:
                System.out.println("Invalid internship type!");
                return;
        }

        // Validate the internship (void method)
        internship.validateInternship(); // This will print the validation messages

        // After validation, check if the internship is valid based on the printed messages
        if (internship instanceof ULKInternship) {
            internship.assignSupervisor();
            internship.trackProgress();
            internship.generateReport();
            internships.add(internship);
            System.out.println("Internship assigned successfully!");
        } else {
            System.out.println("Internship validation failed.");
        }
    }

    // Generate an internship report
    private static void generateInternshipReport(Scanner scanner) {
        System.out.print("Enter Internship ID to generate report: ");
        String internshipId = scanner.nextLine();

        Internship internship = findInternshipById(internshipId);
        if (internship != null) {
            internship.generateReport();
        } else {
            System.out.println("Internship not found.");
        }
    }

    // Track progress of an internship
    private static void trackInternshipProgress(Scanner scanner) {
        System.out.print("Enter Internship ID to track progress: ");
        String internshipId = scanner.nextLine();

        Internship internship = findInternshipById(internshipId);
        if (internship != null) {
            internship.trackProgress();
        } else {
            System.out.println("Internship not found.");
        }
    }

    // Helper method to find a student by ID
    private static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    // Helper method to find a supervisor by ID
    private static Supervisor findSupervisorById(String supervisorId) {
        for (Supervisor supervisor : supervisors) {
            if (supervisor.getSupervisorId().equals(supervisorId)) {
                return supervisor;
            }
        }
        return null;
    }

    // Helper method to find an internship by ID
    private static Internship findInternshipById(String internshipId) {
        for (Internship internship : internships) {
            if (internship.getInternshipId().equals(internshipId)) {
                return internship;
            }
        }
        return null;
    }
}

