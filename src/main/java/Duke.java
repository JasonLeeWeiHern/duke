import java.util.ArrayList;

/**
 * Main class of Duke project
 */

public class Duke {
    public static void main(String[] args) {
        Storage storage = new Storage();
        TaskList tasks  = new TaskList();
        Ui ui= new Ui();
        Parser parse = new Parser();
        Command command = new Command();
        ChangeDateFormat cdf;
        ui.StartUp(); //welcome message
        ArrayList<Task> arr = new ArrayList<Task>();
        storage.ReadFile(arr); //read the file load from the disk
        ui.statement = " ";
        while(!ui.statement.equals("bye")) {
            ui.Inputcommand();
            cdf = new ChangeDateFormat(ui.statement);
            parse.Parse(arr, tasks, ui, storage, cdf, command);
        }
    }
}