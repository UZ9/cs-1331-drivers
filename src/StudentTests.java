import java.util.List;

class StudentTests {
    @Tip(tip = "Make sure you don't have any field shadowing in your constructor!")
    @TestCase(name = "Student Constructor should set name to input when initialized")
    public void studentConstructor_shouldSetNameToInput_whenInitialized() throws TestFailedException {
        IOHijacker hijacker = IOHijacker.getInstance();

        hijacker.startRecording();

        Student student = new Student("Bdob");

        List<String> output = hijacker.stopRecording();

        TestFunction.assertEqual(output.size() ,1);
        TestFunction.assertEqual(output.get(0), "Hello there.\nI'm a student.");

        TestFunction.assertEqual(student.getName(), "Bob");
    }

    @TestCase(name = "Giving a student 1 candy increases happiness by 1")
    public void giving1Candy_shouldIncreaseHappiness_by1() throws TestFailedException {
        Student student = new Student("Bob");

        student.giveCandy(1);

        TestFunction.assertEqual(student.getHappiness(), 1);
    }
}
