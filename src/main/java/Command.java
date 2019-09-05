import java.util.ArrayList;

public class Command {
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
