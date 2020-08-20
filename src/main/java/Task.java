public class Task {

    private String task;
    private boolean done;

    public Task(String task) {
        this.task = task;
        this.done = false;
    }

    public void markDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        String mark = done ? "\u2713" : "\u2717";
        return String.format("[%s] %s", mark, task);
    }
}
