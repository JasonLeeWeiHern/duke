public class Event extends Task {
    protected String at;

    /**
     * Constructor of Todo
     * @param description describe the Event
     * @param at the timing/date of Event
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Method for the list format in Intellij
     * @return the list format in Intelli
     */
    @Override
    public String getDescription() {
        return "[E]" + super.getDescription() + "(at:" + at + ")";
    }

    /**
     * Method for the list format in Textfile
     * @return list format in Textfile
     */
    @Override
    public String getFormat() {
        return "E | " + super.getStatusIcon2() + " | " + super.getOnlyDescription() + "|" + at;
    }
}
