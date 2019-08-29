import java.io.*;
import java.util.ArrayList;

public class Storage {
    private ArrayList<Task> arr_text;

    public Storage(ArrayList<Task> arr) {
        this.arr_text = arr;
    }

    public void SaveTxtFile(ArrayList<Task> arr_text) {
        File file = new File("D:\\duke\\MyDukeTask.txt");
        try {
            PrintWriter output = new PrintWriter(file);
            for (Task x : arr_text) {
                output.println(x.getFormat());
            }
            output.close();
        } catch (IOException ex) {
            System.out.print("ERROR: Not Available");
        }
    }
}
