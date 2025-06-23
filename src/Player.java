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


}
