import java.util.ArrayList;

public class Command {
    /**
     * This method calls out the add and save class and print out the format when you input a ToDo command
     * @param arr List of all the tasks
     * @param ui get the splitString array that we did in InputCommand();
     * @param storage Call out the storage class so that can input into the TaskList class as a param.
     * @param tasklist Call out the TaskList class to add & save the task
     */
    public void ToDoCommand (ArrayList<Task> arr, Ui ui, Storage storage, TaskList tasklist) {
        String agenda = "";
        for (int i = 1; i < ui.splitString.length; i++) {
            agenda += ui.splitString[i] + " ";
        }
        ToDo todo = new ToDo(agenda);
        tasklist.Add_Save(arr,todo,storage);
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t  " + todo.getDescription());
        System.out.println("\tNow you have " + arr.size() + " tasks in the list.");
    }
    /**
     * This method calls out the add and save class and print out the format when you input a Deadline command
     * @param arr List of all the tasks
     * @param ui get the splitString array that we did in InputCommand();
     * @param storage
     * @param tasklist Call out the TaskList class to add & save the task
     */
    public void DeadlineCommand (ArrayList<Task> arr, Ui ui, Storage storage, TaskList tasklist, ChangeDateFormat cdf) {
        String agenda = "";
        String time = "";
        for (int i = 1; i < ui.splitString.length; i++) {
            if (!ui.splitString[i].equals("/by")) {
                agenda += ui.splitString[i] + " ";
            } else {
                while ((i + 1) < ui.splitString.length) {
                    time += " " + ui.splitString[i + 1];
                    i += 1;
                }
                break;
            }
        }
        Deadline newDeadline = new Deadline(agenda, cdf.NewFormat(time));
        tasklist.Add_Save(arr,newDeadline,storage);
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t  " + newDeadline.getDescription());
        System.out.println("\tNow you have " + arr.size() + " tasks in the list.");
    }
    /**
     * This method calls out the add and save class and print out the format when you input a Event command
     * @param arr List of all the tasks
     * @param ui get the splitString array that we did in InputCommand();
     * @param storage
     * @param tasklist Call out the TaskList class to add & save the task
     */
    public void EventCommand (ArrayList<Task> arr, Ui ui, Storage storage, TaskList tasklist, ChangeDateFormat cdf) {
        String agenda = "";
        String time = "";
        for (int i = 1; i < ui.splitString.length; i++) {
            if (!ui.splitString[i].equals("/at")) {
                agenda += ui.splitString[i] + " ";
            } else {
                while ((i + 1) < ui.splitString.length) {
                    time += " " + ui.splitString[i + 1];
                    i += 1;
                }
                break;
            }
        }
        Event newEvent = new Event(agenda, cdf.NewFormat(time));
        tasklist.Add_Save(arr,newEvent,storage);
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t  " + newEvent.getDescription());
        System.out.println("\tNow you have " + arr.size() + " tasks in the list.");
    }
}
