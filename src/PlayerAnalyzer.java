import java.util.Scanner;
import javax.swing.SwingUtilities;


public class PlayerAnalyzer {
    private Scanner keyboard = new Scanner(System.in);
    private String[] abilities = {
        "1. Shooting", "2. Passing", "3. Dribbling", "4. Crossing", "5. Tackling",
        "6. Heading", "7. Ball Control", "8. Vision", "9. Composure", "10. Decision Making",
        "11. Work Rate", "12. Leadership", "13. Positioning", "14. Off the Ball", "15. Pace",
        "16. Stamina", "17. Strength", "18. Jumping", "19. Agility", "20. Saving", "21. Buildup Play"
    };

    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";
    
    public void showMenu() {
        System.out.println("----- Player Analysis Options -----");
        System.out.println("(1) Player Comparison");
        System.out.println("(2) Ranking Top N");
        System.out.println("(3) Position-based Analysis");
        System.out.println("(0) Back to Analysis Menu");
    }

    public void playerComparison(Player player1, Player player2) {
        System.out.println("----- Player Comparison -----");
        System.out.println("(1) Simple Stats Comparison");
        System.out.println("(2) Spider Chart Comparison");
        int choice = keyboard.nextInt();
        keyboard.nextLine();

        switch (choice) {
            case 1: {
                System.out.println("----- Simple Stats Comparison -----");
                System.out.printf("%20s%20s%20s\n", "",player1.getName(), player2.getName());
                System.out.println("------------------------------------------");
                
                System.out.println("------------- Technical Skills -------------");
                compareAbility("Shooting", player1.getShooting(), player2.getShooting());
                compareAbility("Passing", player1.getPassing(), player2.getPassing());
                compareAbility("Dribbling", player1.getDribbling(), player2.getDribbling());
                compareAbility("Crossing", player1.getCrossing(), player2.getCrossing());
                compareAbility("Tackling", player1.getTackling(), player2.getTackling());
                compareAbility("Heading", player1.getHeading(), player2.getHeading());
                compareAbility("Ball Control", player1.getBallControl(), player2.getBallControl());

                System.out.println("--------------- Mental Skills ---------------");
                compareAbility("Vision", player1.getVision(), player2.getVision());
                compareAbility("Composure", player1.getComposure(), player2.getComposure());
                compareAbility("Decision Making", player1.getDecisionMaking(), player2.getDecisionMaking());
                compareAbility("Work Rate", player1.getWorkRate(), player2.getWorkRate());
                compareAbility("Work Rate", player1.getLeadership(), player2.getLeadership());
                compareAbility("Positioning", player1.getPositioning(), player2.getPositioning());   

                System.out.println("-------------- Physical Skills --------------");
                compareAbility("Pace", player1.getPace(), player2.getPace());
                compareAbility("Stamina", player1.getStamina(), player2.getStamina());
                compareAbility("Strength", player1.getStrength(), player2.getStrength());
                compareAbility("Jumping", player1.getJumping(), player2.getJumping());
                compareAbility("Agility", player1.getAgility(), player2.getAgility());

                System.out.println("--------------- GK Skills ---------------");
                compareAbility("Saving", player1.getSaving(), player2.getSaving());
                compareAbility("Buildup Play", player1.getBuildupPlay(), player2.getBuildupPlay());

                break;
            }
            case 2: {
                positionBasedSpiderChart(player1, player2);
                break;
            }
        }
    }
    
    private void compareAbility(String abilityName, int value1, int value2) {
        String color1 = value1 >= value2 ? GREEN : RED;
        String color2 = value2 >= value1 ? GREEN : RED;
        
        System.out.printf("%20s%s%20s%s%s%20s%s\n", abilityName, color1, String.valueOf(value1), RESET, color2, String.valueOf(value2), RESET);
    }

    public void rankingTopN() {
    
    }
    
    public void positionBasedAnalysis() {
    
    }
    
    private void positionBasedSpiderChart(Player player1, Player player2) {
        // 포지션 선택 메뉴 표시
        PositionAbilities.showPositionMenu();
        System.out.print("Choose position (1-14): ");
        
        int choice = keyboard.nextInt();
        Position selectedPosition = PositionAbilities.getPositionByChoice(choice);
        
        if (selectedPosition == null) {
            System.out.println("Invalid position choice!");
            return;
        }
        
        // 선택된 포지션의 능력치 가져오기
        String[] abilities = PositionAbilities.getAbilitiesForPosition(selectedPosition);
        
        System.out.println("\nSelected position: " + selectedPosition);
        System.out.println("Comparing abilities: " + String.join(", ", abilities));
        
        // SpiderChartFrame 생성
        SwingUtilities.invokeLater(() -> {
            SpiderChartFrame frame = new SpiderChartFrame(player1, player2, abilities, selectedPosition);
            frame.setVisible(true);
        });
    }
}
