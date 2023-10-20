public class StudentTests {
    @Tip(tip = "Make sure you don't have any field shadowing in your constructor!")
    @TestCase(name = "Student Constructor should set name to input when initialized")
    public void studentConstructor_shouldSetNameToInput_whenInitialized() throws TestFailedException {
        Student student = new Student("Bob");

        TestFunction.shouldEqual(student.getName(), "Bob");
    }
}
