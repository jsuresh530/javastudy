package com.stackIANDQueue;

public class QueueNew {
    public static void main(String[] args) {
        // create an object of Queue class
        QueueNew q = new QueueNew();

        // try to delete element from the queue
        // currently queue is empty
        // so deletion is not possible
        q.deQueue();

        // insert elements to the queue
        for(int i = 1; i < 6; i ++) {
            q.enQueue(i);
        }

        // 6th element can't be added to queue because queue is full
        q.enQueue(6);

        q.display();

        // deQueue removes element entered first i.e. 1
        q.deQueue();

        // Now we have just 4 elements
        q.display();
    }
    int SIZE =5;
    int items[] = new int[SIZE];
    int front, rear;

    boolean isFull(){
        if(front == 0 && rear == SIZE-1){
            return true;
        }
        return false;
    }

    boolean isEmpty(){
        if(front == -1)
            return true;
         else
             return false;
    }

    void enQueue(int element){
        if(isFull ()){
            System.err.println ("Queue is full");
        }
        else{
            if(front == -1){
                front = 0;
            }
            rear++;
            //insert element at the rear
            items[rear] = element;
            System.out.println ("Insertion done : "+element);
        }

    }

    // delete element from the queue
    int deQueue() {
        int element;

        // if queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        }
        else {
            // remove element from the front of queue
            element = items[front];

            // if the queue has only one element
            if (front >= rear) {
                front = -1;
                rear = -1;
            }
            else {
                // mark next element as the front
                front++;
            }
            System.out.println( element + " Deleted");
            return (element);
        }
    }

    // display element of the queue
    void display() {
        int i;
        if (isEmpty ()) {
            System.out.println ("Empty Queue");
        } else {
            // display the front of the queue
            System.out.println ("\nFront index-> " + front);

            // display element of the queue
            System.out.println ("Items -> ");
            for (i = front; i <= rear; i++)
                System.out.print (items[i] + "  ");

            // display the rear of the queue
            System.out.println ("\nRear index-> " + rear);
        }

    }
}
