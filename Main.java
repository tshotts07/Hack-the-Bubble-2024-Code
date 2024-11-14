import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) { // Note the lowercase 'm' in 'main'
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 1: to be a Citizen");
        System.out.println("Enter 2: to be an Admin");

        int user = input.nextInt();
        input.nextLine();

        User currentUser = null;
        if (user == 1) {
            currentUser = new Citizen("Citizen");
        } else if (user == 2) {
            currentUser = new Admin("Admin");
        } else {
            System.out.println("Invalid choice. Enter 1 or 2. Exiting. . .");
            return;
        }

        ArrayList<Issue> issues = DataLoader.loadIssues("issues.csv");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Democracy System ---");
            if (currentUser instanceof Admin) {
                System.out.println("1. View Issues");
                System.out.println("2. Add Issue");
                System.out.println("3. Remove Issue");
            } else if (currentUser instanceof Citizen) {
                System.out.println("1. View Issues");
                System.out.println("2. Vote on Issue");
            }

            System.out.println("3. Exit");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    if (currentUser instanceof Admin) {
                        Admin admin = (Admin) currentUser;
                        admin.viewIssues(issues);
                    } else if (currentUser instanceof Citizen) {
                        Citizen citizen = (Citizen) currentUser;
                        citizen.viewIssues(issues);
                    }
                    break;

                case 2:
                    if (currentUser instanceof Admin) {
                        Admin admin = (Admin) currentUser;
                        System.out.print("Enter issue name: ");
                        String name = input.nextLine();
                        System.out.print("Enter issue description: ");
                        String description = input.nextLine();
                        admin.addIssue(issues, name, description);
                    } else if (currentUser instanceof Citizen) {
                        Citizen citizen = (Citizen) currentUser;
                        System.out.println("\n--- List of Issues ---");
                        for (int i = 0; i < issues.size(); i++) {
                            Issue issue = issues.get(i);
                            System.out.println((i + 1) + ". " + issue.getDescription());
                        }

                        System.out.print("Select an issue to vote on (enter number): ");
                        int issueNumber = input.nextInt();
                        input.nextLine();

                        if (issueNumber > 0 && issueNumber <= issues.size()) {
                            Issue selectedIssue = issues.get(issueNumber - 1);
                            System.out.print("Vote Yes or No (true for Yes, false for No): ");
                            boolean vote = input.nextBoolean();
                            citizen.voteOnIssue(selectedIssue, vote);
                        } else {
                            System.out.println("Invalid issue number.");
                        }
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        input.close();
    }
}
