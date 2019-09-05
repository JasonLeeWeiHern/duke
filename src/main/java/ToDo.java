public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }
    @Override
    public String getDescription() {
        return "[T]" + super.getDescription();
    }
    @Override
    public String getFormat() {
        return "T | " + super.getStatusIcon2() + " | " + super.getOnlyDescription();
    }
}
