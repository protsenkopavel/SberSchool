package Lesson4;

import Lesson4.impl.TerminalImpl;

public class Main {
    public static void main(String[] args) throws InterruptedException {

    }

    public static void task1() throws InterruptedException {
        BankTerminal bankTerminal = BankTerminalFactory.createBankTerminal();
        bankTerminal.startTerminal();
    }

    public static void task2() {
        WebContentReader webContentReader = new WebContentReader();
        webContentReader.start();
    }
}
