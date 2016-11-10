package TerminalExceptions;

/**
 * Created by balkh on 10.11.2016.
 */
public class MultipleException extends RuntimeException {
    public MultipleException(){
        super("Amount of money is not a multiple of 100.");
    }
}
