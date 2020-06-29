package concurrency;

import java.util.ArrayList;
import java.util.List;

class TeamTC1 implements Runnable{
//

    List<String> team = new ArrayList<>();
//
//    //This thread should be created by implementing the Runnable interface, NOT by extending the Thread class.
//    //In the run method of this thread, print out the name of each student in your TA group, (starting with your TA).
//    //There should be a pause of 1 second before each name is printed to the console.The name should then be pushed to the team List
//    //After all the names have been pushed to this List, print out the entire list of all the students in your TA group.
//    //Don't forget your TA as well!  All of these steps should be done whenever the thread is started.
//    //(i.e. it can be done directly in the run()method of the thread itself).  Kick off the thread in the Main class of the concurrency package.

    @Override
    public void run() {
        var names = List.of("Mark Bennett", "Aaron White", "Caleb Waters", "Cody Clark", "Justin Cheng", "Kevin Keesee", "Matthew Choat", "Tyler Clements", "Zach Johnson", "Gotham Katta", "John Bozarov", "Korey Brooks","Sarah Bates");
        try {
            for(var n : names){
                wait(1000);
                System.out.println(Color.getRandomColor() + n);
                team.add(Color.getRandomColor() + n);

            }


//            wait(1000);
//            System.out.println(Color.getRandomColor() + "Mark Bennett");
//            team.add(Color.getRandomColor() + "Mark Bennett");
        }catch (InterruptedException e) {
            System.out.println("Something went wrong!");
        }
        team.forEach(System.out::println);


    }


}