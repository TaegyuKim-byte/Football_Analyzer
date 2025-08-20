import java.util.Scanner;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.LinkedHashMap;

public class PlayerAnalyzer {
    //footballManager가 가지고 있는 플레이어 데이터 저장
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<League> leagues = new ArrayList<>();

    private Scanner keyboard = new Scanner(System.in);
    private String[] abilities = {
        "1. Shooting", "2. Passing", "3. Dribbling", "4. Crossing", "5. Tackling",
        "6. Heading", "7. Ball Control", "8. Vision", "9. Composure", "10. Decision Making",
        "11. Work Rate", "12. Leadership", "13. Positioning", "14. Off the Ball", "15. Pace",
        "16. Stamina", "17. Strength", "18. Jumping", "19. Agility", "20. Saving", "21. Buildup Play"
    };

    //색상 정의
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";
    
    //footballManager가 가지고 있는 플레이어 데이터 저장 (원본 참조 or 복사본 참조)
    //추후에 커스텀 선수 or 커스텀 팀을 만들어 분석할 때를 위해 원본 참조로 결정
    public PlayerAnalyzer(ArrayList<Player> players, ArrayList<Team> teams, ArrayList<League> leagues) {
        this.players = players;
        this.teams = teams;
        this.leagues = leagues;
    }

    //메뉴 표시
    public void showMenu() {
        System.out.println("----- Player Analysis Options -----");
        System.out.println("(1) Player Comparison");
        System.out.println("(2) Ranking Top N");
        System.out.println("(3) Player's Strength and Weakness");
        System.out.println("(0) Back to Analysis Menu");
    }

    //### 1번 기능
    //플레이어 비교 메뉴 1. 단순 능력치 나열 2. 스파이더 차트 비교
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
                compareAbility("Leadership", player1.getLeadership(), player2.getLeadership());
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
    
    //능력치 비교 및 색상 적용 (높은 값은 녹색, 낮은 값은 빨강)
    private void compareAbility(String abilityName, int value1, int value2) {
        String color1 = value1 >= value2 ? GREEN : RED;
        String color2 = value2 >= value1 ? GREEN : RED;
        
        System.out.printf("%20s%s%20s%s%s%20s%s\n", abilityName, color1, String.valueOf(value1), RESET, color2, String.valueOf(value2), RESET);
    }

    //포지션 기반 스파이더 차트 비교 -> playerComparison 메서드 내에서 호출.
    //PositionAbilities 클래스의 메서드들을 사용. (public class)
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

    //### 2번 기능
    //상위 N명 랭킹 표시
    public void rankingTopN(int rankingChoice) {
        switch (rankingChoice) {
            case 1: {
                //Position-based Ranking
                PositionAbilities.showPositionMenu();
                System.out.print("\nEnter the position's number you want to rank: ");
                int position = keyboard.nextInt();
                keyboard.nextLine();
                //개행문자 제거

                Position selectedPosition = PositionAbilities.getPositionByChoice(position);

                if (selectedPosition == null) {
                    System.out.println("Invalid position choice!");
                    return;
                }

                System.out.print("Enter the number of players you want to rank: ");
                int numberOfPlayers = keyboard.nextInt();
                while (numberOfPlayers < 0) {
                    System.out.print("Enter the number of players you want to rank: ");
                    numberOfPlayers = keyboard.nextInt();
                    keyboard.nextLine();
                    //개행문자 제거
                }

                //선수 리스트 복사 (원본 침해 방지지)
                List<Player> sortedPlayers = new ArrayList<>(players);

                //선수 정렬
                Collections.sort(sortedPlayers, (p1, p2) -> {
                    double rating1 = p1.evaluatePositionFit(selectedPosition);
                    double rating2 = p2.evaluatePositionFit(selectedPosition);
                    return Double.compare(rating2, rating1);
                });

                //출력
                System.out.println("\n----- Position-based Ranking -----");
                System.out.println("Selected position: " + selectedPosition);
                System.out.println("Number of players to rank: " + numberOfPlayers);

                for (int i = 0; i < Math.min(numberOfPlayers, sortedPlayers.size()); i++) {
                    Player player = sortedPlayers.get(i);
                    System.out.printf("%d. %s - %.2f\n", i + 1, player.getName(), player.evaluatePositionFit(selectedPosition));
                }

                break;
            }
            case 2: {
                //Stats-based Ranking
                //능력치 선택 메뉴
                System.out.println("----- Stats-based Ranking -----");
                System.out.println("Choose the ability you want to rank! ");
                for (String ability : abilities) {
                    System.out.println(ability);
                }
                System.out.print("Enter the ability number you want to rank: ");
                int abilityNumber = keyboard.nextInt();
                keyboard.nextLine();
                //개행문자 제거

                //능력치 번호 범위 체크
                if (abilityNumber < 1 || abilityNumber > 21) {
                    System.out.println("[!] Invalid ability choice!");
                    return;
                }

                //랭킹할 선수 수 입력
                System.out.print("Enter the number of players you want to rank: ");
                int numberOfPlayers = keyboard.nextInt();
                while (numberOfPlayers < 0) {
                    System.out.print("Enter the number of players you want to rank: ");
                    numberOfPlayers = keyboard.nextInt();
                    keyboard.nextLine();
                    //개행문자 제거
                }

                //선수 리스트 복사 (원본 침해 방지지)
                List<Player> sortedPlayers = new ArrayList<>(players);

                //선수 정렬 (능력치 번호에 따라 정렬)
                Collections.sort(sortedPlayers, (p1, p2) -> {
                    int value1 = getAbilitybyNumber(p1, abilityNumber);
                    int value2 = getAbilitybyNumber(p2, abilityNumber);
                    return Integer.compare(value2, value1);
                });
                
                //출력
                System.out.println("\n----- Stats-based Ranking -----");
                System.out.println("Selected ability: " + abilities[abilityNumber - 1]);
                System.out.println("Number of players to rank: " + numberOfPlayers);

                for (int i = 0; i < Math.min(numberOfPlayers, sortedPlayers.size()); i++) {
                    Player player = sortedPlayers.get(i);
                    System.out.printf("%d. %s - %d\n", i + 1, player.getName(), getAbilitybyNumber(player, abilityNumber));
                }

                break;
            }    
            case 0: {
                //Back to Analysis Menu
                break;
            }
            default: {
                System.out.println("[!] Invalid input. Please choose between 0 and 2.");
                break;
            }
        }

        return;
    }

