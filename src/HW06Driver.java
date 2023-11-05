import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW06Driver {
    public static void main(String[] args) {

        System.out.println("██████╗ ██████╗ ██╗██╗   ██╗███████╗██████╗ \r\n" + //
                "██╔══██╗██╔══██╗██║██║   ██║██╔════╝██╔══██╗\r\n" + //
                "██║  ██║██████╔╝██║██║   ██║█████╗  ██████╔╝\r\n" + //
                "██║  ██║██╔══██╗██║╚██╗ ██╔╝██╔══╝  ██╔══██╗\r\n" + //
                "██████╔╝██║  ██║██║ ╚████╔╝ ███████╗██║  ██║\r\n" + //
                "╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝\r\n" + //
                "");

        TerminalOption helpOption = new TerminalOption("-h", "List all commands", "java <COMPILED_DRIVER_FILE> -h");
        TerminalOption runClassesOption = new TerminalOption("-c", "Run only specific test classes", "java <COMPILED_DRIVER_FILE> -c SomeClassWithTests AnotherClassWithTests");

        TerminalOption[] options = { helpOption, runClassesOption };

        TerminalOption currentOption = null;

        argloop: for (int i = 0; i < args.length; i++) {
            for (TerminalOption o : options) {
                if (o.getFlag().equals(args[i])) {
                    currentOption = o;
                    currentOption.setReceived(true);
                    continue argloop;
                }
            }

            if (currentOption != null) {
                currentOption.addInput(args[i]);
            }
        }

        // Reserved for later
        // for (TerminalOption o : options) {
        // o.process();
        // }

        List<String> filter = runClassesOption.getInput();

        if (helpOption.received()) {
            System.out.println("Commands:");
            for (TerminalOption o : options) {
                System.out.println(ColorUtils.formatForegroundColorString(AsciiColorCode.BRIGHT_YELLOW_FOREGROUND, o.getFlag()) + " " + o.getName());
                System.out.println("\tUsage: " + o.getUsage());
            }
        } else {
            

            // Add classes to test here
            TestManager.registerDataClasses(TxtTestData.class);
            TestManager.setTestFilter(filter);
            TestManager.runTestsOn(SportsGameTests.class, BasketballGameTests.class, FootballGameTests.class,
                    InvalidTicketExceptionTests.class, EqualsTests.class);

        }

    }
}
