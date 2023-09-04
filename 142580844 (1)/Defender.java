/**
 * Represents a program that represents a defender on the soccer team.
 *
 * @author prumyantseva3
 * @version 13.31
 */
public class Defender extends SoccerPlayer {
    private int totalPasses;
    private int totalPassesCompleted;
    private double defenseRating;

    /**
     * Creates a Defender with all required parameters.
     *
     * @param name    the name of the defender
     * @param country the country of the defender
     * @param stamina the stamina of the defender
     * @param totalP  the total passes by the defender
     * @param totalPC the total passes completed by the defender
     * @param df      the defense rating of the defender
     */
    public Defender(String name, String country, int stamina, int totalP, int totalPC, double df) {
        super(name, country, stamina);
        this.totalPasses = totalP;
        this.setTotalPassesCompleted(totalPC);
        this.setDefenseRating(df);


    }

    //public void setPasses(int totalPasses) {
    //this.totalPasses = totalPasses;
    //}

    /**
     * Sets the total passes completed by the defender.
     *
     * @param totalPassesCompleted the total passes completed by the defender.It must be less tha the total passes
     */
    public void setTotalPassesCompleted(int totalPassesCompleted) {
        if (totalPassesCompleted < totalPasses) {
            this.totalPassesCompleted = totalPassesCompleted;
        } else {
            this.totalPassesCompleted = totalPasses;
        }
    }

    /**
     * Sets the defense rating of the defender.
     *
     * @param defenseRating the defense rating of the defender. It must be greater than 0
     */
    public void setDefenseRating(double defenseRating) {
        if (defenseRating > 0) {
            this.defenseRating = defenseRating;
        }
    }

    /**
     * @return this defender's total passes
     */
    public int getTotalPasses() {
        return this.totalPasses;
    }

    /**
     * @return this defender's total passes completed
     */
    public int getTotalPassesCompleted() {
        return this.totalPassesCompleted;
    }

    /**
     * @return this defender's defense rating
     */
    public double getDefenseRating() {
        return this.defenseRating;
    }

    @Override
    public double calculateRating() {
        if (totalPasses == 0) {
            this.defenseRating = 0.0;
        } else {
            this.setDefenseRating((double) totalPassesCompleted / totalPasses * 100);
        }
        return this.defenseRating;

    }

    @Override
    public void play() {
        int ran = (int) (Math.random() * 100) + 1;
        //System.out.println("ran stamina num " + ran);
        if ((this.getStamina() - ran) < 0) {
            this.setStamina(0);
        } else {
            this.setStamina(this.getStamina() - ran);
        }
        int ranPasses = (int) (Math.random() * 101);
        int ranCompletedPasses = (int) (Math.random() * (ranPasses + 1));
        int randomChance = (int) (Math.random() * 10);
        if (this.getStamina() == 0) {
            ranCompletedPasses = 0;
        } else if (randomChance == 1) {
            ranCompletedPasses = ranPasses;
        }
        this.totalPassesCompleted += ranCompletedPasses;
        this.totalPasses += ranPasses;
        this.setDefenseRating(this.calculateRating());
        //System.out.println("stamina in def " + this.getStamina());
        /*System.out.println("total passes " + totalPasses);
        System.out.println("total passes completed " + totalPassesCompleted);
        System.out.println("the random chance " + randomChance);
        System.out.println("the random passes " + ranPasses);
        System.out.println("the random passes completed " + ranCompletedPasses);
        */
    }

    @Override
    public String toString() {
        String s = " As a Defender, I have completed ";
        String s1 = " passes from " + this.totalPasses + " initiated passes and my rating is ";
        String s3 = String.format("%.2f", Math.round(this.defenseRating * 100.0) / 100.0) + ".";
        return super.toString() + s + this.totalPassesCompleted + s1 + s3;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        Defender df = (Defender) o;
        return super.equals(df) && df.totalPasses == this.totalPasses
                && df.totalPassesCompleted == this.totalPassesCompleted
                && df.defenseRating == this.defenseRating;
    }

}
