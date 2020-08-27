package duke;

import duke.tasks.Task;

import java.util.List;
import java.util.Scanner;

/**
 * Class to handle the interface with the user.
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
    public void welcome() {
        writeOutput("Hello! I'm duke.Duke", "What can I do for you?");
    }

    /**
     * Outputs a Task being added, and the size of the list.
     *
     * @param task Task added
     * @param size size of the list
     */
    public void writeAdd(Task task, int size) {
        writeOutput("Got it. I've added this task:", task.toString(),
                String.format("Now you have %d tasks in the list.", size));
    }

    /**
     * Outputs a Task being marked done.
     *
     * @param task Task marked done
     */
    public void writeDone(Task task) {
        writeOutput("Nice! I've marked this task as done:", "\t" + task.toString());
    }

    /**
     * Outputs a Task being deleted, and the size of the list.
     *
     * @param task Task deleted
     * @param size size of the list
     */
    public void writeDelete(Task task, int size) {
        writeOutput("Noted. I've removed this task:", "\t" + task.toString(),
                String.format("Now you have %d tasks in the list.", size));
    }

    /**
     * Outputs Tasks found from a search.
     *
     * @param found string representations of Tasks found
     */
    public void writeSearch(List<String> found) {
        writeOutput(found.toArray(new String[0]));
    }

    /**
     * Formats the messages to be output.
     *
     * @param messages messages to be output
     */
    public void writeOutput(String... messages) {
        System.out.println("\t-----------------------------------------");
        for (String message : messages) {
            System.out.println("\t" + message);
        }
        System.out.println("\t-----------------------------------------");
    }

    /**
     * Closes the interface.
     */
    public void exit() {
        writeOutput("Bye. Hope to see you again soon!");
        scanner.close();
    }
}
