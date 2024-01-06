package Lesson4;

import Lesson4.impl.TerminalImpl;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankTerminal bankTerminal = BankTerminalFactory.createBankTerminal();
        bankTerminal.startTerminal();
    }
}
