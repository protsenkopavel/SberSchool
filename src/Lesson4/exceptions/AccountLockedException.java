package Lesson4.exceptions;

public class AccountLockedException extends Exception{
    public AccountLockedException(String message) {
        super(message);
    }
}
