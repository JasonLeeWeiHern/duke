public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }
    @Override
    public String getDescription() {
        return "[T]" + super.getDescription();
    } //Overide the get description method in Task
}
