package ch02.stacks;

public class StackOverflowException extends RuntimeException{
    public StackOverflowException(String msg) {
        super(msg);
    }
}
