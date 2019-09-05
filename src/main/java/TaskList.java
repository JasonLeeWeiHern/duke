import java.util.ArrayList;

public class TaskList {
   protected ArrayList<Task> arr;

   public void List(ArrayList<Task> arr) {
       System.out.println("\tHere are the tasks in your list:");
       for(int i = 0; i < arr.size(); i++) {
           int number = i + 1;
           System.out.println("\t" + number + "."  + arr.get(i).getDescription());
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
}
