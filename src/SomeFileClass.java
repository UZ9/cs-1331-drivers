import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SomeFileClass {
    public static void scanData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("test.txt"));

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
