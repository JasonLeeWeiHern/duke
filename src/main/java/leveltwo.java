import java.util.Scanner;

public class leveltwo {
    public static void main(String[] args) {
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");

        String[] arr = new String[100];
        int position = 0;

        Scanner input = new Scanner(System.in);
        String statement = input.nextLine(); //read an input

        while (!statement.equals("")) {
            int list_number = 1;
            if(statement.equals("bye")) {
                System.out.println("     Bye. Hope to see you again soon!");
                break;
            }
            if(statement.equals("list")) {
                for(int i = 0; i < position; i++) {
                    System.out.println("     " + list_number + ". " + arr[i]);
                    list_number++;
                }
            }
            else {
                System.out.println("     added: " + statement);
                arr[position] = statement;
                position++;
            }
            statement = input.nextLine();
        }
    }
}
