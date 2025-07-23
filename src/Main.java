//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FootballManager footballManager = new FootballManager();

        Scanner keyboard = new Scanner(System.in);
        int enter;
        boolean goon = true;

        do {
            System.out.println("==========================================");
            System.out.println("Welcome to the Football Manager Program");
            System.out.println("==========================================");
            System.out.println("Choose your option:");
            System.out.println("------------------------------------------");
            System.out.println("(1) Load Data from text File");
            System.out.println("(2) Search & View");
            System.out.println("(3) Analysis");
            /*System.out.println("(4) Show all Players in this world");
            System.out.println("(5) Show all Players in the Team");
            System.out.println("(6) Show all Teams in this world");
            System.out.println("(7) Show all Teams in the League");
            System.out.println("(8) Show all Leagues in this world");*/
            System.out.println("(0) Exit Program");
            System.out.println("==========================================");


            enter = keyboard.nextInt();

            switch (enter) {
                case 1: {
                    System.out.println("Enter TEXT FILE'S NAME what you want to register");
                    System.out.println("(If you want, You can add another player to text file)");
                    System.out.println("(You must be careful info's order)");
                    String filename = keyboard.next();

                    footballManager.registerPlayerSet(filename);
                    footballManager.registerTeam();
                    footballManager.assignPlayerToTeam();

                    footballManager.showAllPlayers();
                    footballManager.showAllTeams();

                    break;
                }
                case 2: {
                    System.out.println("----- Search Options -----");
                    System.out.println("(1) Players");
                    System.out.println("(2) Teams");
                    System.out.println("(3) Leagues");
                    int subChoice = keyboard.nextInt();

                    switch (subChoice) {
                        case 1: {
                            System.out.println("----- Player Search Options -----");
                            System.out.println("(1) View All Players");
                            System.out.println("(2) View Players in a Team");
                            System.out.println("(3) View One Player by name");
                            int subChoice1 = keyboard.nextInt();
                            keyboard.nextLine();
                            //개행문자 제거

                            switch (subChoice1) {
                                case 1: {
                                    footballManager.showAllPlayers();
                                    break;
                                }
                                case 2: {
                                    System.out.println("Choose a team.");
                                    footballManager.showAllTeams();

                                    String teamName = keyboard.nextLine();

                                    Team team = footballManager.findTeamByName(teamName);

                                    team.showPlayers();

                                    break;
                                }
                                case 3: {
                                    footballManager.showAllPlayers();
                                    System.out.print("Enter the player's name: ");

                                    String playerName = keyboard.nextLine();

                                    Player p = footballManager.findPlayerByName(playerName);
                                    if (p == null) {
                                        System.out.println("[!] There is no player whose name is " + playerName);
                                    } else {
                                        p.showPlayer();
                                    }

                                    break;
                                }
                                default: {
                                    System.out.println("[!] Invalid input. Please enter a number between 1 and 3.");
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("----- Team Search Options -----");
                            System.out.println("(1) View All Teams");
                            System.out.println("(2) View Teams in a League");
                            System.out.println("(3) View One Team by name");
                            int subChoice2 = keyboard.nextInt();

                            switch (subChoice2) {
                                case 1: {
                                    break;
                                }
                                case 2: {
                                    break;
                                }
                                case 3: {
                                    break;
                                }
                                default: {
                                    System.out.println("[!] Invalid input. Please choose between 1 and 3.");
                                    break;
                                }
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("----- League Search Options -----");
                            System.out.println("(1) View All Leagues");
                            System.out.println("(2) View One League by name");
                            int subChoice3 = keyboard.nextInt();

                            switch (subChoice3) {
                                case 1: {
                                    break;
                                }
                                case 2: {
                                    break;
                                }
                                default: {
                                    System.out.println("[!] Invalid input. Please choose between 1 and 2.");
                                    break;
                                }
                            }
                            break;
                        }
                        default: {
                            System.out.println("[!] Invalid input. Please choose between 1 and 3.");
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    //Part of analyzer
                    break;
                }
                case 0:
                    System.out.println("Exit program..");
                    goon = false;
                    break;
                default:
                    System.out.println("[!] Invalid input. Please choose between 0 and 3.");
                    break;
            }
        } while (goon);

    }
}