import TerminalExceptions.AccountIsLockedException;
import TerminalExceptions.IncorrectPinException;

public class PinValidator {
    private final String correctPin;
    private int count = 0;
    private long lastFailCall;

    public PinValidator(String correctPin) {
        this.correctPin = correctPin;
    }

    public boolean validate(String pin) {

        if (!pin.equals(correctPin)) {
            count++;
            if (count < 3) throw new IncorrectPinException();
            if (count == 3) {
                lastFailCall = System.currentTimeMillis();
                throw new AccountIsLockedException(5000);
            }
            if (count > 3) {
                long millis = System.currentTimeMillis() - lastFailCall;
                if (millis < 5000) throw new AccountIsLockedException(5000 - millis);
                else {
                    count = 1;
                    throw new IncorrectPinException();
                }
            }
        } else count = 0;
        return true;
    }
}
