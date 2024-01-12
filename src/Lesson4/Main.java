package Lesson4;

import Lesson4.exceptions.AccountLockedException;
import Lesson4.exceptions.IncorrectInputPinException;
import Lesson4.exceptions.IncorrectValueException;
import Lesson4.exceptions.InsufficientFundsException;

public class Main {
    public static void main(String[] args) throws InterruptedException, AccountLockedException, IncorrectInputPinException, IncorrectValueException, InsufficientFundsException {
        task1();
    }

    public static void task1() throws InterruptedException, AccountLockedException, IncorrectInputPinException, IncorrectValueException, InsufficientFundsException {
        BankTerminal bankTerminal = BankTerminalFactory.createBankTerminal();
        bankTerminal.startTerminal();
    }

    public static void task2() {
        WebContentReader webContentReader = new WebContentReader();
        webContentReader.start();
    }
}
