import java.util.ArrayList;
import java.lang.String;

public class Team {
    private String name;
    private ArrayList<Player> players;
    private double averageRating;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<Player>();
    }

    public void updateAverage() {

    }

    public void addPlayer(Player player) {
        players.add(player);

        updateAverage();
    }

    public void removePlayer(Player player) {
        players.remove(player);

        updateAverage();
    }

    public void showPlayers() {
        System.out.println("=== Team: " + this.name + " ===");
        System.out.println(" - Average Rating: " + this.averageRating);

        for (Player player : players)
            //playerlist = playerlist + player.getName() + "\n"; -> make new obj every time.  less efficient
            System.out.println(" - " + player);
    }


}
