public class Player {

    //Information about player himself
    private String name;
    private int age;
    private String country;

    //information about soccer
    private String team; //Now, we just do simple task. few weeks later, it can be a class...
    private int goal;
    private int assist;
    private String position;

    public Player(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public Player(String team, String position, int goal, int assist) {
        this.team = team;
        this.position = position;
        this.goal = goal;
        this.assist = assist;
    }

    public String getName() { return name; }
    public String getCountry() { return country; }
    public String getPosition() { return position; }

    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }

    public int getGoal() { return goal; }
    public void setGoal(int goal) { this.goal = goal; }

    public int getAssist() { return assist; }
    public void setAssist(int assist) { this.assist = assist; }

    public int getAttackPoint() { return goal + assist; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    
}
