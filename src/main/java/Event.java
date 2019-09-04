public class Event extends Task {
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }
    @Override
    public String getDescription() {
        return "[E]" + super.getDescription() + "(at:" + at + ")";
    }
    @Override
    public String getFormat() {
        return "E | " + super.getStatusIcon2() + " | " + super.getOnlyDescription() + "|" + at;
    }
}
