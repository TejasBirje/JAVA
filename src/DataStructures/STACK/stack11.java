package DataStructures.STACK;

public class stack11 {
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX]; // Maximum size of Stack

	public boolean isEmpty() {
		return (top < 0);
	}

	public stack11() {
		top = -1;
	}

	public void push(int x) {
		
		try{
			a[++top] = x;
			System.out.println(x + " pushed into stack");
			return;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
	}

    public class StackEmptyException extends Exception {  
        public void display() {  
        System.out.println("Stack is Empty!"); 
        }  
    }  

	public int pop() {
		
		try {
            if(top<0) {
                throw new StackEmptyException();
            }
            else {
			int x = a[top--];
			return x;
		}
    }
    catch(StackEmptyException err){
            err.display();
        }
        return top;
	
    }

	public int peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a[top];
			return x;
		}
	}

	public void print() {

		if (top == -1) {
			System.out.println("Stack Underflow!");
		} else {
			for (int i = top; i > -1; i--) {
				System.out.println("| " + a[i] + " |");
			}
		}
	}
}
