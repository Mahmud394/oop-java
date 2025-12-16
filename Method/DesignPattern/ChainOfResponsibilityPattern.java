// ChainOfResponsibilityPattern

/*
✅ When to Use

Use Chain of Responsibility when:

A request can be handled by multiple objects

You do not know which object will handle the request

You want to avoid tight coupling between sender and receiver

Requests should be processed step by step

📘 Scenario

A University Help Desk System handles student requests in levels:

Reception handles simple queries

Department Office handles academic issues

Dean Office handles serious complaints

A request is passed along the chain until someone can handle it.
*/
// Handler (Abstract Class)
abstract class HelpDesk {
    protected HelpDesk next;

    void setNext(HelpDesk next) {
        this.next = next;
    }

    abstract void handleRequest(String issue);
}

// Concrete Handler 1
class Reception extends HelpDesk {
    void handleRequest(String issue) {
        if (issue.equals("General")) {
            System.out.println("Reception handled the issue");
        } else if (next != null) {
            next.handleRequest(issue);
        }
    }
}

// Concrete Handler 2
class DepartmentOffice extends HelpDesk {
    void handleRequest(String issue) {
        if (issue.equals("Academic")) {
            System.out.println("Department Office handled the issue");
        } else if (next != null) {
            next.handleRequest(issue);
        }
    }
}

// Concrete Handler 3
class DeanOffice extends HelpDesk {
    void handleRequest(String issue) {
        System.out.println("Dean Office handled the issue");
    }
}

// Client
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        HelpDesk reception = new Reception();
        HelpDesk department = new DepartmentOffice();
        HelpDesk dean = new DeanOffice();

        reception.setNext(department);
        department.setNext(dean);

        reception.handleRequest("Academic");
    }
}
