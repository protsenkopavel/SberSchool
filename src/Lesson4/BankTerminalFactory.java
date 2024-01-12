package Lesson4;

import Lesson4.impl.ConsoleOutput;
import Lesson4.impl.PinValidator;
import Lesson4.impl.TerminalImpl;
import Lesson4.impl.TerminalServer;

public class BankTerminalFactory {
    public static BankTerminal createBankTerminal() {
        TerminalServer server = new TerminalServer();
        ConsoleOutput output = new ConsoleOutput();
        TerminalImpl terminal = new TerminalImpl(server, output);
        PinValidator validator = new PinValidator();

        return new BankTerminal(terminal, validator);
    }
}
