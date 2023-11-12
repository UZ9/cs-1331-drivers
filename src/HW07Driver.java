import java.util.List;

public class HW07Driver {
    public static void main(String[] args) {
        StringUtils.printHorizontalLine();

        System.out.println("\u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2557\u2588\u2588\u2557   \u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2557 \n\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2551\u2588\u2588\u2551   \u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\n\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2551\u2588\u2588\u2551   \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\n\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2551\u255A\u2588\u2588\u2557 \u2588\u2588\u2554\u255D\u2588\u2588\u2554\u2550\u2550\u255D  \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\n\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551 \u255A\u2588\u2588\u2588\u2588\u2554\u255D \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2551  \u2588\u2588\u2551\n\u255A\u2550\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u2550\u2550\u255D  \u255A\u2550\u2550\u2550\u2550\u2550\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D");

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

        List<String> filter = runClassesOption.getInput();

        if (helpOption.received()) {
            System.out.println("Commands:");
            for (TerminalOption o : options) {
                System.out.println(ColorUtils.formatForegroundColorString(AsciiColorCode.BRIGHT_YELLOW_FOREGROUND, o.getFlag()) + " " + o.getName());
                System.out.println("\tUsage: " + o.getUsage());
            }
        } else {

            TestManager.registerDataClasses(TxtTestData.class);
            TestManager.setTestFilter(filter);
            TestManager.runTestsOn(RestaurantTests.class);

        }

    }
}
