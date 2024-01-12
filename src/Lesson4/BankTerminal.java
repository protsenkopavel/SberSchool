package Lesson4;

import Lesson4.impl.PinValidator;
import Lesson4.impl.TerminalImpl;

import java.util.Scanner;

public class BankTerminal {
    private TerminalImpl terminal;
    private PinValidator validator;
    private final Scanner scanner;

    public BankTerminal(TerminalImpl terminal, PinValidator validator) {
        this.terminal = terminal;
        this.validator = validator;
        this.scanner = new Scanner(System.in);
    }

    public void startTerminal() {
        while (validator.validatePin()) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    checkAccountBalance();
                    break;
                case 2:
                    depositMoney(getValue());
                    break;
                case 3:
                    withdrawMoney(getValue());
                    break;
                case 4:
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

    private double getValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму: ");
        return scanner.nextDouble();
    }

    private void checkAccountBalance() {
            terminal.checkAccountBalance();
    }

    private void depositMoney(double value) {
            terminal.depositMoney(value);
    }

    private void withdrawMoney(double value) {
            terminal.withdrawMoney(value);
    }
}
