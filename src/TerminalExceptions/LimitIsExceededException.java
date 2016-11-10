package TerminalExceptions;

/**
 * Created by balkh on 10.11.2016.
 */
public class LimitIsExceededException extends RuntimeException {

    public LimitIsExceededException(int limit) {
        super("The limit has been exceeded. Please request less than " + limit);
    }
}
