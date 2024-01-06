package Lesson4.impl;

import Lesson4.exceptions.AccountLockedException;
import Lesson4.exceptions.IncorrectValueException;
import Lesson4.exceptions.IncorrectInputPinException;
import Lesson4.exceptions.NotEnoughBalanceException;
import Lesson4.interfaces.Terminal;

public class TerminalImpl implements Terminal {
    private final TerminalServerImpl server;
    private final PinValidatorImpl validator;
    private final ConsoleOutput output;

    public TerminalImpl(TerminalServerImpl terminalServer, PinValidatorImpl validator, ConsoleOutput output) {
        this.server = terminalServer;
        this.validator = validator;
        this.output = output;
    }

    @Override
    public void checkAccountStatus(String pin) throws IncorrectInputPinException, AccountLockedException, InterruptedException {
        if (!validator.validatePin(pin)) {
            throw new IncorrectInputPinException("Введен некорректный PIN-код.");
        }

        double balance = server.checkAccountBalance();
        output.displayMessage("Баланс на счете: " + balance);
    }

    @Override
    public void depositMoney(double amount) throws IncorrectValueException {
        if (amount <= 0) {
            throw new IncorrectValueException("Невозможно пополнить баланс отрицательным значением");
        }

        if (amount % 100 != 0) {
            throw new IncorrectValueException("Пополнение возможно только сторублевыми купюрами");
        }

        server.deposit(amount);
        output.displayMessage("Счёт пополнен на: " + amount +
                ".\nТекущий баланс: " + server.checkAccountBalance());
    }

    @Override
    public void withdrawMoney(double amount) throws NotEnoughBalanceException, IncorrectValueException {
        if (amount > server.checkAccountBalance()) {
            throw new IncorrectValueException("На вашем счёте недостаточно средств. Проверьте баланс и снимите доступные средства.");
        }
        if (amount <= 0) {
            throw new IncorrectValueException("Невозможно снять со счёта отрицательное значение.");
        }

        if (amount % 100 != 0) {
            throw new NotEnoughBalanceException("Банкомат выдает только сторублевые купюры");
        }

        server.withdraw(amount);
        output.displayMessage("Вы сняли со своего счёта: " + amount +
                ".\nТекущий баланс: " + server.checkAccountBalance());
    }
}
