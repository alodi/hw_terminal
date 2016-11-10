package TerminalExceptions;

/**
 * Created by balkh on 10.11.2016.
 */
public class AccountIsLockedException extends RuntimeException {
    public AccountIsLockedException(long millis) {
        super("You have entered incorrect pin 3 times. Account is Locked for " + millis/1000 + " seconds.");
    }
}
