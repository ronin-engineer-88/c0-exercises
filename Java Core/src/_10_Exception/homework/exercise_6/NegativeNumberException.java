package _10_Exception.homework.exercise_6;

public class NegativeNumberException extends NumberFormatException {
    public NegativeNumberException(String message) {
        super(message);
    }
}
