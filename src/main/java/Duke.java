import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");

        ArrayList<Task> arr = new ArrayList<Task>(); //initialise ArrayList

        int position = 0; //Index in the ArrayList

        Scanner input = new Scanner(System.in);

        String statement = input.nextLine(); //read an input

        while (!statement.equals("")) {
            Task newTask = new Task(statement); //assign the statement to the task
            String[] splitString = statement.split(" ");//split the string into individual words
            int list_number = 1;
            if(statement.equals("bye")) {
                System.out.println("\tBye. Hope to see you again soon!");
                break;
            }

            else if(statement.equals("list")) {
                System.out.println("\tHere are the tasks in your list:");
                for(int i = 0; i < position; i++) {
                    System.out.println("\t" + list_number + "." + "[" + arr.get(i).getStatusIcon() + "] " + arr.get(i).getDescription());
                    list_number++;
                }
            }
            else if(splitString[0].equals("done")) {
                System.out.println("\tNice! I've marked this task as done:");
                int num_to_tick = Integer.parseInt(splitString[1]) - 1; //convert the string to number
                arr.get(num_to_tick).markasDone();
                System.out.println("\t  [" + arr.get(num_to_tick).getStatusIcon() + "] " + arr.get(num_to_tick).getDescription());
            }
            else {
                System.out.println("\tadded: " + statement);
                arr.add(newTask);
                position++;
            }
            statement = input.nextLine();
        }
    }
}