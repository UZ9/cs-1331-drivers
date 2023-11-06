import java.util.ArrayList;
import java.util.List;

/**
 * Represents a potential option the terminal can accept as an input
 */
class TerminalOption {
    /**
     * The flag, denoted by '-<some sort of character>' the terminal will look for
     */
    private String flag;

    /**
     * The name of the flag
     */
    private String name;

    /**
     * An example of using the command, used in the help menu for the program
     */
    private String usage;

    /**
     * An internal boolean representing whether the test case has been successfully
     * added or not
     */
    private boolean received = false;

    /**
     * A list of all of the inputs received from the terminal. This is populated from the main parsing logic. 
     */
    private List<String> input;

    /**
     * Constructs a new TerminalOption given the following parameters
     * @param flag The flag of the option
     * @param name The name of the option, used in the help menu 
     * @param usage An example case of using the option, used in the help menu
     */
    public TerminalOption(String flag, String name, String usage) {
        this.flag = flag;
        this.name = name;
        this.usage = usage;

        this.input = new ArrayList<>();
    }

    /**
     * Retrieves the flag used for the TerminalOption
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * Adds a new received input to the TerminalOption
     * @param string The string to add to the input
     */
    public void addInput(String string) {
        this.input.add(string);
    }

    /**
     * Retrieves the list of inputs 
     * @return the inputs received of the TerminalOption
     */
    public List<String> getInput() {
        return input;
    }

    /**
     * Sets whether the TerminalOption has successfully received the flag or not
     * @param received true if the flag has been received
     */
    public void setReceived(boolean received) {
        this.received = received;
    }

    /**
     * Retrieves whether the TemrinalOption has been retrieved or not
     * @return true if the flag has been received
     */
    public boolean received() {
        return this.received;
    }

    /**
     * Retrieves the name of the terminal option
     * @return The name of the terminal option
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the usage statement of the terminal option
     * @return An example usage statement of the terminal option
     */
    public String getUsage() {
        return this.usage;
    }

    public void process() {

    }
}
