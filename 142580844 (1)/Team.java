/**
 * Represents a program that represents a soccer team.
 *
 * @author prumyantseva3
 * @version 13.31
 */
public class Team {
    private String teamName;
    private SoccerPlayer[] players;

    /**
     * @return this team's players
     */
    public SoccerPlayer[] getPlayers() {
        return players;
    }

    /**
     * Sets the players  for the team.
     *
     * @param players the array of soccer players
     */
    public void setPlayers(SoccerPlayer[] players) {
        this.players = players;
    }

    /**
     * @return this team's name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets the team name for the team.
     *
     * @param teamName the name of the team
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Creates a Team with all required parameters.
     *
     * @param teamName the name of the team
     */
    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new SoccerPlayer[11];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                s = s + players[i].toString() + "\n";
            }
        }
        return "Team name: " + this.teamName + " " + "\n" + s;
    }

    /**
     * Creates an addTeamMember which adds a player to the team.
     *
     * @param player the soccer player being added to the team.
     */
    public void addTeamMember(SoccerPlayer player) {
        boolean added = false;
        for (int x = 0; x < players.length; x++) {
            if (players[x] == null) {
                if (!added) {
                    players[x] = player;
                    added = true;
                }
            }
        }
    }

    /**
     * Creates a playAgainstTeam which compares two teams to each other to see who has the highest average rating.
     *
     * @param opponent the opponent team
     * @return the team that has the highest player rating average or
     * returns a tie in case of a tie.
     */
    public String playAgainstTeam(Team opponent) {
        // check if the player is null!!
        double a = 0;
        double b = 0;
        int count1 = 0;
        int count2 = 0;
        for (SoccerPlayer player : opponent.players) {
            if (player != null) {
                player.play();
                a = a + player.calculateRating();
                count1++;
            }
        }
        double opponentRating = a / (count1);
        //System.out.println("opponent rating" + opponentRating);
        for (SoccerPlayer player : this.players) {
            if (player != null) {
                player.play();
                b = b + player.calculateRating();
                count2++;
            }
        }
        double myRating = b / (count2);
        //System.out.println("my rating "+ myRating);
        if (myRating > opponentRating) {
            return this.teamName;
        } else if (opponentRating > myRating) {
            return opponent.teamName;
        } else {
            return "Tie.";
        }

    }

}
