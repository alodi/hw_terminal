
public interface Terminal {
    int checkAccountState();

    void putMoney(int money);

    void getMoney(int money);

    boolean validatePin(String pin);
}
