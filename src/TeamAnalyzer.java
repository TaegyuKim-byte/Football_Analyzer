import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class TeamAnalyzer {
    //footballManager가 가지고 있는 플레이어 데이터 저장
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<League> leagues = new ArrayList<>();



    //footballManager가 가지고 있는 플레이어 데이터 저장 (원본 참조 or 복사본 참조)
    //추후에 커스텀 선수 or 커스텀 팀을 만들어 분석할 때를 위해 원본 참조로 결정
    public TeamAnalyzer(ArrayList<Player> players, ArrayList<Team> teams, ArrayList<League> leagues) {
        this.players = players;
        this.teams = teams;
        this.leagues = leagues;
    }

    //메뉴 표시
    public void showMenu() {
        System.out.println("----- Team Analysis Options -----");
        System.out.println("(1) Best 11 Auto Formation");
        System.out.println("(2) Team Average Stats");
        System.out.println("(3) Formation Suitability");
        System.out.println("(0) Back to Analysis Menu");
    }

    //### 1번 기능
    //팀 최적 11인 추천
    public void best11AutoFormation(Team team, Formation formation) {
        System.out.println("=== " + team.getName() + " - " + formation.getName() + " Best 11 ===");
        
        List<Player> best11 = new ArrayList<>();
        Set<Player> usedPlayers = new HashSet<>(); // Set으로 중복 체크
        
        // 각 포지션별로 가장 적합한 선수 선택
        for (Position position : formation.getPositions()) {
            Player bestPlayer = findBestPlayerForPosition(team.getPlayers(), position, usedPlayers);
            if (bestPlayer != null) {
                best11.add(bestPlayer);
                usedPlayers.add(bestPlayer);
                System.out.printf("%s: %s (%.2f)\n", position, bestPlayer.getName(), 
                    bestPlayer.getSinglePositionFit(position));
            } else {
                System.out.printf("%s: No suitable player found\n", position);
            }
        }
        
        // Best 11 요약
        System.out.println("\n=== Best 11 Summary ===");
        System.out.println("Formation: " + formation.getName());
        System.out.println("Team: " + team.getName());
        System.out.println("Total Players: " + best11.size() + "/11");
        
        if (best11.size() < 11) {
            System.out.println("[!] Warning: Not enough players for complete formation");
        }
    }
    
    // 특정 포지션에 가장 적합한 선수 찾기
    private Player findBestPlayerForPosition(List<Player> availablePlayers, Position position, Set<Player> usedPlayers) {
        if (availablePlayers.isEmpty()) return null;
        
        // 이미 사용된 선수는 제외하고 해당 포지션에 가장 적합한 선수 찾기
        return availablePlayers.stream()
            .filter(p -> !usedPlayers.contains(p))
            .max((p1, p2) -> Double.compare(
                p1.getSinglePositionFit(position), 
                p2.getSinglePositionFit(position)
            ))
            .orElse(null);
    }

    //### 2번 기능
    //팀 평균 통계 출력
    public void teamAverageStats(Team team) {
       System.out.println("=== " + team.getName() + " - Team Rating ===");

       //1. 공격력 계산
       double attackScore = calculateAttackScore(team);

       //2. 중원장악력 계산
       double midfieldScore = calculateMidfieldScore(team);

       //3. 수비력 계산
       double defenseScore = calculateDefenseScore(team);

       //4. 전술적 유연성 계산
       double tacticalFlexibilityScore = calculateTacticalFlexibilityScore(team);

       //별 5개의 시스템으로 출력
       System.out.printf("공격력: %.1f/5.0★\n", attackScore / 22.5);
       System.out.printf("중원장악력: %.1f/5.0★\n", midfieldScore / 22.5);
       System.out.printf("수비력: %.1f/5.0★\n", defenseScore / 22.5);
       System.out.printf("전술적 유연성: %.1f/5.0★\n", Math.min(tacticalFlexibilityScore / 1.0, 5.0));

    }

    private double calculateAttackScore(Team team) {
        double attackScore = 0;
        int numOfAttackPlayers = 0;

        //공격 포지션의 선수들의 그 포지션에 대한 적합도 점수 평균 계산
        for (Player player : team.getPlayers()) {
            if (player.getPreferredPosition().equals(Position.ST) || player.getPreferredPosition().equals(Position.LW) || player.getPreferredPosition().equals(Position.RW) || player.getPreferredPosition().equals(Position.CAM)) {
                attackScore += player.getSinglePositionFit(player.getPreferredPosition());
                numOfAttackPlayers++;
            }
        }

        if (numOfAttackPlayers == 0) {
            return 0;
        }
        return attackScore / numOfAttackPlayers;
    }

    private double calculateMidfieldScore(Team team) {
        double midfieldScore = 0;
        int numOfMidfieldPlayers = 0;

        for (Player player : team.getPlayers()) {
            if (player.getPreferredPosition().equals(Position.CM) || player.getPreferredPosition().equals(Position.CDM) || player.getPreferredPosition().equals(Position.CAM) || player.getPreferredPosition().equals(Position.LM) || player.getPreferredPosition().equals(Position.RM)) {
                midfieldScore += player.getSinglePositionFit(player.getPreferredPosition());
                numOfMidfieldPlayers++;
            }
        }

        if (numOfMidfieldPlayers == 0) {
            return 0;
        }
        return midfieldScore / numOfMidfieldPlayers;
    }

    private double calculateDefenseScore(Team team) {
        double defenseScore = 0;
        int numOfDefensePlayers = 0;

        for (Player player : team.getPlayers()) {
            if (player.getPreferredPosition().equals(Position.CB) || player.getPreferredPosition().equals(Position.LB) || player.getPreferredPosition().equals(Position.RB) || player.getPreferredPosition().equals(Position.GK) || player.getPreferredPosition().equals(Position.LWB) || player.getPreferredPosition().equals(Position.RWB)) {
                defenseScore += player.getSinglePositionFit(player.getPreferredPosition());
                numOfDefensePlayers++;
            }
        }

        if (numOfDefensePlayers == 0) {
            return 0;
        }
        return defenseScore / numOfDefensePlayers;
    }

    private double calculateTacticalFlexibilityScore(Team team) {
        List<Player> players = team.getPlayers();
        if (players.isEmpty()) {
            return 0.0;
        }
    
        // 각 선수가 뛸 수 있는 포지션의 개수를 계산
        double totalPlayablePositions = players.stream()
            .mapToDouble(p -> {
                int playablePositions = 0;
                for (Position pos : Position.values()) {
                    if (p.evaluatePositionFit(pos) >= 77.5) { // 77.5점 이상이면 해당 포지션에서 뛸 수 있다고 판단
                        playablePositions++;
                    }
                }
                return playablePositions;
            })
            .sum();
    
        // 팀 전체 평균을 반환 (0.0 ~ 14.0 범위)
        return totalPlayablePositions / players.size();
    }
}
