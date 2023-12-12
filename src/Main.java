import java.awt.*;
import java.awt.event.*;
import java.util.*;
import DataStructures.SLL.*;
import DataStructures.STACK.stack11;
import DataStructures.BST.*;
import DataStructures.CLL.CSLL;
import DataStructures.DLL.DLL;
import DataStructures.QUEUE.DemoQueue;

//import MAINMPR.*;
public class Main {
    String username;
    String password;
    Scanner sc= new Scanner(System.in);
    public Main() throws InvalidLoginException {

        Frame loginPage= new Frame("Login Page");
        Label usernlabel= new Label("UserName");
        Label passwordlabel= new Label("Password");
        TextField usertext=new TextField(20);
        TextField passwordtext=new TextField(20);
        passwordtext.setEchoChar('*');
        Button loginbutton= new Button("Login");
        loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username= usertext.getText();
                password= passwordtext.getText();
                try {
                    validateLogin(username, password);
                    System.out.println("Login successful");
                    loginPage.dispose();
                    openNextPage();
                }catch(InvalidLoginException ex){
                    System.out.println("Login failed :"+ex.getMessage());
                    usertext.setText("");
                    passwordtext.setText("");
                }
            }
        });
        loginPage.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginPage.dispose();
            }
        });
        loginPage.setLayout(null);
        loginPage.add(usernlabel);
        loginPage.add(usertext);
        usernlabel.setBounds(50, 80, 80, 30);
        usertext.setBounds(150, 80, 200, 20);
        loginPage.add(passwordlabel);
        loginPage.add(passwordtext);
        passwordlabel.setBounds(50, 120, 80, 30);
        passwordtext.setBounds(150, 120, 200, 20);
        loginPage.add(loginbutton);
        loginbutton.setBounds(150, 160, 80, 30);
        loginPage.setSize(450, 600);
        loginPage.setBackground(Color.LIGHT_GRAY);
        loginPage.setVisible(true);
    }
    private static void validateLogin(String username, String password) throws InvalidLoginException {
        if (!username.equals("STMOOP") || !password.equals("STMOOP")) {
            throw new InvalidLoginException("Invalid username or password");
        }
    }

    static class InvalidLoginException extends Exception{
        public InvalidLoginException(String message){
            super(message);
        }
    }
    private static void openNextPage() {
        Frame MenuPageFrame = new Frame("DSA MENU");
        MenuPageFrame.setSize(600, 400);
        MenuPageFrame.setBackground(Color.LIGHT_GRAY);
        MenuPageFrame.setVisible(true);
        Label header = new Label("Welcome! What Data Structure do you want to use?");
        CheckboxGroup group = new CheckboxGroup();

        Checkbox radio1 = new Checkbox("Stack", group, false);
        Checkbox radio2 = new Checkbox("Queue", group, false);
        Checkbox radio3 = new Checkbox("Single Linked list", group, false);
        Checkbox radio4 = new Checkbox("Double Linked list", group, false);
        Checkbox radio5 = new Checkbox("Circular Linked list", group, false);
        Checkbox radio6 = new Checkbox("Binary Search tree", group, false);
        MenuPageFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        MenuPageFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MenuPageFrame.dispose();
            }
        });
        MenuPageFrame.add(header);
        header.setBounds(200,50,300,20);
        MenuPageFrame.add(radio1);
        radio1.setBounds(150, 80, 80, 20);
        MenuPageFrame.add(radio2);
        radio2.setBounds(150, 110, 80, 20);
        MenuPageFrame.add(radio3);
        radio3.setBounds(150, 140, 80, 20);
        MenuPageFrame.add(radio4);
        radio4.setBounds(150, 170, 80, 20);
        MenuPageFrame.add(radio5);
        radio5.setBounds(150, 200, 80, 20);
        MenuPageFrame.add(radio6);
        radio6.setBounds(150, 230, 80, 20);
        MenuPageFrame.setLayout(null);
        ItemListener itemListener= new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(radio1.getState()){
                    stack11 obj = new stack11();
                    int n1;
                    Scanner sc= new Scanner(System.in);
                    Scanner sc2 = new Scanner(System.in);
                    do {

                        System.out.println("Stack Operations - ");
                        System.out.println("1. PUSH\n2. POP\n3. DISPLAY\n4. EXIT");
                        int choice = sc2.nextInt();
                        switch (choice) {

                            case 1: // Push

                                System.out.println("Enter element to be pushed : ");
                                int data = sc2.nextInt();
                                obj.push(data);
                                break;

                            case 2: // Pop

                                System.out.println("Popped element is : " + obj.pop());
                                break;

                            case 3: // Print

                                obj.print();
                                break;

                            case 4: // Exit
                                System.exit(0);

                            default:
                                System.out.println("Invalid choice!");
                        }

                        System.out.println("Do you want to continue? If yes, type 1: \n");
                        n1 = sc.nextInt();
                    } while (n1 == 1);

                    sc2.close();
                }else if (radio2.getState()){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter size of Queue: ");
                    Scanner q = new Scanner(System.in);
                    int size = q.nextInt();
                    DemoQueue queue = new DemoQueue(size);
                    int choice, m;
                    do {
                        System.out.println("Queue Operations - ");
                        System.out.println("1. ENQUEUE\n2. DEQUEUE\n3. PEEK\n4. DISPLAY\n5. EXIT");
                        choice = q.nextInt();

                        switch (choice) {
                            case 1: // Enqueue
                                try {
                                    System.out.println("Enter item to be inserted: ");
                                    int item = q.nextInt();
                                    queue.insert(item);
                                } catch (IndexOutOfBoundsException f) {
                                    System.out.println(f);
                                }
                                break;

                            case 2: // Dequeue
                                try {
                                    System.out.println("Item deleted from the queue is: " + queue.delete());
                                } catch (RuntimeException f) {
                                    System.out.println(f);
                                }
                                break;

                            case 3: // Peek
                                System.out.println("Item at the front of the queue is: " + queue.peek());
                                break;

                            case 4: // Display
                                System.out.println("Queue content: \n");
                                queue.print();
                                break;

                            case 5: // Exit
                                System.exit(0);

                            default:
                                System.out.println("Invalid Choice!");
                        }
                        System.out.println("\nDo you want to continue? If yes, type 1: ");
                        m = sc.nextInt();
                    } while (m == 1);


                }
                else if(radio3.getState()){
                    SLLmain ll = new SLLmain();
                    ll.insertion();
                    ll.traversal();
                }
                else if(radio4.getState()){

                    DLL llnew2 = new DLL();
                    llnew2.insertion();
                    llnew2.delete();
                    llnew2.traversal();

                }
                else if(radio5.getState()){
                    CSLL llnew = new CSLL();
                    llnew.creation();
                    llnew.traversal();
                    llnew.insertion();
                    llnew.delete();
                }
                else if(radio6.getState()) {
                    Scanner scan = new Scanner(System.in);
                    /* Creating object of BST */
                    BST bst = new BST();
                    char ch;
                    /* Perform tree operations */
                    do {
                        System.out.println("Binary Search Tree Operations - ");
                        System.out.println("1. Insert ");
                        System.out.println("2. Delete");
                        System.out.println("3. Search");
                        System.out.println("4. Count Nodes");
                        System.out.println("5. Check Empty");
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
                                System.out.println("Number of Node : " + bst.countNodes());
                                break;

                            case 5:
                                System.out.println("Empty status : " + bst.isEmpty());
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
        };

        radio1.addItemListener(itemListener);
        radio2.addItemListener(itemListener);
        radio3.addItemListener(itemListener);
        radio4.addItemListener(itemListener);
        radio5.addItemListener(itemListener);
        radio6.addItemListener(itemListener);
    }
    public static void main (String[]args) throws InvalidLoginException {
        new Main();
    }
}


