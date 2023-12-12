package DataStructures.CLL;

import java.util.*;

public class CSLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void creation() {
        int data, n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter data : ");
            data = sc.nextInt();
            Node new_node = new Node(data);
            if (head == null) {
                head = new_node;
                tail = new_node;
                new_node.next = head; // also we can do (new_node.next=tail)
            } else {
                new_node.next = head;
                head = new_node;
                tail.next = head;
            }
            System.out.println("Do you want to continue.If Yes, press:1");
            n = sc.nextInt();
        } while (n == 1);
        sc.close();
    }

    public void traversal() {
        Node temp = head;
        if (head == null) {
            System.out.println("LL does not exist");
        } else {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
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
                tail = new_node;
                new_node.next = head;
            } else {
                System.out.print(
                        "Enter 1 to be inserted node at beginning, 2 to be inserted node at the end, 3 to be inserted at any postion");
                m = sc.nextInt();
                switch (m) {
                    case 1:
                        new_node.next = head;
                        head = new_node;
                        tail.next = head;
                        break;
                    case 2:
                        tail.next = new_node;
                        tail = new_node;
                        new_node.next = head;
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

    public void delete() {
        int n, m, p;
        Scanner sc = new Scanner(System.in);
        do {
            if (head == null) {
                System.out.print("LL is empty");
            } else {
                System.out.print(
                        "Enter 1 to delete node from beginning, 2 to be delete node from the end, 3 to be delete from any postion");
                m = sc.nextInt();
                switch (m) {
                    case 1:
                        Node temp = head;
                        temp = temp.next;
                        head = temp;
                        tail.next = head;
                        break;

                    case 2:
                        Node temp1 = head;
                        Node ptr = temp1.next;
                        while (ptr.next != head) {
                            temp1 = ptr;
                            ptr = ptr.next;
                        }
                        temp1.next = head;
                        tail = temp1;
                        break;

                    case 3:
                        System.out.print("Enter position of node to be deleted");
                        p = sc.nextInt();
                        Node temp2 = head;
                        Node ptr1 = temp2.next;
                        for (int i = 0; i < p - 1; i++) {
                            temp2 = ptr1;
                            ptr1 = ptr1.next;
                        }
                        temp2.next = ptr1.next;
                        break;
                }
            }
            System.out.print("Do you want to delete more data. If yes press 1");
            n = sc.nextInt();
        } while (n == 1);
        sc.close();
    }

    public static void main(String args[]) {
        CSLL ll = new CSLL();
        ll.creation();
        ll.traversal();
        ll.insertion();
        ll.delete();
    }
}
