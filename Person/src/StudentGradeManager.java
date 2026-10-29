
class Student {
    String name;
    String studentId;
    double score;

    // Constructor: initializes a student
    Student(String studentName, String id, double studentScore) {
        name = studentName;
        studentId = id;
        score = studentScore;
    }

    // Displays student information
    void displayInformation() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("Score: " + score);
        System.out.println("Grade: " + calculateGrade());
        System.out.println("Status: " + getStatus());
        System.out.println("Performance: " + getPerformance());
    }

    // Updates the student's score
    void updateScore(double newScore) {
        if (newScore >= 0 && newScore <= 100) {
            score = newScore;
            System.out.println("Score updated successfully.");
        } else {
            System.out.println("Invalid score. Enter 0 to 100.");
        }
    }

    // Calculates the grade
    char calculateGrade() {
        if (score >= 80)
            return 'A';
        else if (score >= 70)
            return 'B';
        else if (score >= 60)
            return 'C';
        else if (score >= 50)
            return 'D';
        else
            return 'F';
    }

    // Checks whether the student passed
    String getStatus() {
        if (score >= 50)
            return "Passed";
        else
            return "Failed";
    }

    // Returns the student's performance
    String getPerformance() {
        if (score >= 80)
            return "Excellent";
        else if (score >= 70)
            return "Good";
        else if (score >= 60)
            return "Average";
        else
            return "Needs Improvement";
    }
}

public class StudentGradeManager {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", "ST001", 85);
        Student student2 = new Student("David", "ST002", 72);
        Student student3 = new Student("Peter", "ST003", 45);

        System.out.println("===== STUDENT 1 =====");
        student1.displayInformation();

        System.out.println("\n===== STUDENT 2 =====");
        student2.displayInformation();

        System.out.println("\n===== STUDENT 3 =====");
        student3.displayInformation();

        System.out.println("\nUpdating Alice's score...");
        student1.updateScore(90);
        student1.displayInformation();
    }
}
