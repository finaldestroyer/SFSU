package assignment04PartE;

/**
 * Part E
 */

import java.util.PriorityQueue;

public class SFSUOneStop {
    public static void display(PriorityQueue<assignment04PartE.Student> oneStopPQ, String priority) {
        System.out.println("Priority: " + priority);
        display(oneStopPQ);
    }

    //Displays the Queue
    public static void display(PriorityQueue<assignment04PartE.Student> oneStopPQ) {
        for (Student student : oneStopPQ) {
            //System.out.println(student.firstname+"      "+student.lastname+"      "+student.id+"      "+student.gpa+"    "+ student.smallQ+"     "+student.largeQ);
            System.out.printf("%7s   %7s    %4s    %3s     %2s    %2s", student.firstname, student.lastname, student.id, student.gpa, student.smallQ, student.largeQ);
            System.out.println("\n");
        }
        //System.out.println("\n");
        /*while(!oneStopPQ.isEmpty()) {
            System.out.println(oneStopPQ.remove());
        }*/
    }

}
