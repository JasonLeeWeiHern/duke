import java.util.ArrayList;

public class Parser {
    protected String statement;
    protected String[] splitString;
    protected ArrayList<Task> arr;

    public Parser (Ui ui) {
        this.statement = ui.statement;
        this.splitString = ui.splitString;
        this.arr = new ArrayList<Task>();
    }
    public void Parse (ArrayList<Task> arr,TaskList tasklist, Ui ui, Storage storage, ChangeDateFormat cdf) {
        int list_number = 1;
        String agenda = "";
        String time = "";
        if(ui.statement.equals("bye")) {
            ui.End();
        }
        else if(ui.splitString[0].equals("list")) {
            System.out.println("\tHere are the tasks in your list:");
            for(int i = 0; i < arr.size(); i++) {
                System.out.println("\t" + list_number + "."  + arr.get(i).getDescription());
                list_number++;
            }
        }
        else if(ui.splitString[0].equals("done")) {
            System.out.println("\tNice! I've marked this task as done:");
            int num_to_tick = Integer.parseInt(ui.splitString[1]) - 1; //convert the string to number
            arr.get(num_to_tick).markasDone();
            System.out.println("\t  " + arr.get(num_to_tick).getDescription());
            storage.SaveTxtFile(arr);
        }
        else if(ui.splitString[0].equals("delete")) {
            tasklist.Delete(arr,ui,storage);
        }
        //added find function
        else if(ui.splitString[0].equals("find")) {
            String wordtofind = ui.splitString[1];
            ArrayList<Integer> contain_index = new ArrayList<Integer>();
            int list_num = 1;
            System.out.println("\tHere are the matching tasks in your list:");
            for(int i = 0; i < arr.size(); i++) {
                if(arr.get(i).getDescription().contains(wordtofind)) {
                    System.out.println("\t" + list_num + "." + arr.get(i).getDescription());
                    list_num++;
                }
            }
        }
        else if (ui.splitString[0].equals("todo")) {
            for (int i = 1; i < ui.splitString.length; i++) {
                agenda += ui.splitString[i] + " ";
            }
            ToDo todo = new ToDo(agenda);
            tasklist.Add_Save(arr,todo,storage);
            System.out.println("\tGot it. I've added this task:");
            System.out.println("\t  " + todo.getDescription());
            System.out.println("\tNow you have " + arr.size() + " tasks in the list.");
        }
        else if(ui.splitString[0].equals("deadline")) {
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
        else if(ui.splitString[0].equals("event")) {
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

}
