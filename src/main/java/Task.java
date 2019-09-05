public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String var1) {
        this.description = var1;
        this.isDone = false;
    }
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public String getStatusIcon2() {
        return (isDone ? "1" : "0");
    }
//jejejeje
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
