package concurrency;

public class Main {
   
    public static void main(String[] args) {
         //run all of your threads from this main class.
        Reasoning r = new Reasoning();
        r.run();


        TeamTC1 codeConnoisseurs = new TeamTC1();
        Thread t = new Thread(codeConnoisseurs);
        t.start();
    }
}