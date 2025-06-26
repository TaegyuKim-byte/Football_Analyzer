import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }


}
