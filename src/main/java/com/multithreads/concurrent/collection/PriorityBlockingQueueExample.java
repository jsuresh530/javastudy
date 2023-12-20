package com.multithreads.concurrent.collection;

import java.util.concurrent.PriorityBlockingQueue;

class FirstWorker implements Runnable {

    private PriorityBlockingQueue<Person> priorityBlockingQueue;

    public FirstWorker(PriorityBlockingQueue<Person > pbq){
        this.priorityBlockingQueue = pbq;
    }

    @Override
    public void run() {
        priorityBlockingQueue.put (new Person ("sur",32));
        priorityBlockingQueue.put (new Person ("kks",21));
        priorityBlockingQueue.put (new Person ("hfj",65));
        priorityBlockingQueue.put (new Person ("den",87));
    }
}

class SecondWorker implements Runnable {

    private PriorityBlockingQueue<Person> pbq;
    public SecondWorker(PriorityBlockingQueue<Person> priorityBlockingQueue){
        this.pbq = priorityBlockingQueue;
    }
    @Override
    public void run() {
        try {
            Thread.sleep (5000);
            System.out.println (pbq.take ().toString ());
            Thread.sleep (1000);
            System.out.println (pbq.take ().getAge ());
            Thread.sleep (2000);
            System.out.println (pbq.take ().getAge ());
            Thread.sleep (3000);
            System.out.println (pbq.take ().getAge ());


        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

    }
}

class Person implements Comparable<Person>{
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
    private String name;

    public Person(String name, int age){
        this.name =name;
        this.age=age;
    }
    @Override
    public int compareTo(Person person) {
        return Integer.compare (this.age, person.getAge ());
    }

}
public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        PriorityBlockingQueue<Person> blockingQueue = new PriorityBlockingQueue<> ();
        FirstWorker firstWorker = new FirstWorker (blockingQueue);
        SecondWorker secondWorker = new SecondWorker (blockingQueue);

        new Thread (firstWorker).start ();
        new Thread (secondWorker).start ();

    }
}
