import java.util.ArrayList;

public class TaskList {
   protected ArrayList<Task> arr;
   public void List(ArrayList<Task> arr) {
       System.out.println("\tHere are the tasks in your list:");
       for(int i = 0; i < arr.size(); i++) {
           System.out.println("\t" + (i+1) + "."  + arr.get(i).getDescription());
       }
   }
   public void Add_Save(ArrayList<Task> arr, Task task, Storage storage) {
        arr.add(task);
        storage.SaveTxtFile(arr);
   }
   public void Delete(ArrayList<Task> arr ,Ui ui, Storage storage) {
       int to_delete = Integer.parseInt(ui.splitString[1]) - 1;
       System.out.println("\tNoted. I've removed this task:");
       System.out.println("\t  " + arr.get(to_delete).getDescription());
       arr.remove(to_delete);
       System.out.println("\tNow you have " + arr.size() + " tasks in the list.");
       storage.SaveTxtFile(arr);
   }
   public void Done(ArrayList<Task> arr ,Ui ui, Storage storage) {
       System.out.println("\tNice! I've marked this task as done:");
       int num_to_tick = Integer.parseInt(ui.splitString[1]) - 1; //convert the string to number
       arr.get(num_to_tick).markasDone();
       System.out.println("\t  " + arr.get(num_to_tick).getDescription());
       storage.SaveTxtFile(arr);
   }
   public void Find(ArrayList<Task> arr ,Ui ui) {
       String wordtofind = ui.splitString[1];
       ArrayList<Integer> contain_index = new ArrayList<Integer>();
       System.out.println("\tHere are the matching tasks in your list:");
       for(int i = 0; i < arr.size(); i++) {
           if(arr.get(i).getDescription().contains(wordtofind)) {
               System.out.println("\t" + (i+1) + "." + arr.get(i).getDescription());
           }
       }
   }
}
