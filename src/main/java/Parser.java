import java.util.ArrayList;

public class Parser {
    /**
     * This methods will decipher the command by the user and execute the necessary methods base on the command.
     * @param arr List of all the task
     * @param tasklist Calling the class TaskList to...
     * @param ui Caslling the class UI to ...
     * @param storage Calling the class Storage to...
     * @param cdf Calling the class ChangeDateFormat to change the date format to textfile
     * @param command Calling the class Command to ...
     */
    public void Parse (ArrayList<Task> arr,TaskList tasklist, Ui ui, Storage storage, ChangeDateFormat cdf, Command command) {
        String agenda = "";
        String time = "";
        if(ui.statement.equals("bye")) {
            ui.End();
        }
        else if(ui.splitString[0].equals("list")) {
            tasklist.List(arr);
        }
        else if(ui.splitString[0].equals("done")) {
            tasklist.Done(arr,ui,storage);
        }
        else if(ui.splitString[0].equals("delete")) {
            tasklist.Delete(arr,ui,storage);
        }
        //added find function
        else if(ui.splitString[0].equals("find")) {
            tasklist.Find(arr,ui);
        }
        else if (ui.splitString[0].equals("todo")) {
            command.ToDoCommand(arr,ui,storage,tasklist);
        }
        else if(ui.splitString[0].equals("deadline")) {
            command.DeadlineCommand(arr,ui,storage,tasklist,cdf);
        }
        else if(ui.splitString[0].equals("event")) {
            command.EventCommand(arr,ui,storage,tasklist,cdf);
        }
    }

}
