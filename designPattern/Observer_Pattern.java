//Observer_Pattern 

/*
📘 Scenario

A Result Publishing System in a university notifies students when results are published.
Students subscribe to the result board.
When results are updated, all subscribed students receive notification automatically.
*/

import java.util.*;

// Observer
interface Student {
    void notifyResult();
}

// Concrete Observer
class RegisteredStudent implements Student {
    String name;

    RegisteredStudent(String name) {
        this.name = name;
    }

    public void notifyResult() {
        System.out.println(name + " received result notification");
    }
}

// Subject
class ResultBoard {
    List<Student> students = new ArrayList<>();

    void subscribe(Student s) {
        students.add(s);
    }

    void publishResult() {
        for (Student s : students) {
            s.notifyResult();
        }
    }
}

// Client
public class Observer_Pattern  {
    public static void main(String[] args) {
        ResultBoard board = new ResultBoard();

        board.subscribe(new RegisteredStudent("Rahim"));
        board.subscribe(new RegisteredStudent("Karim"));

        board.publishResult();
    }
}
