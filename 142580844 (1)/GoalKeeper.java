/**
 * Represents a program that represents a goalkeeper on the soccer team.
 *
 * @author prumyantseva3
 * @version 13.31
 */
public class GoalKeeper extends SoccerPlayer {
    private int totalSaves;
    private int totalShotsOnTarget;
    private double ballHandling;


    /**
     * Creates a GoalKeeper with all required parameters.
     *
     * @param name    the name of the goalkeeper
     * @param country the country of the goalkeeper
     * @param stamina the stamina of the goalkeeper
     * @param totalS  the total saves of the goalkeeper
     * @param totalST the total shots at target of the goalkeeper
     * @param bH      the ball handling of the goalkeeper
     */
    public GoalKeeper(String name, String country, int stamina, int totalS, int totalST, double bH) {
        super(name, country, stamina);
        this.setTotalShotsOnTarget(totalST);
        this.setTotalSaves(totalS);
        this.setBallHandling(bH);

    }

    /**
     * Sets the totalSaves for the game based on the totalShotsOnTarget and the totalSaves parameter.
     *
     * @param totalS must be less than totalShotsOnTarget
     */
    public void setTotalSaves(int totalS) {
        if (totalS < totalShotsOnTarget) {
            this.totalSaves = totalS;
        } else {
            this.totalSaves = totalShotsOnTarget;
        }
    }

    /**
     * @return this goalkeeper's total saves
     */
    public int getTotalSaves() {
        return totalSaves;
    }

    /**
     * Sets the totalShotsOnTarget for the game based on the totalShotsOnTarget.
     *
     * @param totalST the totalShotsOnTarget for the goalkeeper
     */
    public void setTotalShotsOnTarget(int totalST) {
        this.totalShotsOnTarget = totalST;
    }

    /**
     * @return this goalkeeper's total shots on target.
     */
    public int getTotalShotsOnTarget() {
        return totalShotsOnTarget;
    }

    /**
     * Sets the ballHandling for the game based on the bH parameter.
     *
     * @param bH must be between 0 and 100 (inclusive)
     */
    public void setBallHandling(double bH) {
        if (bH >= 0 && bH <= 100) {
            this.ballHandling = bH;
        }
    }

    /**
     * @return this goalkeeper's ball handling score
     */
    public double getBallHandling() {
        return ballHandling;
    }

    @Override
    public double calculateRating() {
        if (totalShotsOnTarget == 0) {
            this.ballHandling = 0.0;

        } else {
            this.setBallHandling((double) totalSaves / totalShotsOnTarget * 100);
        }
        return this.ballHandling;

    }

    @Override
    public void play() {
        int ran = (int) (Math.random() * 100) + 1;
        //System.out.println(ran);
        if ((this.getStamina() - ran) < 0) {
            this.setStamina(0);
        } else {
            this.setStamina(this.getStamina() - ran);
        }
        int ranShots = (int) (Math.random() * 101);
        //System.out.println(ranShots);
        int ranSaves = (int) (Math.random() * (ranShots + 1));
        //System.out.println(ranSaves);
        if (this.getStamina() == 0) {
            ranSaves = 0;
            //ranSaves = 0
        }
        this.totalSaves += ranSaves;
        this.totalShotsOnTarget += ranShots;
        this.setBallHandling(this.calculateRating());
    }

    @Override
    public String toString() {
        String s = " As a Goalkeeper, I have stopped ";
        String s2 = " shots on target and my rating is ";
        String s3 = String.format("%.2f", Math.round(this.ballHandling * 100.0) / 100.0) + ".";
        return super.toString() + s + this.totalSaves + " shots from " + this.totalShotsOnTarget + s2 + s3;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof GoalKeeper)) {
            return false;
        }
        GoalKeeper gp = (GoalKeeper) o;
        return super.equals(gp) && gp.totalSaves == this.totalSaves
                && gp.totalShotsOnTarget == this.totalShotsOnTarget
                && gp.ballHandling == this.ballHandling;
    }

}

