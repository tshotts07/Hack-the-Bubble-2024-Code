public class Issue {
    private String issueName;
    private String description;
    private int yesVotes;
    private int noVotes;

    // Constructor with both name and description
    public Issue(String issueName, String description) {
        this.issueName = issueName;
        this.description = description;
        this.yesVotes = 0;
        this.noVotes = 0;
    }

    // Getter methods
    public String getIssueName() {
        return issueName;
    }

    public String getDescription() {
        return description;
    }

    public int getYesVotes() {
        return yesVotes;
    }

    public int getNoVotes() {
        return noVotes;
    }

    // Voting methods
    public void voteYes() {
        yesVotes++;
    }

    public void voteNo() {
        noVotes++;
    }

    // Get the result of votes
    public String getResult() {
        if (yesVotes > noVotes) {
            return "Approved";
        } else if (noVotes > yesVotes) {
            return "Rejected";
        } else {
            return "Tied";
        }
    }
}
