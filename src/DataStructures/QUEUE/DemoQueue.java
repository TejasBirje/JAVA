package DataStructures.QUEUE;

public class DemoQueue {

  /* Member variable declaration */
  public int maxSize = 100;
  public int[] queueArray;
  public int front;
  public int rear;
  public int currentSize;

  /* Constructor */
  public DemoQueue(int size) // Parameterized Constructor
  {
    this.queueArray = new int[size];
    front = 0;
    rear = -1;
  }

  /* Queue:Insert Operation */
  public void insert(int item) {
    /* Checks whether the queue is full or not */
    if (isQueueFull()) {
      System.out.println("Queue is full!");
      return;
    }
    if (rear == maxSize - 1) {
      rear = -1;
    }
    /* increment rear then insert element to queue */
    queueArray[++rear] = item;
    currentSize++;
    System.out.println("Item added to queue: " + item);
  }

  /* Queue:Delete Operation */
  public int delete() {
    /* Checks whether the queue is empty or not */
    if (isQueueEmpty()) {
      throw new RuntimeException("Queue is empty");
    }
    /* retrieve queue element then increment */
    int temp = queueArray[front++];
    if (front == maxSize) {
      front = 0;
    }
    currentSize--;
    return temp;
  }

  /* Queue:Peek Operation */
  public int peek() {
    return queueArray[front];
  }

  /* Queue:isFull Operation */
  public boolean isQueueFull() {
    return (maxSize == currentSize);
  }

  /* Queue:isEmpty Operation */
  public boolean isQueueEmpty() {
    return (currentSize == 0);
  }
  // public void print(int x) {

  // for(int i=0;i<queueArray.length;i++) {
  // System.out.print(queueArray[i]+" ");
  // x=
  // }
  // }
  /* Driver Code */
  public void print() {
    for (int i = 0; i < currentSize; i++) {
      int index = (front + i) % maxSize; // Calculate the actual index to access
      System.out.print(queueArray[index] + " ");
    }
    System.out.println(); // Add a newline for better formatting
  }

}
