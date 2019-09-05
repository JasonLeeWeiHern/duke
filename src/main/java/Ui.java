import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ui {
    protected String[] splitString;
    protected String statement;


    public void Inputcommand () {
        Scanner input = new Scanner(System.in);
        while(true) {
            statement = input.nextLine();
            splitString = statement.split(" ");//split the string into individual words
            try {
                if (statement.equals("todo") || statement.equals("deadline") || statement.equals("event")) {
                    throw new DukeException("\t☹ OOPS!!! The description of a " + splitString[0] + " cannot be empty.");
                } else if (!statement.equals("list") && !(splitString[0].equals("done") && splitString.length != 1) && !(statement.equals("bye")) &&
                        !splitString[0].equals("todo") && !splitString[0].equals("deadline") && !splitString[0].equals("event") && !splitString[0].equals("delete") && !splitString[0].equals("find")) {
                    throw new DukeException("\t☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                } else {
                    break;
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void StartUp() {
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
    }

    public void End() {
        System.out.println("\tBye. Hope to see you again soon!");
    }
}