    //능력치 번호에 따라 능력치 값 반환
    public int getAbilitybyNumber(Player player, int abilityNumber) {
        switch (abilityNumber) {
            case 1: return player.getShooting();
            case 2: return player.getPassing();
            case 3: return player.getDribbling();
            case 4: return player.getCrossing();
            case 5: return player.getTackling();
            case 6: return player.getHeading();
            case 7: return player.getBallControl();
            case 8: return player.getVision();
            case 9: return player.getComposure();
            case 10: return player.getDecisionMaking();
            case 11: return player.getWorkRate();
            case 12: return player.getLeadership();
            case 13: return player.getPositioning();
            case 14: return player.getOffTheBall();
            case 15: return player.getPace();
            case 16: return player.getStamina();
            case 17: return player.getStrength();
            case 18: return player.getJumping();
            case 19: return player.getAgility();
            case 20: return player.getSaving();
            case 21: return player.getBuildupPlay();
            default: return 0;
        }
    }
    
    //### 3번 기능
    //플레이어의 강점 약점 분석
    public void strengthAndWeaknessAnalysis(Player player) {
        System.out.println("----- Player's Strength and Weakness -----");
        
        //Map 사용..?
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Shooting", player.getShooting());
        map.put("Passing", player.getPassing());
        map.put("Dribbling", player.getDribbling());
        map.put("Crossing", player.getCrossing());
        map.put("Tackling", player.getTackling());
        map.put("Heading", player.getHeading());
        map.put("Ball Control", player.getBallControl());
        map.put("Vision", player.getVision());
        map.put("Composure", player.getComposure());
        map.put("Decision Making", player.getDecisionMaking());
        map.put("Work Rate", player.getWorkRate());
        map.put("Leadership", player.getLeadership());
        map.put("Positioning", player.getPositioning());
        map.put("Off the Ball", player.getOffTheBall());
        map.put("Pace", player.getPace());
        map.put("Stamina", player.getStamina());
        map.put("Strength", player.getStrength());
        map.put("Jumping", player.getJumping());
        map.put("Agility", player.getAgility());
        
        //GK 포지션인 경우 추가
        if (player.getPreferredPosition() == Position.GK) {
            map.put("Saving", player.getSaving());
            map.put("Buildup Play", player.getBuildupPlay());
        }

        //Map 정렬
        System.out.printf("----- Player" + player.getName() + "'s Strength -----\n");
        System.out.println("------------------------------------------");
        map.entrySet().stream()
            .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
            .limit(4)
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //Map 정렬
        System.out.printf("----- Player" + player.getName() + "'s Weakness -----\n");
        System.out.println("------------------------------------------");
        map.entrySet().stream()
            .sorted((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()))
            .limit(4)
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
    
}
