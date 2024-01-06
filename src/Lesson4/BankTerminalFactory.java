package Lesson4;

import Lesson4.impl.ConsoleOutput;
import Lesson4.impl.PinValidatorImpl;
import Lesson4.impl.TerminalImpl;
import Lesson4.impl.TerminalServerImpl;

public class BankTerminalFactory {
    public static BankTerminal createBankTerminal() {
        TerminalServerImpl server = new TerminalServerImpl();
        PinValidatorImpl pinValidator = new PinValidatorImpl();
        ConsoleOutput output = new ConsoleOutput();
        TerminalImpl terminal = new TerminalImpl(server, pinValidator, output);

        return new BankTerminal(terminal);
    }
}
