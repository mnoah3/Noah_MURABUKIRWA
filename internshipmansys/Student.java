package internshipmansys;
public class Student {

    private String studentId;
    private String fullName;
    private String university;
    private String email;

    public Student(String studentId, String fullName, String university, String email) {
        setStudentId(studentId);
        setFullName(fullName);
        setUniversity(university);
        setEmail(email);
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUniversity(String university) {
        if (university.equals("ULK") || university.equals("UR") || university.equals("AUCA") || university.equals("UK")) {
            this.university = university;
        } else {
            System.out.println("Invalid university. Must be ULK, UR, AUCA, or UK.");
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
    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversity() {
        return university;
    }

    public String getEmail() {
        return email;
    }
}

