import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class IOHijacker {
    private static IOHijacker INSTANCE;

    private List<String> log = new ArrayList<>(); 
    private PrintStream originalStream;
    private PrintStream redirectedStream;
    private boolean recording = false;

    private IOHijacker() {
        this.originalStream = System.out;
    }

    public void startRecording() {
        log.clear();

        if (redirectedStream == null) redirectedStream = getRedirectedStream();

        System.setOut(redirectedStream);

        recording = true;
    }

    public List<String> stopRecording() {
        recording = false;

        System.setOut(originalStream);

        return log;
    }

    public List<String> getCurrentLog() {
        return log;
    }

    private PrintStream getRedirectedStream() {
        return new PrintStream(System.out, true) {
            @Override
            public void print(String s) {
                IOHijacker.logMessage(s);
            }
        };
    }

    public static IOHijacker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IOHijacker();
        }

        return INSTANCE;
    }

    private static void logMessage(String message) {
        IOHijacker instance = getInstance();
        
        if (!instance.recording) return;

        instance.log.add(message);
    }


}
