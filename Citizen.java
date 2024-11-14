import java.util.ArrayList;

public class Citizen extends User {
    private boolean hasVotedIssue = false;
    private boolean hasVotedElection = false;

    public Citizen(String name) {
        super(name);
    }

    public void voteOnIssue(Issue issue, boolean voteYes) {
        if (!hasVotedIssue) {
            if (voteYes) {
                issue.voteYes();
            } else {
                issue.voteNo();
            }
            hasVotedIssue = true;
            System.out.println(getName() + " has voted on the issue: " + issue.getDescription());
        } else {
            System.out.println(getName() + " has already voted on this issue.");
        }
    }

    public void voteForCandidate(Candidate candidate) {
        if (!hasVotedElection) {
            candidate.addVote();
            hasVotedElection = true;
            System.out.println(getName() + " has voted for candidate: " + candidate.getName());
        } else {
            System.out.println(getName() + " has already voted for this candidate.");
        }
    }

    // Define the viewIssues method for Citizen
    public void viewIssues(ArrayList<Issue> issues) {
        System.out.println("\n--- Issues ---");
        for (Issue issue : issues) {
            System.out.println(issue.getIssueName() + ": " + issue.getDescription());
        }
    }

    @Override
    public void performRole() {
        System.out.println(getName() + " is performing their role as a citizen!");
    }
}
