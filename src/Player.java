public class Player {

    //Information about player himself
    private String name;
    private int age;
    private String country;
    private int overall;

    public Player(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() { return name; }
    public String getCountry() { return country; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return (this.name + ", " + this.age + ", " + this.country);
    }
}
