/**
 * Represents a program that represents a soccer player on the soccer team.
 *
 * @author prumyantseva3
 * @version 13.31
 */
public abstract class SoccerPlayer {
    private String name;
    private String country;
    private int stamina;

    /**
     * Creates a SoccerPlayer with all required parameters.
     *
     * @param name    the name of the soccer player
     * @param country the country of the soccer player
     * @param stamina the stamina of the soccer player
     */
    public SoccerPlayer(String name, String country, int stamina) {
        this.setName(name);
        this.setCountry(country);
        if (stamina < 1) {
            stamina = 20;
        }
        this.setStamina(stamina);
    }

    /**
     * Sets the name of the soccer player.
     *
     * @param name the name of the soccer player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the country for the soccer player.
     *
     * @param country the country from where the goalkeeper is from.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Sets the stamina for the goalkeeper.
     *
     * @param stamina the stamina of the goalkeeper
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     * @return this soccer player's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return this soccer player's country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * @return this soccer player's total stamina
     */
    public int getStamina() {
        return this.stamina;
    }

    @Override
    public String toString() {
        return this.name + " from " + this.country + " has " + this.stamina + " stamina left.";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof SoccerPlayer)) {
            return false;
        }
        SoccerPlayer p = (SoccerPlayer) o;
        return (p.name.equals(this.name) && (p.country.equals(this.country)));
    }

    /**
     * Creates an abstract method play() which does not return anything.
     */
    public abstract void play();

    /**
     * Creates an abstract method calculateRating() which returns a double
     * representing the rating of the certain soccer player.
     *
     * @return the soccer player's specific calculated rating
     */
    public abstract double calculateRating();

    /**
     * Creates a method rest() which increases the player's stamina by 5.
     */
    public void rest() {
        this.setStamina(stamina + 5);
    }
}
