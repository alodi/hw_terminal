package TerminalExceptions;

/**
 * Created by balkh on 09.11.2016.
 */
public class IncorrectPinException extends RuntimeException {

    public IncorrectPinException(){
        super("Incorrect pin.");
    }
}
