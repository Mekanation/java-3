package concurrency;

class Reasoning extends Thread{
    //set up this class so it can become a valid thread. 
    void distinguish() {
        //print to the console the difference between a thread and a process
        //print out you think will happen if you invoke the run() method of a thread as opposed to the start() method of a thread.
        System.out.println("Run() will run a task on the existing thread if called on the same object, " +
                "start() will spin up a new thread and run concurrently with any other threads that are open");
        System.out.println("The difference between a thread and a process is that a thread is a small segment of a process that is inside a process, " +
                "a process is a large overall application/block of code");

    }

    @Override
    public void run() {
        distinguish();
    }
}

