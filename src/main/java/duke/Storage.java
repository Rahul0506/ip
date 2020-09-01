package duke;

import duke.tasks.Task;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to handle storing and reading task data from the disk.
 */
public class Storage {

    private Path FILE_PATH;
    private final String dirName;
    private final String fileName;

    /**
     * Creates a Storage object to handle a file at the given file path.
     */
    public Storage(String dirName, String fileName) {
        this.dirName = dirName;
        this.fileName = fileName;
    }

    /**
     * Initialises a TaskList by checking for pre-existing data and loading
     * if present, or creating an empty TaskList.
     *
     * @param ui Ui object to handle user interface interactions
     * @return initialised TaskList
     */
    public TaskList init(Ui ui) {
        String home = System.getProperty("user.dir");
        FILE_PATH = java.nio.file.Paths.get(home, dirName);
        try {
            java.nio.file.Files.createDirectory(FILE_PATH);
        } catch (FileAlreadyExistsException ignored) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        TaskList taskList = new TaskList();
        FILE_PATH = java.nio.file.Paths.get(home, dirName, fileName);
        try {
            java.nio.file.Files.createFile(FILE_PATH);
        } catch (FileAlreadyExistsException ignored) {
            taskList = new TaskList(loadList());
            ui.writeOutput("Existing data loaded from file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    /**
     * Saves the task list to the file.
     *
     * @param taskList List of Task objects to write to file
     */
    public void storeList(List<Task> taskList) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH.toString());

            for (Task task : taskList) {
                writer.write(task.fileString() + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads task list from the file.
     *
     * @return List of strings representing the tasks
     */
    public List<String> loadList() {
        List<String> stringList = new ArrayList<>();
        try {
            BufferedReader reader = java.nio.file.Files.newBufferedReader(FILE_PATH);

            String line;
            while ((line = reader.readLine()) != null) {
                stringList.add(line);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return stringList;
    }
}
