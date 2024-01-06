package Lesson4.impl;

import Lesson4.interfaces.OutputInterface;

public class ConsoleOutput implements OutputInterface {
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
