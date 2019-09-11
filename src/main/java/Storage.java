import java.io.*;
import java.util.ArrayList;

public class Storage {


    /**
     * This method writes the content into the Textfile(if not created, it will create a text file) and update it with the textfile
     * format by using the getFormat() function.
     * @param arr List of all the tasks
     */
    public void SaveTxtFile(ArrayList<Task> arr) {
        File file = new File("D:\\duke\\MyDukeTask.txt");
        try {
            PrintWriter output = new PrintWriter(file);
            for (Task x : arr) {
                output.println(x.getFormat());
            }
            output.close();
        } catch (IOException ex) {
            System.out.print("ERROR: Not Available");
        }
    }


    /**
     * This method will read and extract the task in the textfile and put into the array. Also, it will conver the format back
     * to the original Intellij list format.
     * @param arr List of all the task
     */
    public void ReadFile(ArrayList<Task> arr) {
        BufferedReader br = null;
        String line;
        try {
            FileReader fr = new FileReader("D:\\duke\\MyDukeTask.txt");
            br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                String[] splitter = line.split("\\|");

                for(int i = 0; i < splitter.length; i++) {
                    splitter[i] = splitter[i].trim();
                }

                if(splitter[0].equals("D")) {
                    Deadline newD = new Deadline(splitter[2] + " ", " " + splitter[3]);
                    if(splitter[1] == " 0") {
                        newD.isDone = false;
                    }
                    else if(splitter[1] == "1") {
                        newD.isDone = true;
                    }
                    arr.add(newD);
                }
                else if(splitter[0].equals("E")) {
                    Event newE = new Event(splitter[2] + " ", " " + splitter[3]);
                    if(splitter[1] == " 0") {
                        newE.isDone = false;
                    }
                    else if(splitter[1] == "1") {
                        newE.isDone = true;
                    }
                    arr.add(newE);
                }
                else {
                    ToDo newT = new ToDo(splitter[2]);
                    if(splitter[1] == "0") {
                        newT.isDone = false;
                    }
                    else if(splitter[1] == "1") {
                        newT.isDone = true;
                    }
                    arr.add(newT);
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
