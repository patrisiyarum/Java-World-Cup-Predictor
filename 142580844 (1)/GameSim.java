/**
 * Represents a program that represents a simulated soccer game.
 *
 * @author prumyantseva3
 * @version 13.31
 */
public class GameSim {
    /**
     * Creates a GameSim method that calls the arguments created in the different classes in this package.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        Team[] teams = new Team[4];
        teams[0] = new Team("Dogs");
        teams[1] = new Team("Cats");
        //teams[2] = new Team("Fish");
        //teams[3] = new Team("Frogs");
        GoalKeeper gpDogs = new GoalKeeper("dog1", "USA", 100, 10,
                20, 3);
        gpDogs.play();
        Defender dfDogs = new Defender("dog2", "USA", 100, 10, 5, 3);
        dfDogs.play();
        Attacker afDogs = new Attacker("dog3",
                "USA",
                100,
                29,
                30,
                6,
                Attacker.CelebrationMove.SIUU);
        afDogs.play();
        Defender df3Dogs = new Defender("dog2", "USA", 100, 0, 0, 0);
        df3Dogs.play();

        teams[0].addTeamMember(gpDogs);
        teams[0].addTeamMember(dfDogs);
        teams[0].addTeamMember(afDogs);
        teams[0].addTeamMember(df3Dogs);

        GoalKeeper gpCats = new GoalKeeper("cats1", "Russia", 100, 10,
                20, 3);
        gpCats.play();
        gpCats.calculateRating();

        Defender dfCats = new Defender("cats2", "Russia", 100, 10, 5, 3);
        dfCats.play();
        //dfCats.calculateRating();

        Attacker afCats = new Attacker("cats3", "Russia", 100, 29, 30,
                6, Attacker.CelebrationMove.SIUU);
        afCats.play();
        Attacker af3Cats = new Attacker("cats3", "Russia", 100, 29, 30, 6, Attacker.CelebrationMove.SIUU);
        af3Cats.play();
        //System.out.println(afCats.equals(af3Cats));
        //System.out.println(afCats.getTotalShotsOnTarget());
        //afCats.calculateRating();

        Defender df2Cats = new Defender("cats2", "Russia", 100, 10, 5, 3);
        df2Cats.play();
        //df2Cats.calculateRating();

        teams[1].addTeamMember(gpCats);
        teams[1].addTeamMember(dfCats);
        teams[1].addTeamMember(afCats);
        teams[1].addTeamMember(df2Cats);

        System.out.println(teams[1]);
        System.out.println(teams[0]);
        System.out.println(teams[1].playAgainstTeam(teams[0]));


        //System.out.println(gpDogs.calculateRating());
        //Attacker a = new Attacker("ilona", "USA", 90, 0,10,2,Attacker.CelebrationMove.CARTWHEEL);
        //Defender b = new Defender("ilona", "USA", 100, 10,0,2);
        // System.out.println(a.getStamina());
        //a.play();
        //System.out.println(a);
        //a.play();
        //System.out.println(a);
        //System.out.println(a.getAttackingRating());
        //System.out.println(a.equals(b));
        //System.out.println(a.getBallHandling());
        //Defender b = new Defender("ilona", "USA", 100, 100,100,2);
        //System.out.println(b.equals(a));
        /*
        System.out.println(dfDogs);
        dfDogs.play();
        System.out.println(dfDogs);
        //System.out.println(dfDogs.calculateRating());

        /*
        //afDogs.calculateRating();

        Defender df2Dogs = new Defender("dog2", "USA", 100, 10, 5, 3);
        df2Dogs.play();

        //dfDogs.calculateRating();
        //use equals method on this dog
        //System.out.println(dfDogs.equals(df2Dogs));




        //System.out.println(teams[0]);
        //System.out.println(gpDogs);
        //System.out.println(dfDogs);
        //System.out.println(teams[1]);
        //System.out.println(teams[1]);

        //System.out.println(teams[0].playAgainstTeam(teams[1]));

        //

        //af3Cats.rest();
        //System.out.println(df3Cats.getTotalPassesCompleted());
        // System.out.println("stamina after rest " + af3Cats.getStamina());
        //System.out.println("total goals completed" + af3Cats.getTotalGoals());
        //System.out.println("total shots at target" + af3Cats.getTotalShotsOnTarget());
        //af3Cats.calculateRating();
        //System.out.println("attack rating after calc rating " + af3Cats.getAttackingRating());
        //af3Cats.play();
        //System.out.println("game sim stamina " + af3Cats.getStamina());
        //System.out.println("attacking rating game sim " + af3Cats.getAttackingRating());
        //System.out.println(af3Cats);
        //af3Cats.play();
        //System.out.println(af3Cats);

*/
    }
}
