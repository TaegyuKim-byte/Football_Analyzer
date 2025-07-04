import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;

public class FootballManager {
    ArrayList<Player> players;
    ArrayList<Team> teams;
    ArrayList<League> leagues;

    public FootballManager() {
        players = new ArrayList<>();
        teams = new ArrayList<>();
        leagues = new ArrayList<>();
    }

    public void registerPlayerSet(String inputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; //빈 줄 무시 (trim: 공백 무시)

                String[] tokens = line.split(",");
                if (tokens.length != 27) {
                    System.out.println("[!] Error of data form: " + line);
                    continue;
                }

                String name = tokens[0].trim();
                int age = Integer.parseInt(tokens[1].trim());
                //String 을 int로 변환
                String country = tokens[2].trim();

                Player p = new Player(name, age, country);

                p.setPreferredPosition(Position.valueOf(tokens[3].trim()));

                p.setLeftFoot(Integer.parseInt(tokens[4].trim()));
                p.setRightFoot(Integer.parseInt(tokens[5].trim()));

                p.setShooting(Integer.parseInt(tokens[6].trim()));
                p.setPassing(Integer.parseInt(tokens[7].trim()));
                p.setDribbling(Integer.parseInt(tokens[8].trim()));
                p.setCrossing(Integer.parseInt(tokens[9].trim()));
                p.setTackling(Integer.parseInt(tokens[10].trim()));
                p.setHeading(Integer.parseInt(tokens[11].trim()));
                p.setBallControl(Integer.parseInt(tokens[12].trim()));
                p.setVision(Integer.parseInt(tokens[13].trim()));
                p.setComposure(Integer.parseInt(tokens[14].trim()));
                p.setDecisionMaking(Integer.parseInt(tokens[15].trim()));
                p.setWorkRate(Integer.parseInt(tokens[16].trim()));
                p.setLeadership(Integer.parseInt(tokens[17].trim()));
                p.setPositioning(Integer.parseInt(tokens[18].trim()));
                p.setOffTheBall(Integer.parseInt(tokens[19].trim()));
                p.setPace(Integer.parseInt(tokens[20].trim()));
                p.setStamina(Integer.parseInt(tokens[21].trim()));
                p.setStrength(Integer.parseInt(tokens[22].trim()));
                p.setJumping(Integer.parseInt(tokens[23].trim()));
                p.setAgility(Integer.parseInt(tokens[24].trim()));
                p.setSaving(Integer.parseInt(tokens[25].trim()));
                p.setBuildupPlay(Integer.parseInt(tokens[26].trim()));

                p.calculateAllFit();

                players.add(p);
                System.out.println("Player " + p.getName() +  " registered successfully!");

                p.showPlayer();
            }
        } catch (IOException e) {
            System.err.println("!! File read error: " + e.getMessage());
        }
    }

    public void registerTeam(String teamName) {
        Team team = new Team(teamName);


    }

    public void addLeague() {

    }
}
