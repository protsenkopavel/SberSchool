package Lesson4.interfaces;

import Lesson4.exceptions.AccountLockedException;
import Lesson4.exceptions.IncorrectValueException;
import Lesson4.exceptions.IncorrectInputPinException;
import Lesson4.exceptions.NotEnoughBalanceException;

public interface Terminal {
    void checkAccountStatus(String pin) throws IncorrectInputPinException, AccountLockedException, InterruptedException;
    void depositMoney(double amount) throws IncorrectValueException;
    void withdrawMoney(double amount) throws NotEnoughBalanceException, IncorrectValueException;
}
