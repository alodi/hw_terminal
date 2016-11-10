import TerminalExceptions.NotEnoughMoneyException;

public class TerminalServer {
    private int accountState = 0;

    public int getAccountState() {
        return accountState;
    }

    public void putMoney(int money) {
        accountState += money;
    }

    public void getMoney(int money) {
        if (accountState >= money) accountState -= money;
        else throw new NotEnoughMoneyException();
    }
}
