import java.util.ArrayList;

public class Parser {
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
