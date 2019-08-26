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

    public void markasDone() {
            this.isDone = true;
    }
    
    public String getDescription() {
        return this.description;
    }
}
