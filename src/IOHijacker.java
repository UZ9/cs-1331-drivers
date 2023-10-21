import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * A helper class used for redirecting System.out to check against
 */
class IOHijacker {
    private static IOHijacker INSTANCE;

    private List<String> log = new ArrayList<>();
    private PrintStream originalStream;
    private PrintStream redirectedStream;
    private boolean recording = false;

    private IOHijacker() {
        this.originalStream = System.out;
    }

    /**
     * Starts recording all System.out messages to the console and stores them in
     * IOHijacker.log.
     * 
     * Until stopRecording is called, no System.out messages will appear.
     */
    public void startRecording() {
        log.clear();

        if (redirectedStream == null)
            redirectedStream = getRedirectedStream();

        System.setOut(redirectedStream);

        recording = true;
    }

    /**
     * Stops the current recording, resetting System.out to its default behavior.
     * 
     * @return A list of all messages sent during the recording
     */
    public List<String> stopRecording() {
        recording = false;

        System.setOut(originalStream);

        return log;
    }

    /**
     * Retrieves the current log of messages in a recording
     * 
     * @return The current log of messages
     */
    public List<String> getCurrentLog() {
        return log;
    }

    /**
     * Retrieves a custom PrintStream that redirects print to instead logMessage
     * 
     * @return The custom PrintStream
     */
    private PrintStream getRedirectedStream() {
        return new PrintStream(System.out, true) {
            @Override
            public void print(String s) {
                IOHijacker.logMessage(s);
            }
        };
    }

    /**
     * Returns the Singleton's instance, creating one if it doesn't exist.
     * 
     * @return The IOHijacker instance
     */
    public static IOHijacker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IOHijacker();
        }

        return INSTANCE;
    }

    /**
     * Logs a string message to the log ONLY if recording.
     * 
     * @param message The message to be recorded
     */
    private static void logMessage(String message) {
        IOHijacker instance = getInstance();

        if (!instance.recording)
            return;

        instance.log.add(message);
    }
}
