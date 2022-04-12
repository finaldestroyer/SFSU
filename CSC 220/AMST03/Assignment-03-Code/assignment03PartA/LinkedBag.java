/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: LinkedBag.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Japheth Wun
 * **********************************************
 */

package assignment03PartA;

public final class LinkedBag<T> implements PrimaryDataStructureBagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;
    private String entries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
        entries = null;
    }

    public int getCurrentSize() {
        int counter = 0;
        while(firstNode != null){
            counter++;
            firstNode= firstNode.next;
        }
        return counter;
    }

    public boolean isEmpty() {
        if(firstNode == null) {
            return true;
        }
        return false;
    }

    public boolean add(T newEntry) {
        /*Node temp = null;
        temp.data = (T) entries;
        if (firstNode == null) {
            firstNode = temp;
            numberOfEntries++;
            return true;
        }
        temp.next=firstNode;
        numberOfEntries++;
        return true;*/
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make new node reference rest of chain
        firstNode = newNode; // New node is at beginning of chain
        numberOfEntries++;
        return true;
    }

    public boolean removeAllOccurrences(T[][] entries) {
        while(firstNode != null) {
            Node temp = firstNode.next;
            firstNode = null;
            firstNode = temp;
            if(firstNode == null){
                return true;
            }
        }
        return false;
    }

    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
            }
        return result;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }
}