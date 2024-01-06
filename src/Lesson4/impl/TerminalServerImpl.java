package Lesson4.impl;

import Lesson4.exceptions.IncorrectValueException;
import Lesson4.exceptions.NotEnoughBalanceException;
import Lesson4.interfaces.TerminalServer;

public class TerminalServerImpl implements TerminalServer {
    private double accountBalance = 0;

    @Override
    public double checkAccountBalance() {
        return accountBalance;
    }

    @Override
    public void deposit(double amount) throws IncorrectValueException {

        if (amount <= 0) {
            throw new IncorrectValueException("Невозможно пополнить баланс отрицательным значением");
        } else {
            accountBalance += amount;
        }
    }

    @Override
    public void withdraw(double amount) throws NotEnoughBalanceException {
        if (amount > accountBalance) {
            throw new NotEnoughBalanceException("Банкомат выдает только сторублевые купюры.");
        } else {
            accountBalance -= amount;
        }
    }
}
