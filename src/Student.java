public class Student {
    private String name;
    private int happiness;
    
    public Student(String name) {
        this.name = name;

        System.out.println("Hello there.");
        System.out.println("I'm a student.");
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
