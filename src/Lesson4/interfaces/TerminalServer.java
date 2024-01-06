package Lesson4.interfaces;

import Lesson4.exceptions.IncorrectInputPinException;
import Lesson4.exceptions.IncorrectValueException;
import Lesson4.exceptions.NotEnoughBalanceException;

public interface TerminalServer {
    double accountBalance = 0;

    double checkAccountBalance() throws IncorrectInputPinException;
    void deposit(double amount) throws IncorrectValueException;
    void withdraw(double amount) throws NotEnoughBalanceException;

}
