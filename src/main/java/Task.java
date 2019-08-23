public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String var1) {
        this.description = var1;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return this.isDone ? "✓" : "✘";
    }

    public void markasDone() {
        if (this.getStatusIcon().equals("✘")) {
            this.isDone = true;
        }

    }

    public String getDescription() {
        return this.description;
    }
}
