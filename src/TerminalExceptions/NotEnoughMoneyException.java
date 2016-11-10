package TerminalExceptions;

/**
 * Created by balkh on 10.11.2016.
 */
public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(){
        super("Not enough money on the account.");
    }
}
