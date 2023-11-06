import java.io.FileWriter;
import java.io.IOException;

class FileTester {
    @TestCase(name = "Does some thing")
    public void testFile() throws IOException, TestFailedException {
        FileWriter writer = new FileWriter("data.txt");

        writer.write("SomeValue1\n");
        writer.write("SomeValue2\n");
        writer.write("SomeValue3\n");
        writer.write("SomeValue4");

        writer.close();

        String output = StringUtils.fileToString("data.txt");

        TestFunction.assertEqual(output, TxtTestData.DATA);
    }
}
