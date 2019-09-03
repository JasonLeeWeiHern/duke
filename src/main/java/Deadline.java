public class Deadline extends Task {
    protected String by;

    //cr8ing the deadline constructor
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + "(by:" + by + ")";
    }

    @Override
    public String getFormat() {
        return "D | " + super.getStatusIcon2() + " | " + super.getOnlyDescription() + "|" + by;
    }
}
