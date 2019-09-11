import java.util.ArrayList;

public class TaskList {
   protected ArrayList<Task> arr;

    /**
     * This method print out the list (all the task in the list)
     * @param arr List of all the taks
     */
   public void List(ArrayList<Task> arr) {
       System.out.println("\tHere are the tasks in your list:");
       for(int i = 0; i < arr.size(); i++) {
           System.out.println("\t" + (i+1) + "."  + arr.get(i).getDescription());
       }
   }

    /**
     * This method add and save the task to the list
     * @param arr List of all the tasks
     * @param task the task
     * @param storage to update the Duke textfile(save function)
     */
   public void Add_Save(ArrayList<Task> arr, Task task, Storage storage) {
        arr.add(task);
        storage.SaveTxtFile(arr);
   }

    /**
     * This method removes the Task the from the list.
     * @param arr List of all the tasks
     * @param ui get the splitString array that we did in InputCommand();
     * @param storage to update the Duke textfile(save function)
     */
   public void Delete(ArrayList<Task> arr ,Ui ui, Storage storage) {
       int to_delete = Integer.parseInt(ui.splitString[1]) - 1;
       System.out.println("\tNoted. I've removed this task:");
       System.out.println("\t  " + arr.get(to_delete).getDescription());
       arr.remove(to_delete);
       System.out.println("\tNow you have " + arr.size() + " tasks in the list.");
       storage.SaveTxtFile(arr);
   }

    /**
     * This method mark the the particular task in the list as done(changing the boolean expression isDone to be true
     * @param arr List of all the tasks
     * @param ui get the splitString array that we did in InputCommand();
     * @param storage to update the Duke textfile(save function)
     */
   public void Done(ArrayList<Task> arr ,Ui ui, Storage storage) {
       System.out.println("\tNice! I've marked this task as done:");
       int num_to_tick = Integer.parseInt(ui.splitString[1]) - 1; //convert the string to number
       arr.get(num_to_tick).markasDone();
       System.out.println("\t  " + arr.get(num_to_tick).getDescription());
       storage.SaveTxtFile(arr);
   }

    /**
     * This method finds the keyword from the list and it shows you the tasks that contains the keyword.
     * @param arr List of all the tasks
     * @param ui get the splitString array that we did in InputCommand();
     */
   public void Find(ArrayList<Task> arr,Ui ui) {
       String wordtofind = "";
       for(int i = 1; i < ui.splitString.length; i++) {
           if(i < ui.splitString.length - 1) {
               wordtofind += ui.splitString[i] + " ";
           }
           else {
               wordtofind += ui.splitString[i];
           }
       }
       ArrayList<Integer> contain_index = new ArrayList<Integer>();
       System.out.println("\tHere are the matching tasks in your list:");
       for(int i = 0; i < arr.size(); i++) {
           if(arr.get(i).getDescription().contains(wordtofind)) {
               System.out.println("\t" + (i+1) + "." + arr.get(i).getDescription());
           }
       }
   }
}
