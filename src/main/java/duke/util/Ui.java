package duke.util;

import duke.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to handle the interface with the user. Supports both GUI and CLI.
 */
public class Ui {

    Scanner scanner;

    /**
     * Creates a UI.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads input from the user.
     *
     * @return user input
     */
    public String readInput() {
        return scanner.nextLine();
    }

    /**
     * Outputs the welcome message to the user.
     */
    public String welcome(boolean isLoadSuccess) {
        if (isLoadSuccess) {
            return writeOutput("Existing data loaded from file!",
                    "Hello! I'm Duke", "What can I do for you?");
        } else {
            return writeOutput("Hello! I'm Duke", "What can I do for you?");
        }
    }

    /**
     * Outputs a Task being added, and the size of the list.
     *
     * @param task Task added
     * @param size size of the list
     */
    public String writeAdd(Task task, int size) {
        return writeOutput("Got it. I've added this task:", task.toString(),
                String.format("Now you have %d tasks in the list.", size));
    }

    /**
     * Outputs a Task being marked done.
     *
     * @param task Task marked done
     */
    public String writeDone(Task task) {
        return writeOutput("Nice! I've marked this task as done:", "\t" + task.toString());
    }

    /**
     * Outputs a Task being deleted, and the size of the list.
     *
     * @param task Task deleted
     * @param size size of the list
     */
    public String writeDelete(Task task, int size) {
        return writeOutput("Noted. I've removed this task:", "\t" + task.toString(),
                String.format("Now you have %d tasks in the list.", size));
    }

    /**
     * Outputs Tasks found from a search.
     *
     * @param found string representations of Tasks found
     */
    public String writeSearch(List<Task> found) {
        String[] outputs = new String[found.size() + 1];
        outputs[0] = "Here are the matching tasks in your list:";
        for (int i = 0; i < found.size(); i++) {
            outputs[i + 1] = found.get(i).toString();
        }
        return writeOutput(outputs);
    }

    public String writeMassOp(List<Task> tasks, String operation) {
        String[] outputs = new String[tasks.size() + 1];
        outputs[0] = String.format("The following tasks have been %s:", operation);
        for (int i = 0; i < tasks.size(); i++) {
            outputs[i + 1] = tasks.get(i).toString();
        }
        return writeOutput(outputs);
    }

    /**
     * Formats the messages to be output.
     *
     * @param messages messages to be output
     */
    public String writeOutput(String... messages) {
        StringBuilder finalOut = new StringBuilder();
        System.out.println("\t-----------------------------------------");
        for (String message : messages) {
            System.out.println("\t" + message);
            finalOut.append(message).append("\n");
        }
        System.out.println("\t-----------------------------------------");
        return finalOut.toString();
    }

    /**
     * Closes the interface.
     */
    public String exit() {
        scanner.close();
        return writeOutput("Bye. Hope to see you again soon!");
    }
}