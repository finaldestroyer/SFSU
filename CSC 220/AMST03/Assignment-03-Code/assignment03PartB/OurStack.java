/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: OurStack.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Japheth Wun
 * **********************************************
 */

package assignment03PartB;
import java.util.Stack;

public class OurStack<T> implements StackInterface<T> {
    Stack<T> StackEntry;

    public OurStack() {
        T StackEntry = null;
    }

    public void push(T newEntry) {
        StackEntry.push(newEntry);
    }

    public T peek() {
        while(StackEntry != null){
            return StackEntry.peek();
        }
        return null;
    }

    public T pop() {
        if(StackEntry != null){
            StackEntry.pop();
        }
        return null;
    }

    public boolean isEmpty() {
        if(StackEntry == null) {
            return true;
        }
        return false;
    }

    public void clear() {
        while(StackEntry != null){
            StackEntry.pop();
        }
    }
}