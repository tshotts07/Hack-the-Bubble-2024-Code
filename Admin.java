import java.util.ArrayList;

public class Admin extends User {
    public Admin(String name) {
        super(name);
    }

    public void addIssue(ArrayList<Issue> issues, String issueName, String description) {
        Issue newIssue = new Issue(issueName, description); // Fix constructor call
        issues.add(newIssue);
        System.out.println("Admin " + getName() + " has added a new issue: " + description);
    }

    public void removeIssue(ArrayList<Issue> issues, Issue issue) {
        if (issues.remove(issue)) {
            System.out.println("Admin " + getName() + " has removed an issue: " + issue.getDescription());
        } else {
            System.out.println("Issue not found.");
        }
    }

    // Define the viewIssues method for Admin
    public void viewIssues(ArrayList<Issue> issues) {
        System.out.println("\n--- Issues ---");
        for (Issue issue : issues) {
            System.out.println(issue.getIssueName() + ": " + issue.getDescription());
        }
    }

    @Override
    public void performRole() {
        System.out.println(getName() + " is performing their role as an admin.");
    }
}
