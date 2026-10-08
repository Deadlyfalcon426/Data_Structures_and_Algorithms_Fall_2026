//---------------------------------------------------------------------------
// test.java by Ahsan Mohammed Chapter 4
//
// Test all methods utilized in the custom Queue class that was just defined
//---------------------------------------------------------------------------
package ch04;

import ch04.queues.ArrayBoundedQueue;
import ch04.queues.QueueOverflowException;
import ch04.queues.QueueUnderflowException;

public class test {
    public static void main(String[] args) {

        System.out.println("Create a new ArrayBoundedQueue of Strings, with a max of 5 elements");
        ArrayBoundedQueue<String> q1 = new ArrayBoundedQueue<>(5);
        System.out.println("Create a new ArrayBoundedQueue of Integers, with a max of 10 elements");
        ArrayBoundedQueue<Integer> q2 = new ArrayBoundedQueue<>(10);
        System.out.println("Create a new ArrayBoundedQueue of Double numbers, with the default max of 100 elements");
        ArrayBoundedQueue<Double> q3 = new ArrayBoundedQueue<>();
        System.out.println("");
        System.out.println("Enqueue 5 elements to queue 1");
        for (int i = 1; i < 5+1; i++) {
            q1.enqueue(String.format("Position %d", i));
        }
        System.out.println("notice how we are removing them in the order they entered");
        System.out.println("");
        System.out.println("Check size and whether queue 1 is full");
        System.out.println("It is "+q1.isFull()+" that queue 1 is full, and queue 1 consists of "+q1.size()+" elements");
        System.out.println("");
        System.out.println("Attempt to add another element despite the queue being full");
        try{
            q1.enqueue("Another element but it wont fit"); 
        }catch(QueueOverflowException ex){
            System.out.println("Error: "+ex.getMessage());
        }
        System.out.println("");
        System.out.println("Dequeue the 5 elements from queue 1");
        for (int i = 0; i < 5; i++) {
            System.out.println(q1.dequeue()+" was removed");
        }
        System.out.println("");
        System.out.println("Check whether the queue is empty (It should be because we removed the 5 we added");
        System.out.println("It is "+q1.isEmpty()+" that queue 1 is empty");
        System.out.println("");
        System.out.println("Attempt to remove another element despite the queue being empty");
        try{
            q1.dequeue(); 
        }catch(QueueUnderflowException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
