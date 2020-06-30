package concurrency;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Sync extends Thread {
    volatile List<Integer> nums = new ArrayList<Integer>();

    Sync(String name) {
        super(name);
    }

    @Override 
    public synchronized void run() {
        Random rand = new Random();

        for(int i=0; i<100; i++) {
            int randInt = rand.nextInt(100);
            this.nums.add(randInt);
        }
    }

    public static void main(String[] args)  {

        Sync st1 = new Sync("st1");
        Sync st2 = new Sync("st2");
        Sync st3 = new Sync("st3");
        Sync st4 = new Sync("st4");
        Sync st5 = new Sync("st5");


        st1.run();

        System.out.println(st1.nums);
        //this prints out an empty list. write some code that will allow the data generated in the syncThread to show up  here.
        // There is a brute force way and a more sophisticated way.  Either or will work, but strive for sophistication :)

    }
    
}