/**
 * Represents a program that represents an attacker on the soccer team.
 *
 * @author prumyantseva3
 * @version 13.31
 */
public class Attacker extends SoccerPlayer {
    private int totalGoals;
    private int totalShotsOnTarget;
    private double attackingRating;

    /**
     * This documents "CelebrationMove".
     */
    public enum CelebrationMove {
        DIVE, CARTWHEEL, SIUU
    }

    private CelebrationMove celebrationMove;

    /**
     * @return this attacker's total goals
     */
    public int getTotalGoals() {
        return totalGoals;
    }

    /**
     * Sets the total goals of the attacker.
     *
     * @param totalGoals the total goals scored by the attacker.
     *                   Total goals cannot be greater than the total shots on target
     */
    public void setTotalGoals(int totalGoals) {
        if (totalGoals > totalShotsOnTarget) {
            this.totalGoals = totalShotsOnTarget;
        } else {
            this.totalGoals = totalGoals;
        }

    }

    /**
     * @return this attacker's total shots on target
     */
    public int getTotalShotsOnTarget() {
        return totalShotsOnTarget;
    }

    /**
     * Sets the total shots on target by the attacker.
     *
     * @param totalShotsOnTarget the total shots on target by the attacker
     */
    public void setTotalShotsOnTarget(int totalShotsOnTarget) {
        this.totalShotsOnTarget = totalShotsOnTarget;
    }

    /**
     * @return this attacker's attacking rating
     */
    public double getAttackingRating() {
        return attackingRating;
    }

    /**
     * Sets the attacking rating of the attacker.
     *
     * @param attackingRating the total shots on target by the attacker
     */
    public void setAttackingRating(double attackingRating) {
        if (attackingRating >= 0 && attackingRating < +100) {
            this.attackingRating = attackingRating;
        }
    }

    /**
     * @return this attacker's celebration move
     */
    public CelebrationMove getCelebrationMove() {
        return celebrationMove;
    }

    /**
     * Sets the celebration move  of the attacker.
     *
     * @param celebrationMove the celebration move of the attacker
     */
    public void setCelebrationMove(CelebrationMove celebrationMove) {
        this.celebrationMove = celebrationMove;
    }

    /**
     * Creates an Attacker with all required parameters.
     *
     * @param name    the name of the attacker
     * @param country the country of the attacker
     * @param stamina the stamina of the attacker
     * @param tG      the total goals by the attacker
     * @param tST     the total shots completed by the attacker
     * @param aR      the dattacking rating of the attacker
     * @param cM      the celebration move of the attacker
     */
    public Attacker(String name, String country, int stamina, int tG, int tST, double aR, Attacker.CelebrationMove cM) {
        super(name, country, stamina);
        this.setTotalShotsOnTarget(tST);
        this.setTotalGoals(tG);
        this.setAttackingRating(aR);
        this.setCelebrationMove(cM);
    }

    @Override
    public double calculateRating() {
        if (totalShotsOnTarget == 0) {
            this.attackingRating = 0.0;
        } else {
            this.setAttackingRating((double) totalGoals / totalShotsOnTarget * 100);

        }
        return this.attackingRating;


    }

    @Override
    public void play() {
        int ran = (int) (Math.random() * 100) + 1;
        if ((this.getStamina() - ran) < 0) {
            this.setStamina(0);
        } else {
            this.setStamina(this.getStamina() - ran);
        }
        int ranShots = (int) (Math.random() * 101);
        int ranGoals = (int) (Math.random() * (ranShots + 1));
        //System.out.println("ran goals before "+ ranGoals);
        //System.out.println(ranShots);
        //System.out.println("ran goals before chance" + ranGoals);
        if (this.getStamina() == 0) {
            ranGoals = 0;
        } else if (celebrationMove == CelebrationMove.SIUU) {
            ranGoals += ranGoals / 10;
            if (ranGoals > ranShots) {
                ranGoals = ranShots;
            }
        }
        //System.out.println("ran goals after " + ranGoals);
        this.totalShotsOnTarget += ranShots;
        this.totalGoals += ranGoals;
        this.setAttackingRating(this.calculateRating());
        //System.out.println("total shots on target " + this.totalShotsOnTarget);
        //System.out.println("total goals  " + this.totalGoals);
        //System.out.println("ran goals after chance" + ranGoals);

    }

    @Override
    public String toString() {
        return super.toString() + " As an Attacker, I have scored "
                + this.totalGoals + " goals from " + this.totalShotsOnTarget
                + " shots on target and my rating is "
                + String.format("%.2f", (double) Math.round(this.attackingRating * 100.0) / 100.0)
                + ". My celebration is " + this.celebrationMove + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        Attacker af = (Attacker) o;
        return super.equals(af) && af.totalGoals == this.totalGoals
                && af.totalShotsOnTarget == this.totalShotsOnTarget
                && af.attackingRating == this.attackingRating
                && af.celebrationMove == this.celebrationMove;
    }
}
