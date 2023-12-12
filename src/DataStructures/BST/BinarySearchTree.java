package DataStructures.BST;

import java.util.*;

/* Class BSTNode */

public class BinarySearchTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /* Creating object of BST */

        BST bst = new BST();
        char ch;

        /* Perform tree operations */
        do {
            System.out.println("Binary Search Tree Operations - ");
            System.out.println("1. insert ");
            System.out.println("2. delete");
            System.out.println("3. search");
            System.out.println("4. count nodes");
            System.out.println("5. check empty");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter element to insert : ");
                    bst.insert(scan.nextInt());
                    break;

                case 2:
                    System.out.println("Enter element to delete : ");
                    bst.delete(scan.nextInt());
                    break;

                case 3:
                    System.out.println("Enter element to search : ");
                    System.out.println("Search result : " + bst.search(scan.nextInt()));
                    break;

                case 4:
                    System.out.println("Number of node: " + bst.countNodes());
                    break;

                case 5:
                    System.out.println("Empty status = " + bst.isEmpty());
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
            /* Display tree */

            System.out.print("Post order : ");

            bst.postorder();
            System.out.println();

            System.out.print("Pre order : ");

            bst.preorder();
            System.out.println();

            System.out.print("In order : ");

            bst.inorder();
            System.out.println();

            System.out.print("\nDo you want to continue? (Type y or n) \n");

            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
        scan.close();
    }
}