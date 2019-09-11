public class Deadline extends Task {
    protected String by;

    /**
     * Constructor of Deadline
     * @param description describe the Deadline
     * @param by the timing/date of Deadline
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Method for the list format in Intellij
     * @return the list format in Intellij
     */
    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + "(by: " + by + ")";
    }

    /**
     * Method for the list format in Textfile
     * @return list format in Textfile
     */
    @Override
    public String getFormat() {
        return "D | " + super.getStatusIcon2() + " | " + super.getOnlyDescription() + "| " + by;
    }
}
