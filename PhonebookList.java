package com.company;

import java.util.*;

public class PhonebookList{

    public static void main(String[] args){
        PhonebookList phone = new PhonebookList();
        phone.testphonebook();
    }
    class Node {
        PhonebookData data;
        Node previous;
        Node next;

        public Node(PhonebookData data) {
            this.data = data;
        }
    }
    Node head, tail = null;
        public void addNode(PhonebookData data) {
            Node newNode = new Node(data);

            if(head == null) {
                //Both head and tail will point to newNode
                head = tail = newNode;
                //head's previous will point to null
                head.previous = null;
                //tail's next will point to null, as it is the last node of the list
                tail.next = null;
            }
            else {
                //newNode will be added after tail such that tail's next will point to newNode
                tail.next = newNode;
                //newNode's previous will point to tail
                newNode.previous = tail;
                //newNode will become new tail
                tail = newNode;
                //As it is last node, tail's next will point to null
                tail.next = null;
            }
        }
        //display() will print out the nodes of the list
        public void display() {
            //Node current will point to head
            Node current = head;
            if(head == null) {
                System.out.println("List is empty");
                return;
            }
            System.out.println("Nodes of doubly linked list: ");
            while(current != null) {
                //Prints each node by incrementing the pointer.

                System.out.println(current.data + " ");
                current = current.next;
            }
        }
        public void testphonebook(){
        PhonebookList dList = new PhonebookList();
        Scanner s = new Scanner(System.in);
        dList.addNode(new PhonebookData("Joe Smith", "610-476-0909"));
        dList.addNode(new PhonebookData("Joe Smith", "610-476-0909"));
        dList.addNode(new PhonebookData("Michael Galinsky", "610-500-3849"));
        dList.addNode(new PhonebookData("Jacky Zoony", "(484)-670-1987"));
        dList.addNode(new PhonebookData("James Veriga", "610-477-0804"));
        dList.addNode(new PhonebookData("Zach Taylor", "484-627-4783"));
        dList.addNode(new PhonebookData("Linda Herman", "484-555-6789"));

        dList.display();
        System.out.println("Enter h to search from head first, enter t to search from the tail first, enter q to quit");
        String choice = s.nextLine();
        while (!choice.equals("q")){
            if (choice.equals("h")){
                System.out.println("Head First");
                System.out.println("Enter search item: ");
                String searchitem = s.nextLine();
                SortedSet sortedset = dList.searchHeadFirst(searchitem);
                if (sortedset != null){
                    for (Object node: sortedset){
                        System.out.println(((PhonebookData) node).toString());
                    }
                }
                else {
                    System.out.println("No search results found...");
                }
            }
            else if (choice.equals("t")){
                System.out.println("Tail First");
                System.out.println("Enter search item: ");
                String searchitem = s.nextLine();
                SortedSet sortedset = dList.searchTailFirst(searchitem);
                if (sortedset != null){
                    for (Object node : sortedset){
                        System.out.println(((PhonebookData) node).toString());
                    }
                }
                else {
                    System.out.println("No search results found...");
                }

            }
            System.out.println("Enter h to search from head first, enter t to search from the tail first, enter q to quit");
           choice = s.nextLine();
        }
        System.out.println("Bye");
    }

    public SortedSet searchHeadFirst(String search) {
        SortedSet sortedSet = new TreeSet();
        Node current = head;
        if (head == null) {
            System.out.println("List is Empty");
        }
        else {
            while (current != null) {

                if (current.data.getName().toLowerCase().contains(search.toLowerCase().strip()) || current.data.getMobilePhone().toLowerCase().contains(search.toLowerCase().strip()))
                {
                    sortedSet.add((PhonebookData) current.data);
                }
                current = current.next;
            }
        }
        return sortedSet;
    }
        public SortedSet searchTailFirst(String search){
            SortedSet sortedset = new TreeSet();
            Node current = tail;
            if (tail == null) {
                System.out.println("List is Empty");
            }
            else   {
                while (current != null){

                    if (current.data.getName().toLowerCase().contains(search.toLowerCase().strip()) ||
                            current.data.getMobilePhone().toLowerCase().contains(search.toLowerCase().strip())){
                        sortedset.add((PhonebookData) current.data);
                    }
                    current = current.previous;
                }

            }
            return sortedset;
    }
public class PhonebookData  implements Comparable {
    String name;
    String mobilePhone;
    public PhonebookData(String name, String mobilePhone) {
        this.name = name;
        this.mobilePhone = mobilePhone;
    }
    public String getName() {
        return name;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public String toString() {
        return name + " " + mobilePhone ;
    }
    public static int compare(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int) str1.charAt(i);
            int str2_ch = (int) str2.charAt(i);
            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (l1 != l2) {
            return l1 - l2;
        }
        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }
    @Override
    public int compareTo(Object o) {
        PhonebookData pd = (PhonebookData)o;
        return  compare(this.name,pd.name);
    }


}
}