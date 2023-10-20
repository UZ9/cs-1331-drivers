public class Student {
    private String name;
    private int happiness;
    
    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void giveCandy(int candy) {
        happiness += candy;
    }

    public int getHappiness() {
        return happiness;
    }
}
