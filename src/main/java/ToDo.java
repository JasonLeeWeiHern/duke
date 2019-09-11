public class ToDo extends Task {

    /**
     * Constructor of ToDo
     * @param description describes the task
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Method for the list format in Intellij
     * @return the list format
     */
    @Override
    public String getDescription() {
        return "[T]" + super.getDescription();
    }

    /**
     * Method for the list format in Textfile
     * @return list format in Textfile
     */
    @Override
    public String getFormat() {
        return "T | " + super.getStatusIcon2() + " | " + super.getOnlyDescription();
    }
}
