public class Player {
    //Information about player himself
    private String name;
    private int age;
    private String country;
    private int overall;

    //Information about football skill

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

    public Player(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() { return this.name; }
    public int getAge() { return this.age; }
    public String getCountry() { return this.country; }

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

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }


}