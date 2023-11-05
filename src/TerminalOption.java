import java.util.ArrayList;
import java.util.List;

class TerminalOption {
    private String flag;
    private String name;
    private String usage;

    private boolean received = false;

    private List<String> input;

    public TerminalOption(String flag, String name, String usage) {
        this.flag = flag;
        this.name = name;
        this.usage = usage;

        this.input = new ArrayList<>();
    }

    public String getFlag() {
        return flag;
    }

    public void addInput(String string) {
        this.input.add(string);
    }
    
    public List<String> getInput() {
        return input;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    public boolean received() {
        return this.received;
    }

    public String getName() {
        return this.name;
    }

    public String getUsage() {
        return this.usage;
    }

    public void process() {

    }
}
