// Prototype Pattern

/*
✅ When to Use

Use Prototype when:

Object creation is costly

You want to clone objects

Avoid creating objects from scratch

📘 Scenario

An Exam Registration System creates multiple students with same basic info.
Instead of creating again, system clones an existing object.
*/

// Prototype Interface
interface Student extends Cloneable {
    Student clone();
}

// Concrete Prototype
class UniversityStudent implements Student {
    String department;

    UniversityStudent(String department) {
        this.department = department;
    }

    public Student clone() {
        return new UniversityStudent(this.department);
    }
}

// Client
public class PrototypePattern {
    public static void main(String[] args) {
        UniversityStudent s1 = new UniversityStudent("CSE");
        UniversityStudent s2 = (UniversityStudent) s1.clone();

        System.out.println(s2.department);
    }
}
