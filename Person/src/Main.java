
class Person {
    String name;

    Person(String name) {
        this.name = name;
        System.out.println("Person constructor called");
    }
}

class Student extends Person {
    String studentId;

    Student(String name, String id) {
        super(name); // Calls Person constructor
        studentId = id;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentId);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Anaclet", "ST001");
        s1.display();
    }
}
