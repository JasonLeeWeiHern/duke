import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");

        ArrayList<Task> arr = new ArrayList<Task>(); //initialise ArrayList

        Storage save = new Storage(arr);
        Storage read = new Storage(arr);
        Scanner input = new Scanner(System.in);
        read.ReadFile(arr);

        int bugger = 0;

        while (true) {
            String agenda = "";
            String statement;
            String time = ""; //for the date and time
            String[] splitString;
            //ChangeDateFormat cdf = new ChangeDateFormat(time);

            while(true) {
                statement = input.nextLine(); //read an input
                splitString = statement.split(" ");//split the string into individual words
                try {
                    if(statement.equals("todo") || statement.equals("deadline") || statement.equals("event")) {
                        throw new DukeException("\t☹ OOPS!!! The description of a " + splitString[0] + " cannot be empty.");
                    }
                    else if(!statement.equals("list") && !(splitString[0].equals("done") && splitString.length != 1) && !(statement.equals("bye")) &&
                            !splitString[0].equals("todo") && !splitString[0].equals("deadline") && !splitString[0].equals("event") && !splitString[0].equals("delete") && !splitString[0].equals("find")) {
                        throw new DukeException("\t☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                    else {
                        break;
                    }
                }
                catch (DukeException e) {
                    System.out.println(e.getMessage());
                }
            }

            int list_number = 1;
            if(statement.equals("bye")) {
                System.out.println("\tBye. Hope to see you again soon!");
                break;
            }
            else if(statement.equals("list")) {
                System.out.println("\tHere are the tasks in your list:");
                for(int i = 0; i < arr.size(); i++) {
                    System.out.println("\t" + list_number + "."  + arr.get(i).getDescription());
                    list_number++;
                }
            }

            else if(splitString[0].equals("done")) {
                System.out.println("\tNice! I've marked this task as done:");
                int num_to_tick = Integer.parseInt(splitString[1]) - 1; //convert the string to number
                arr.get(num_to_tick).markasDone();
                System.out.println("\t  " + arr.get(num_to_tick).getDescription());
                save.SaveTxtFile(arr);
            }
            else if (splitString[0].equals("todo")) {
                for (int i = 1; i < splitString.length; i++) {
                    agenda += splitString[i] + " ";
                }
                ToDo todo = new ToDo(agenda);
                arr.add(todo);
                save.SaveTxtFile(arr);
                System.out.println("\tGot it. I've added this task:");
                System.out.println("\t  " + todo.getDescription());
                System.out.println("\tNow you have " + arr.size() + " tasks in the list.");
            }
            else if(splitString[0].equals("deadline")) {
                for (int i = 1; i < splitString.length; i++) {
                    if (!splitString[i].equals("/by")) {
                        agenda += splitString[i] + " ";
                    } else {
                        while ((i + 1) < splitString.length) {
                            time += " " + splitString[i + 1];
                            i += 1;
                        }
                        break;
                    }
                }
                Deadline newDeadline = new Deadline(agenda, time);
                arr.add(newDeadline);
                save.SaveTxtFile(arr);
                System.out.println("\tGot it. I've added this task:");
                System.out.println("\t  " + newDeadline.getDescription());
                System.out.println("\tNow you have " + arr.size() + " tasks in the list.");
            }
            else if(splitString[0].equals("event")) {
                for (int i = 1; i < splitString.length; i++) {
                    if (!splitString[i].equals("/at")) {
                        agenda += splitString[i] + " ";
                    } else {
                        while ((i + 1) < splitString.length) {
                            time += " " + splitString[i + 1];
                            i += 1;
                        }
                        break;
                    }
                }
                Event newEvent = new Event(agenda, time);
                arr.add(newEvent);
                save.SaveTxtFile(arr);
                System.out.println("\tGot it. I've added this task:");
                System.out.println("\t  " + newEvent.getDescription());
                System.out.println("\tNow you have " + arr.size() + " tasks in the list.");
            }
        }
    }
}