//class MainMPR {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("1. BST\n2. SLL \n3. CSLL\n4. DLL\n5. STACK\n6. QUEUE\n");
//        System.out.println("Your MAIN choice: ");
//        int choiceMAIN = sc.nextInt();
//        switch (choiceMAIN) {
//            case 1:
//                Scanner scan = new Scanner(System.in);
//                /* Creating object of BST */
//                BST bst = new BST();
//                char ch;
//                /* Perform tree operations */
//                do {
//                    System.out.println("Binary Search Tree Operations - ");
//                    System.out.println("1. Insert ");
//                    System.out.println("2. Delete");
//                    System.out.println("3. Search");
//                    System.out.println("4. Count Nodes");
//                    System.out.println("5. Check Empty");
//                    System.out.print("Enter your choice: ");
//                    int choice = scan.nextInt();
//
//                    switch (choice) {
//                        case 1:
//                            System.out.println("Enter element to insert : ");
//                            bst.insert(scan.nextInt());
//                            break;
//
//                        case 2:
//                            System.out.println("Enter element to delete : ");
//                            bst.delete(scan.nextInt());
//                            break;
//
//                        case 3:
//                            System.out.println("Enter element to search : ");
//                            System.out.println("Search result : " + bst.search(scan.nextInt()));
//                            break;
//
//                        case 4:
//                            System.out.println("Number of Node : " + bst.countNodes());
//                            break;
//
//                        case 5:
//                            System.out.println("Empty status : " + bst.isEmpty());
//                            break;
//
//                        default:
//                            System.out.println("Invalid Choice!");
//                            break;
//                    }
//                    /* Display tree */
//
//                    System.out.print("Post order : ");
//
//                    bst.postorder();
//                    System.out.println();
//
//                    System.out.print("Pre order : ");
//
//                    bst.preorder();
//                    System.out.println();
//
//                    System.out.print("In order : ");
//
//                    bst.inorder();
//                    System.out.println();
//
//                    System.out.print("\nDo you want to continue? (Type y or n) \n");
//
//                    ch = scan.next().charAt(0);
//
//                } while (ch == 'Y' || ch == 'y');
//                scan.close();
//                break;
//
//            case 2:
//                SLLmain ll = new SLLmain();
//                ll.insertion();
//                ll.traversal();
//                break;
//
//            case 3:
//                CSLL llnew = new CSLL();
//                llnew.creation();
//                llnew.traversal();
//                llnew.insertion();
//                llnew.delete();
//                break;
//
//            case 4:
//                DLL llnew2 = new DLL();
//                llnew2.insertion();
//                llnew2.delete();
//                llnew2.traversal();
//
//                break;
//
//            case 5:
//                stack11 obj = new stack11();
//                int n1;
//
//                Scanner sc2 = new Scanner(System.in);
//                do {
//
//                    System.out.println("Stack Operations - ");
//                    System.out.println("1. PUSH\n2. POP\n3. DISPLAY\n4. EXIT");
//                    int choice = sc2.nextInt();
//                    switch (choice) {
//
//                        case 1: // Push
//
//                            System.out.println("Enter element to be pushed : ");
//                            int data = sc2.nextInt();
//                            obj.push(data);
//                            break;
//
//                        case 2: // Pop
//
//                            System.out.println("Popped element is : " + obj.pop());
//                            break;
//
//                        case 3: // Print
//
//                            obj.print();
//                            break;
//
//                        case 4: // Exit
//                            System.exit(0);
//
//                        default:
//                            System.out.println("Invalid choice!");
//                    }
//
//                    System.out.println("Do you want to continue? If yes, type 1: \n");
//                    n1 = sc.nextInt();
//                } while (n1 == 1);
//
//                sc2.close();
//                break;
//            case 6:
//                System.out.println("Enter size of Queue: ");
//                Scanner q = new Scanner(System.in);
//                int size = q.nextInt();
//                DemoQueue queue = new DemoQueue(size);
//                int choice, m;
//                do {
//                    System.out.println("Queue Operations - ");
//                    System.out.println("1. ENQUEUE\n2. DEQUEUE\n3. PEEK\n4. DISPLAY\n5. EXIT");
//                    choice = q.nextInt();
//
//                    switch (choice) {
//                        case 1: // Enqueue
//                            try {
//                                System.out.println("Enter item to be inserted: ");
//                                int item = q.nextInt();
//                                queue.insert(item);
//                            } catch (IndexOutOfBoundsException e) {
//                                System.out.println(e);
//                            }
//                            break;
//
//                        case 2: // Dequeue
//                            try {
//                                System.out.println("Item deleted from the queue is: " + queue.delete());
//                            } catch (RuntimeException e) {
//                                System.out.println(e);
//                            }
//                            break;
//
//                        case 3: // Peek
//                            System.out.println("Item at the front of the queue is: " + queue.peek());
//                            break;
//
//                        case 4: // Display
//                            System.out.println("Queue content: \n");
//                            queue.print();
//                            break;
//
//                        case 5: // Exit
//                            System.exit(0);
//
//                        default:
//                            System.out.println("Invalid Choice!");
//                    }
//                    System.out.println("\nDo you want to continue? If yes, type 1: ");
//                    m = sc.nextInt();
//                } while (m == 1);
//                break;
//
//            default:
//                System.out.println("invalid Choice!");
//        }
//
//        sc.close();
//    }
//}
