package Lesson4.impl;

import Lesson4.exceptions.InsufficientFundsException;

public class TerminalServer {
    private double accountBalance = 0;

    double checkAccountBalance() {
        return accountBalance;
    }

    void deposit(double value) {
        accountBalance += value;
    }

    void withdraw(double value) throws InsufficientFundsException {
        if (value > accountBalance) {
            throw new InsufficientFundsException("На балансе недостаточно средств");
        } else {
            accountBalance -= value;
        }
    }
}
