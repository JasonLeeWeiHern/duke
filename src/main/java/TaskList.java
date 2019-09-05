import java.util.ArrayList;

public class TaskList {
   protected ArrayList<Task> arr;

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
}
