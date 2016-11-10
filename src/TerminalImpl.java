import TerminalExceptions.MultipleException;
import TerminalExceptions.LimitIsExceededException;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;
    private final int moneyLimit;

    public TerminalImpl(TerminalServer server, PinValidator pinValidator, int moneyLimit) {
        this.server = server;
        this.pinValidator = pinValidator;
        this.moneyLimit = moneyLimit;
    }


    @Override
    public int checkAccountState() {
        return server.getAccountState();
    }

    @Override
    public void putMoney(int money) {
        if (money % 100 != 0) throw new MultipleException();
        if (money == 0) throw new IllegalArgumentException("Amount of money should be more than 0.");
        server.putMoney(money);
    }

    @Override
    public void getMoney(int money) {
        if (money % 100 != 0) throw new MultipleException();
        if (money == 0) throw new IllegalArgumentException("Amount of money should be more than 0.");
        if (money > moneyLimit) throw new LimitIsExceededException(moneyLimit);
        server.getMoney(money);
    }

    @Override
    public boolean validatePin(String pin) {
        return pinValidator.validate(pin);
    }
}
