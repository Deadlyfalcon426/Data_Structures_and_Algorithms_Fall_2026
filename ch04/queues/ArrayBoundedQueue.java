//---------------------------------------------------------------------------
// ArrayBoundedQueue.java by Ahsan Mohammed Chapter 4
//
// Implements QueueInterface with an array to hold the queue elements.
// Two constructors are provided: one that creates a queue of a default
// capacity and one that allows the calling program to specify the capacity.
//---------------------------------------------------------------------------
package ch04.queues;
public class ArrayBoundedQueue<T> implements QueueInterface<T>{
    protected final int DEFCAP = 100; // default capacity
    protected T[] elements; // array that holds queue elements
    protected int numElements = 0; // number of elements in the queue
    protected int front = 0; // index of front of queue
    protected int rear; // index of rear of queue
    public ArrayBoundedQueue(){
        elements = (T[]) new Object[DEFCAP];
        rear = DEFCAP-1;
    }
    public ArrayBoundedQueue(int maxSize){
        if(maxSize<0){
            throw new QueueUnderflowException("Cannot initialize a queue with a value this low");
        }
        elements = (T[]) new Object[maxSize];

        rear = maxSize - 1;
    }
    @Override 
    public T dequeue(){
// Throws QueueUnderflowException if this queue is empty;
// otherwise, removes front element from this queue and returns it.
        if (isEmpty()){
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        } else{
            T toReturn = elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            /*im noting here that this might be possible to further optimize by doing the following:
            making the DEFCAP mutable but leaving its default value there
            adding a line in the arg-constructor to set the defcap to the passed arg
            then, u dont have to use the array size, you can use the already-saved-within-our-class-scope array size!!
            should speed it up a little bit but idk. it really depends what is the impact of reaching into the array's scope
            Professor, if you read this I'd love to get your thoughts on this idea
            */
            numElements--;
            return toReturn;
        }
    }
    @Override 
    public void enqueue(T element){
        if(isFull()){
            throw new QueueOverflowException("Enqueue attempted on full queue");
        }else{
            rear = (rear + 1) % elements.length;
            elements[rear] = element;
            numElements++;
        }
    }
    @Override 
    public boolean isEmpty(){
    // Returns true if this queue is empty; otherwise, returns false
        return (numElements == 0);
    }
    @Override 
    public boolean isFull(){
    // Returns true if this queue is full; otherwise, returns false.
        return (numElements == elements.length);
    }
    @Override
    public int size(){
// Returns the number of elements in this queue.
        return numElements;
    }
}