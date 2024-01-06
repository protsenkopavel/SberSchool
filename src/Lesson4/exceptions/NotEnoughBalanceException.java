package Lesson4.exceptions;

public class NotEnoughBalanceException extends Exception{
    public NotEnoughBalanceException(String message) {
        super(message);
    }
}
