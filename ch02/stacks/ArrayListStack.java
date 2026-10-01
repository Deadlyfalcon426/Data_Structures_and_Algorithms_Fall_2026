//---------------------------------------------------------------------------
// ArrayListStack.java by Dale/Joyce/Weems Chapter 2
//
// Implements an unbounded stack using an ArrayList.
//---------------------------------------------------------------------------
package ch02.stacks;
import java.util.*;
public class ArrayListStack<T> implements StackInterface<T>{
    protected ArrayList<T> elements; // ArrayList that holds stack elements
    public ArrayListStack(){
        elements = new ArrayList<T>();
    }
    @Override 
    public void push(T element){
    // Places element at the top of this stack.
        elements.add(element);
    }

    @Override 
    public void pop(){
        if (isEmpty()){
            throw new StackUnderflowException("Pop attempted on empty stack.");
        }else{
            elements.remove(elements.size() - 1);
        }
    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.
    }
    @Override 
    public T top(){
 // Throws StackUnderflowException if this stack is empty,
 // otherwise returns top element of this stack.
        T topOfStack = null;
        if (isEmpty()){
            throw new StackUnderflowException("Top attempted on empty stack.");
        }else{
            topOfStack = elements.get(elements.size() - 1);
            return topOfStack;
        }
    }
    @Override 
    public boolean isEmpty(){
        // Returns true if this stack is empty, otherwise returns false.
        return (elements.size() == 0);
    }
    @Override 
    public boolean isFull(){
 // Returns false – an ArrayListStack is never full.
        return false;
    }
}