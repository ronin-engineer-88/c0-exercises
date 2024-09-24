package _10_Exception.homework.exercise_9;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) { // exception cho số dư k đủ.
        super(message);
    }
}