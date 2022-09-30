import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * provided file for DLinkedList Assignment 
 *
 * @author lkfritz
 */
public class DLinkedList<T extends Comparable<T>> {

    public static void main(String[] args) throws FileNotFoundException {

        DLinkedList<String> lst1 = new DLinkedList<>();
        DLinkedList<String> lst2 = new DLinkedList<>();        

        Scanner fin = new Scanner(new File("text1.in"));
        String str;

        while (fin.hasNext()) {
            str = fin.next();
            str = cleanUp(str);           
           // lst1.insertOrderUnique(str);   
            lst1.insertOrder(str);
            //lst1.add(str);
        }
        fin.close();

        fin = new Scanner(new File("text2.in"));
        while (fin.hasNext()) {
            str = fin.next();
            str = cleanUp(str);
           // System.out.println(str);
           // lst2.insertOrderUnique(str);   
            lst2.insertOrder(str);
            //lst2.add(str);
        }

        System.out.println("List 1:  " + lst1);
        System.out.println("List 2:  " + lst2);
        
        
        DLinkedList combined = lst1.merge(lst2);
        
        System.out.println("\nAFTER MERGE");
        System.out.println("List 1:  " + lst1);
        System.out.println("List 2:  " + lst2);
        System.out.println("\n" + combined);
    }

    /**
     * ASSIGNED
     * @param str
     * @return str in all lower case with LEADING and TRAILING non-alpha
     * chars removed
     */
    public static String cleanUp(String str) {
    	/*
    	String s;
    	str.toLowerCase();
    	for (int i = 0; i < str.length(); i++) {
    		if ((str.charAt(i) >= 97 && str.charAt(i) <= 122) || str.charAt(i) == 39) {
    			str = str + str.charAt(i);
    			//str = "" + s;
    		}
    	}
    	*/
        return str;
    }

    //inner DNode class:  PROVIDED
    private class DNode {

        private DNode next, prev;
        private T data;

        private DNode(T val) {
            this.data = val;
            next = prev = this;
        }
    }

    //DLinkedList fields:  PROVIDED
    private DNode header;

    //create an empty list:  PROVIDED
    public DLinkedList() {
        header = new DNode(null);
    }

    /**
     * PROVIDED add
     *
     * @param item return ref to newly inserted node
     */
    public DNode add(T item) {
        //make a new node
        DNode newNode = new DNode(item);
        //update newNode
        newNode.prev = header;
        newNode.next = header.next;
        //update surrounding nodes
        header.next.prev = newNode;
        header.next = newNode;
        return newNode;
    }

    //PROVIDED
    public String toString() {
        String str = "[";
        DNode curr = header.next;
        while (curr != header) {
            str += curr.data + " ";
            curr = curr.next;
        }
        str = str.substring(0, str.length() - 1);
        return str + "]";
    }

    /**
     * ASSIGNED
     * remove val from the list
     *
     * @param val
     * @return true if successful, false otherwise
     */
    public boolean remove(T val) {
        return true;
    }

    /**
     * ASSIGNED
     *
     * @param item
     */
    public void insertOrder(T item) {
    	add(item);  	
    	//Sort the list after inserting the one element
    	DNode current = null, index = null;  
        T tempItem;   
        //Check whether list is empty  
        if(header.next == null) {  
            return;  
        }  
        else {  
            //Current will point to head  
            for(current = header.next; current.next != null && current.data!= null; current = current.next) { 
                //Index will point to node next to current  
                for(index = current.next; index != null && index.data!= null; index = index.next) {  
                    //If current's data is greater than index's data, swap the data of current and index
                    if(current.data.compareTo(index.data) > 0) {  
                        tempItem = current.data;  
                        current.data = index.data;  
                        index.data = tempItem;  
                    }  
                	
                }  
            }  
        }
    }

    /**
     * ASSIGNED
     *
     * @param item
     */
    public boolean insertOrderUnique(T item) {
        return true;
    }

    /**
     * ASSIGNED
     * PRE:  this and rhs are sorted lists
     * @param rhs
     * @return list that contains this and rhs merged into a sorted list
     * POST:  returned list will not contain duplicates
     */
    public DLinkedList merge(DLinkedList rhs) {
        DLinkedList result = new DLinkedList();
        return result;
    }

}