/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.NoSuchElementException;

/**
 *
 * @author Adeel
 */
public class Stack extends CollectionAbstract {

    private int numOfElements;

    public static class Node {

        public Object item;
        public Node link;
    }
    public Node top;

    public Stack() {
        this.top = null;
        numOfElements = 0;
    }

    public void push(Object value) {
        synchronized (this) {
            Node tempnode = new Node();

            tempnode.item = value;
            tempnode.link = top;
            this.setTop(tempnode);
            numOfElements++;
        }
    }

    public int getNumOfElements() {
        return numOfElements;
    }

    public void setNumOfElements(int numOfElements) {
        this.numOfElements = numOfElements;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public Object peek() throws NoElementException {
        synchronized (this) {
            if (isEmpty()) {
                throw new NoElementException();
            }
            return top.item;
        }
    }

    public Object pop() throws NoElementException {
        synchronized (this) {

            if (isEmpty()) {
                throw new NoElementException();
            }
            Object item = top.item;
            top = top.link;

            numOfElements--;
            return (item);

        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean equals(Queue queue) {
        if (this.numOfElements != queue.getNumOfElements()) {
            return false;
        }
        int tempNumOfElements = numOfElements;
        while (tempNumOfElements == 0) {
            tempNumOfElements--;
            if (this.top.item != queue.first.item) {
                return false;
            }
            this.top
                    = top = top.link;
            queue.first = queue.first.next;
        }
        return true;
    }

    public boolean equals(Stack stack) {
        if (this.numOfElements != stack.numOfElements) {
            return false;
        }
        int tempNumOfElements = numOfElements;
        while (tempNumOfElements > 0) {
            tempNumOfElements--;
            if (this.top.item != stack.top.item) {
                return false;
            }
            top = top.link;
            stack.top = stack.top.link;
        }
        return true;
    }

}
