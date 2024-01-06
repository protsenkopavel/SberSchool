package Lesson4.interfaces;

import Lesson4.exceptions.AccountLockedException;
import Lesson4.exceptions.IncorrectInputPinException;

public interface PinValidator {
    boolean validatePin(String pin) throws IncorrectInputPinException, AccountLockedException, InterruptedException;
    void handleIncorrectInputs() throws AccountLockedException, InterruptedException;
    void resetIncorrectAttempts();
}
