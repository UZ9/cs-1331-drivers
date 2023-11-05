import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileTester {
    @TestCase(name = "Does some thing")
    public void testFile() throws IOException, TestFailedException {
        FileWriter writer = new FileWriter("data.txt");

        writer.write("SomeValue1\n");
        writer.write("SomeValue2\n");
        writer.write("SomeValue3\n");
        writer.write("SomeValue4");

        writer.close();

        String output = fileToString("data.txt");

        TestFunction.assertEqual(output, TxtTestData.DATA);
    }

    private static String fileToString(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("data.txt"));

        String output = "";

        while (scanner.hasNextLine()) {
            output += scanner.nextLine() + "\n";
        }

        scanner.close();

        return output;
    }
}
