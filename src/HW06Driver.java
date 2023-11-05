public class HW06Driver {
    public static void main(String[] args) {        // Add classes to test here
        TestManager.registerDataClasses(TxtTestData.class);

        TestManager.runTestsOn(FileTester.class);
    }
}
