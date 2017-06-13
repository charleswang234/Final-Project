import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Generic queue class with all the main methods.
 * 
 * @author Charles Wang and Victor Huang
 * @version June, 2017
 */
public class Queue<Type>{
    protected Node first, last;
    public class Node{
        Type item; 
        Node next; 
    }

    public boolean isEmpty() { 
        return (first == null); 
    }

    public void enqueue(Type item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){  
            first = last;
        }
        else{
            oldLast.next = last;
        }
    }

    public Type dequeue() {
        Type item = first.item;
        first = first.next;
        if (isEmpty()) { 
            last = null;
        }
        return item;
    }

    public Type peek(){
        return first.item;
    }

    public int size(){
        Node checker = first;
        int check = 0;
        while (checker != null){
            check++;
            checker = checker.next;
        }
        return check;
    }
}
