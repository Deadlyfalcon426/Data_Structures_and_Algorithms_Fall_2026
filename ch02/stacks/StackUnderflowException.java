package ch02.stacks;

public class StackUnderflowException extends RuntimeException{
    public StackUnderflowException(String msg) {
        super(msg);
    }
}
