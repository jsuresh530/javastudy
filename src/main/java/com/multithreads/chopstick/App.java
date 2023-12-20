package com.multithreads.chopstick;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = null;
        Philosopher[] philosophers = null;
        ChopStick[] chopSticks = null;

        try {
            philosophers = new Philosopher[Constants.NUM_OF_PHILOSOPHERS];
            chopSticks = new ChopStick[Constants.NUM_OF_CHOPSTICKS];

            for (int i = 0; i < Constants.NUM_OF_CHOPSTICKS; ++i) {
                chopSticks[i] = new ChopStick (i);
            }
            executorService = Executors.newFixedThreadPool (Constants.NUM_OF_PHILOSOPHERS);

            for (int i = 0; i < Constants.NUM_OF_PHILOSOPHERS; ++i) {
                philosophers[i] = new Philosopher (i, chopSticks[i], chopSticks[(i+1)%Constants.NUM_OF_PHILOSOPHERS]);

            executorService.execute (philosophers[i]);
            }

            Thread.sleep (Constants.SIMULATION_RUNNING_TIME);

            for (Philosopher philosopher : philosophers)
                philosopher.setFull (true);


        } catch (InterruptedException e) {
            e.printStackTrace ();
        } finally {

            executorService.shutdown ();

            while (!executorService.isTerminated ()){
                Thread.sleep (1000);
            }

            for (Philosopher philosopher : philosophers)
                System.out.println (philosopher+" eat # "+philosopher.getEatingCounter ()+" times ");
        }

    }
}
