package ch02;
import ch02.stacks.*;
public class test {
    public static void main(String[] args) {
        ArrayListStack<String> stackA = new ArrayListStack<>();
        stackA.push("Hello");
        stackA.push("World");
        ArrayListStack<Integer> stackB = new ArrayListStack<>();
        stackB.push(55);
        stackB.push(39);
        ArrayListStack<Double> stackC = new ArrayListStack<>();
        stackC.push(4.524);
        stackC.push(242.5987);
        System.out.println("We fill our stacks using push()");
        System.out.println("First stack gets Hello and World");
        System.out.println("Second stack gets 55 and 39");
        System.out.println("Third stack gets 4.524 and 242.5987");
        System.out.println("Next, we use pop() to remove the first item of stacks B and C");
        stackB.pop();
        stackC.pop();
        System.out.println("If we use top() to find the item at the top, we will find that for A it is the old one and for B and C it is changed.");
        System.out.println("A: "+stackA.top()+" B: "+stackB.top()+" C: "+stackC.top());
        System.out.println("When we use pop() on C this time, it will be empty.");
        stackC.pop();
        System.out.println("Using isEmpty() on all stacks");
        System.out.println("A: "+stackA.isEmpty()+" B: "+stackB.isEmpty()+" C: "+stackC.isEmpty());
        System.out.println("Because we are using ArrayList, it can hold a dynamic amount of items, so it cannot be full");
        System.out.println("All of these should be false if we use method isFull()");
        System.out.println("A: "+stackA.isFull()+" B: "+stackB.isFull()+" C: "+stackC.isFull());
    }
}
