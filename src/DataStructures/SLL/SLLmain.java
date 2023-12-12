package DataStructures.SLL;

import java.util.*;

public class SLLmain {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    /*
     * public void creation()
     * {
     * int data,n;
     * Scanner sc = new Scanner(System.in);
     * do
     * {
     * System.out.println("Enter data : ");
     * data = sc.nextInt();
     * Node new_node = new Node(data);
     * if(head==null)
     * {
     * head=new_node;
     * }
     * else
     * {
     * new_node.next=head;
     * head=new_node;
     * }
     * System.out.println("Do you want to continue.If Yes, press:1");
     * n=sc.nextInt();
     * }
     * while(n==1);
     * 
     * }
     */

    // public void traversal()
    // {
    // Node temp=head;
    // if(head==null)
    // {
    // System.out.println("LL does not exist");
    // return;
    // }
    // else
    // {
    // while(temp.next!=null)
    // {
    // System.out.print("|"+temp.data+"|");
    // temp=temp.next;
    // }
    // }
    // }

    public void traversal() {
        try {
            Node temp = head;
            if (head == null) {
                System.out.println("LL is empty");
            } else {
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("An error occurred during traversal: " + e.getMessage());
        }
    }

    public void insertion() {
        int data, n, m, p;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter data : ");
            data = sc.nextInt();
            Node new_node = new Node(data);
            if (head == null) {
                head = new_node;
            } else {
                System.out.print(
                        "Enter 1 to be inserted node at beginning, 2 to be inserted node at the end, 3 to be inserted at any postion");
                m = sc.nextInt();
                switch (m) {
                    case 1:
                        new_node.next = head;
                        head = new_node;
                        break;
                    case 2:
                        Node temp = head;
                        while (temp.next != null) {
                            temp = temp.next;
                        }
                        temp.next = new_node;
                        break;

                    case 3:
                        System.out.print("Enter position to be inserted");
                        p = sc.nextInt();
                        Node temp1 = head;
                        for (int i = 0; i < p - 1; i++) {
                            temp1 = temp1.next;
                        }
                        new_node.next = temp1.next;
                        temp1.next = new_node;
                        break;
                }
            }
            System.out.println("Do you want to continue.If Yes, press:1");
            n = sc.nextInt();
        } while (n == 1);
        sc.close();
    }

    public static void main(String args[]) {
        SLLmain ll = new SLLmain();
        // ll.creation();
        ll.insertion();
        ll.traversal();
    }
}