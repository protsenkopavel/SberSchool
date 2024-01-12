package Lesson4.impl;

import Lesson4.exceptions.AccountLockedException;

import java.util.Scanner;

public class PinValidator {
    private ConsoleOutput output = new ConsoleOutput();
    private int incorrectInputs = 0;
    private final String correctPin = "0000";
    private final int MAX_ATTEMPTS = 3;
    private final int LOCK_DURATION_SECONDS = 10;

    public boolean validatePin() {
        try {
            allowAccess();
        } catch (AccountLockedException e) {
            output.displayMessage(e.getMessage());
            return false;
        }
        return true;
    }

    private String inputPin() {
        StringBuilder validPin = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 4; i++) {
            boolean validInput = false;
            while (!validInput) {
                output.displayMessage("Введите " + i + " цифру пин-кода: ");
                String userInput = scanner.nextLine();
                if (!Character.isDigit(userInput.charAt(0))) {
                    output.displayMessage("Пароль состоит только из цифр");
                } else if (userInput.length() != 1) {
                    output.displayMessage("Допускается только один символ");
                } else {
                    validPin.append(userInput);
                    validInput = true;
                }
            }
        }
        return validPin.toString();
    }

    public void allowAccess() throws AccountLockedException {
        String enteredPin = inputPin();
        if (!enteredPin.equals(correctPin)) {
            handleIncorrectInputs();
        }
    }

    private void handleIncorrectInputs() throws AccountLockedException {
        incorrectInputs++;
        if (incorrectInputs < MAX_ATTEMPTS) {
            output.displayMessage("Введен неверный пароль. У вас осталось " + (MAX_ATTEMPTS - incorrectInputs) + " попыток.");
        } else {
            accountLock();
            throw new AccountLockedException("Вы ввели неправильный пароль " + MAX_ATTEMPTS + " раза." +
                    " Ваш аккаунт заблокирован. Повторите попытку через " + LOCK_DURATION_SECONDS + " секунд");
        }
    }

    private void accountLock() {
        try {
            Thread.sleep(LOCK_DURATION_SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
