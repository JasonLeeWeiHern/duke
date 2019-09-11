public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor of Task
     * @param var1 description of the Task
     */
    public Task(String var1) {
        this.description = var1;
        this.isDone = false;
    }

    /**
     * The method returns a tick icon if the boolean isDone is True and it returns a cross icon if isDone is False.
     * @return a tick icon if the boolean isDone is True and it returns a cross icon if isDone is False.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * The method returns a "1" if the boolean isDone is True and it returns a "0" if isDone is False.
     * @return a "1" if the boolean isDone is True and it returns a "0" if isDone is False.
     */
    public String getStatusIcon2() {
        return (isDone ? "1" : "0");
    }

    /**
     * Change the boolean express isDone to be true
     */
    public void markasDone() {
        this.isDone = true;
    }

    public String getDescription() {
        return "[" + getStatusIcon() + "] " + this.description;
    }

    public String getOnlyDescription() {
        return this.description;
    }

    public String getFormat() {
        return "x";
    }
}
