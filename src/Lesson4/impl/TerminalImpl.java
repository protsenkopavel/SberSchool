package Lesson4.impl;

import Lesson4.exceptions.IncorrectValueException;
import Lesson4.exceptions.InsufficientFundsException;
import Lesson4.interfaces.Terminal;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final ConsoleOutput output;

    public TerminalImpl(TerminalServer server, ConsoleOutput output) {
        this.server = server;
        this.output = output;
    }

    @Override
    public void checkAccountBalance() {
        output.displayMessage("Баланс на счете: " + server.checkAccountBalance() + " рублей.");
    }

    @Override
    public void depositMoney(double value) {
        try {
            checkInputValue(value);
            server.deposit(value);
            output.displayMessage("Счёт пополнен на: " + value + " рублей.");
        } catch (IncorrectValueException e) {
            output.displayMessage(e.getMessage());
        }
    }

    @Override
    public void withdrawMoney(double value) {
        try {
            checkInputValue(value);
            server.withdraw(value);
            output.displayMessage("Со счёта снято: " + value + " рублей.");
        } catch (IncorrectValueException | InsufficientFundsException e) {
            output.displayMessage(e.getMessage());
        }
    }

    public void checkInputValue(double value) throws IncorrectValueException {
        if (value <= 0) {
            throw new IncorrectValueException("Значение не может быть отрицательным или равным нулю!");
        } else if (value % 100 != 0) {
            throw new IncorrectValueException("Банкомат принимает/выдает только сторублевые купюры!");
        }

    }
}
