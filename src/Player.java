import java.util.EnumMap;
import java.util.Objects;

public class Player {
    //Information about player himself
    private String name;
    private int age;
    private String country;

    //Information about football skill

    //Preferred Position
    private Position preferredPosition;

    //Foot
    private int leftFoot;
    private int rightFoot;

    //Technical Skills
    private int shooting;
    private int passing;
    private int dribbling;
    private int crossing;
    private int tackling;
    private int heading;
    private int ballControl;

    //Mental Skills
    private int vision;
    private int composure; //침착성
    private int decisionMaking;
    private int workRate; //활동량, 헌신성
    private int leadership;
    private int positioning;
    private int offTheBall;

    //Physical Skills
    private int pace; //스피드 (속도 + 가속도)
    private int stamina; //체력
    private int strength;
    private int jumping;
    private int agility; //민첩성 (턴, 회피 등)

    //GK 전용
    private int saving;
    private int buildupPlay;

    private EnumMap<Position, Double> positionFitEnumMap;

    public Player(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;

        positionFitEnumMap = new EnumMap<>(Position.class);
    }

    public String getName() { return this.name; }
    public int getAge() { return this.age; }
    public String getCountry() { return this.country; }

    public Position getPreferredPosition() { return preferredPosition; }

    public void setPreferredPosition(Position preferredPosition) { this.preferredPosition = preferredPosition; }

    public int getLeftFoot() { return leftFoot; }

    public void setLeftFoot(int leftFoot) { this.leftFoot = leftFoot; }

    public int getRightFoot() { return rightFoot; }

    public void setRightFoot(int rightFoot) { this.rightFoot = rightFoot; }

    public int getShooting() {
        return shooting;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public int getPassing() {
        return passing;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public int getDribbling() {
        return dribbling;
    }

    public void setDribbling(int dribbling) {
        this.dribbling = dribbling;
   }

    public int getCrossing() {
        return crossing;
    }

    public void setCrossing(int crossing) {
        this.crossing = crossing;
    }

    public int getTackling() {
        return tackling;
    }

    public void setTackling(int tackling) {
        this.tackling = tackling;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getBallControl() {
        return ballControl;
    }

    public void setBallControl(int ballControl) {
        this.ballControl = ballControl;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public int getComposure() {
        return composure;
    }

    public void setComposure(int composure) {
        this.composure = composure;
    }

    public int getDecisionMaking() {
        return decisionMaking;
    }

    public void setDecisionMaking(int decisionMaking) {
        this.decisionMaking = decisionMaking;
    }

    public int getWorkRate() {
        return workRate;
    }

    public void setWorkRate(int workRate) {
        this.workRate = workRate;
    }

    public int getLeadership() {
        return leadership;
    }

    public void setLeadership(int leadership) {
        this.leadership = leadership;
    }

    public int getPositioning() {
        return positioning;
    }

    public void setPositioning(int positioning) {
        this.positioning = positioning;
    }

    public int getOffTheBall() {
        return offTheBall;
    }

    public void setOffTheBall(int offTheBall) {
        this.offTheBall = offTheBall;
    }

    public int getPace() {
        return pace;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getJumping() {
        return jumping;
    }

    public void setJumping(int jumping) {
        this.jumping = jumping;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }

    public int getBuildupPlay() {
        return buildupPlay;
    }

    public void setBuildupPlay(int buildupPlay) {
        this.buildupPlay = buildupPlay;
    }


    public void showPlayer() {
        System.out.println("=== Player Info ===");
        System.out.println("Name: " + name + " (" + age + ", " + country + ")");
        System.out.println("Foot: L" + leftFoot + " / R" + rightFoot);
        System.out.println("--- Position Fit Scores ---");

        for (Position pos : Position.values()) {
            double fitScore = positionFitEnumMap.getOrDefault(pos, 0.0);
            System.out.printf(" %s: %.2f\n", pos, fitScore);
        }
    }

    public void calculateAllFit() {
        for (Position pos : Position.values()) {
            double fitscore = evaluatePositionFit(pos);
            if (pos == preferredPosition) {
                fitscore *= 1.05;
            }
            this.positionFitEnumMap.put(pos, fitscore);
        }
    }

    public double getFootMultiplier(Position pos, boolean isInverted) {
        int footScore;

        switch (pos) {
            case RW: {
                footScore = isInverted ? leftFoot : rightFoot;
                break;
            }
            case RB:
                footScore = rightFoot;
                break;
            case LW: {
                footScore = isInverted ? rightFoot : leftFoot;
                break;
            }
            case LB:
                footScore = leftFoot;
                break;
            default:
                return 1.0; // 중앙 포지션 등은 보정 없음
        }

        // FM 스타일 보정 로직
        if (footScore >= 85) return 1.0;
        else if (footScore >= 70) return 0.95 + (footScore - 70) * 0.003;
        else if (footScore >= 60) return 0.85 + (footScore - 60) * 0.01;
        else if (footScore >= 50) return 0.75 + (footScore - 50) * 0.01;
        else return 0.6 + (footScore * 0.003); // 0~49
    }

    public double evaluatePositionFit(Position pos) {
        double base;

        switch (pos) {
            case ST: {
                return shooting * 0.4 + offTheBall * 0.3 + positioning * 0.2 + pace * 0.1;
            }
            case RW: {
                base = dribbling * 0.3 + pace * 0.3 + crossing * 0.2 + offTheBall * 0.2;
                double notInverted = getFootMultiplier(Position.RW, false) * base; //정발

                base = dribbling * 0.25 + offTheBall * 0.25 + shooting * 0.25 + composure * 0.15 + agility * 0.1;
                double Inverted = getFootMultiplier(Position.RW, true) * base; //역발

                return Math.max(Inverted, notInverted);
            }
            case LW: {
                base = dribbling * 0.3 + pace * 0.3 + crossing * 0.2 + offTheBall * 0.2;
                double notInverted = getFootMultiplier(Position.LW, false) * base; //정발

                base = dribbling * 0.25 + offTheBall * 0.25 + shooting * 0.25 + composure * 0.15 + agility * 0.1;
                double Inverted = getFootMultiplier(Position.LW, true) * base; //역발

                return Math.max(Inverted, notInverted);
            }
            case CAM: {
                return vision * 0.35 + passing * 0.3 + ballControl * 0.2 + decisionMaking * 0.15;
            }
            case CM: {
                return passing * 0.35 + stamina * 0.25 + vision * 0.2 + workRate * 0.2;
            }
            case CDM: {
                return tackling * 0.4 + positioning * 0.3 + strength * 0.2 + passing * 0.1;
            }
            case RB: {
                base = tackling * 0.3 + pace * 0.3 + crossing * 0.2 + stamina * 0.2;
                return base * getFootMultiplier(Position.RB, false);
            }
            case LB: {
                base = tackling * 0.3 + pace * 0.3 + crossing * 0.2 + stamina * 0.2;
                return base * getFootMultiplier(Position.LB, false);
            }
            case CB: {
                return tackling * 0.4 + heading * 0.3 + strength * 0.2 + positioning * 0.1;
            }
            case GK: {
                return saving * 0.5 + positioning * 0.2 + buildupPlay * 0.2 + jumping * 0.1;
            }
            default:
                return 0.0;
        }
    }

    public String toString() {
        return (this.name + "(" + this.age + ", " + this.country + ")");
    }
}