/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Adeel
 */
public class Queue extends CollectionAbstract {

    private int numOfElements;

    public int getNumOfElements() {
        return numOfElements;
    }

    public void setNumOfElements(int numOfElements) {
        this.numOfElements = numOfElements;
    }



    public Node first;
    public Node last;

    public static class Node {

        public Object item;
        public Node next;
    }

    public Queue() {
        numOfElements = 0;
        first = last = null;
    }

    public void enqueue(Object value) {

        synchronized (this) {
            Node oldlast = last;
            last  = new Node();
            last.item =  value;
            last.next = null;

            if (getNumOfElements() == 0) {
                first = last;
            } else {             
                oldlast.next = last;
            }
            setNumOfElements(getNumOfElements()+1);
        }
    }

    public Object dequeue() throws NoElementException {

        synchronized (this) {

            Object item = null;
            if (isEmpty()) {
                throw new NoElementException();
            }
            item = first.item;
            first = first.next;
             setNumOfElements(getNumOfElements()-1);
            if (isEmpty()) {
                last = null;
            }
            return item;
        }
    }

    public Object peek() throws NoElementException {

        synchronized (this) {
            if (isEmpty()) {
                throw new NoElementException();
            }
            Object item = first.item;
            //   System.out.println("this is peek");        
            return item;
        }
    }

    public boolean isEmpty() {
        return first== null;
    }

    /**
     *
     * @param stack
     * @return
     */
    public boolean equals(Stack stack) {
        int tempNumOfElements = getNumOfElements();
        if (tempNumOfElements != stack.getNumOfElements())
        {
            return false;
        }
        while (tempNumOfElements == 0) {
            tempNumOfElements--;
            if (first.item != stack.getTop().item) {
                return false;
            }
            first = first.next;
            stack.setTop(stack.getTop().link);
        }
        return true;
    }

    public boolean equals(Queue queue) {
       int tempNumOfElements = getNumOfElements();

        if (tempNumOfElements != queue.getNumOfElements())
        {
            return false;
        }
        while (tempNumOfElements == 0 ) {
            tempNumOfElements--;            
         
            if (first.item != queue.first.item) {
                return false;
            }
            first = first.next;
            queue.first = queue.first.next;
        }
        return true;
    }

}

