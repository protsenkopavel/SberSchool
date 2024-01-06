package Lesson4;

import Lesson4.exceptions.AccountLockedException;
import Lesson4.exceptions.IncorrectInputPinException;
import Lesson4.exceptions.IncorrectValueException;
import Lesson4.exceptions.NotEnoughBalanceException;
import Lesson4.impl.TerminalImpl;

import java.util.Scanner;

public class BankTerminal {
    private TerminalImpl terminal;
    private final Scanner scanner;

    public BankTerminal(TerminalImpl terminal) {
        this.terminal = terminal;
        this.scanner = new Scanner(System.in);
    }

    public void startTerminal() throws InterruptedException {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    checkAccountStatus();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Повторите ввод команды.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nВыберите команду и введите соответствующую цифру:");
        System.out.println("1. Проверить баланс");
        System.out.println("2. Положить деньги");
        System.out.println("3. Снять деньги");
        System.out.println("4. Выйти из приложения");
    }

    private void checkAccountStatus() throws InterruptedException {
        try {
            System.out.print("Введите PIN-код: ");
            String pin = scanner.nextLine();
            terminal.checkAccountStatus(pin);
        } catch (IncorrectInputPinException | AccountLockedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void depositMoney() {
        try {
            System.out.print("Введите сумму для пополнения (кратную 100): ");
            double amount = scanner.nextDouble();
            terminal.depositMoney(amount);
        } catch (IncorrectValueException e) {
            System.out.println(e.getMessage());
        }
    }

    private void withdrawMoney() {
        try {
            System.out.print("Введите сумму для снятия (кратную 100): ");
            double amount = scanner.nextDouble();
            terminal.withdrawMoney(amount);
        } catch (IncorrectValueException | NotEnoughBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
