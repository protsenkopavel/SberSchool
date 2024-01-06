package Lesson4.impl;

import Lesson4.exceptions.AccountLockedException;
import Lesson4.exceptions.IncorrectInputPinException;
import Lesson4.interfaces.PinValidator;

public class PinValidatorImpl implements PinValidator {
    private StringBuilder enteredPin = new StringBuilder();
    private int incorrectInputs = 0;
    private final String correctPin = "0000";

    @Override
    public boolean validatePin(String inputPin) throws IncorrectInputPinException, AccountLockedException, InterruptedException {
        while (true) {
            for (char c : inputPin.toCharArray()) {
                if (Character.isDigit(c)) {
                    enteredPin.append(c);
                } else {
                    System.out.println("Предупреждение: Введен нецифровой символ");
                }
            }

            if (enteredPin.length() != correctPin.length() && !correctPin.equals(enteredPin)) {
                handleIncorrectInputs();
                throw new IncorrectInputPinException("Неправильный PIN-код");
            }
            resetIncorrectAttempts();
            return true;
        }
    }

    @Override
    public void handleIncorrectInputs() throws AccountLockedException, InterruptedException {
        incorrectInputs++;
        if (incorrectInputs == 3) {
            Thread.sleep(10000);
            throw new AccountLockedException("Вы ввели неправильный пароль 3 раза." +
                    " Ваш аккаунт заблокирован. Повторите попытку через 10 секунд");
        }
    }

    public void resetIncorrectAttempts() {
        incorrectInputs = 0;
    }


}
